package com.davidagood.graphql.schema;

import com.davidagood.graphql.repository.AuthorRepository;
import com.davidagood.graphql.repository.BookRepository;
import com.davidagood.graphql.resolver.Resolvers;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Configuration
class Schema {

    @Bean
    GraphQL graphQL(RuntimeWiring runtimeWiring) throws URISyntaxException {
        File schemaFile = Path.of(getClass().getClassLoader().getResource("schema.graphql").toURI()).toFile();
        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schemaFile);
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
        return GraphQL.newGraphQL(graphQLSchema).build();
    }

    @Bean
    RuntimeWiring runtimeWiring(Resolvers resolvers,
                                BookRepository bookRepository,
                                AuthorRepository authorRepository) {
        return RuntimeWiring.newRuntimeWiring()
            .type(newTypeWiring("Query")
                .dataFetcher("book", resolvers.queryBook(bookRepository))
                .dataFetcher("author", resolvers.queryAuthor(authorRepository)))
            .type(newTypeWiring("Book")
                .dataFetcher("author", resolvers.getAuthorForBook(authorRepository)))
            .build();
    }
}
