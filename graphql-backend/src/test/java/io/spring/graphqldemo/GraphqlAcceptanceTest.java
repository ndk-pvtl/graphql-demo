package io.spring.graphqldemo;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@GraphQLTest
public class GraphqlAcceptanceTest {

    @Autowired
    GraphQLTestTemplate graphQLTestTemplate;

    @Test
    public void testAnonymousGreeting() {
        GraphQLResponse graphQLResponse = graphQLTestTemplate.postMultipart("query { anonymousGreeting }", "{}");
        assertThat(graphQLResponse.isOk()).isTrue();
        assertThat(graphQLResponse.get("data.anonymousGreeting")).isEqualTo("Hello, stranger!");
    }

    @Test
    public void testGreet() {
        GraphQLResponse graphQLResponse = graphQLTestTemplate.postMultipart("query { greet(name: \"Adam\") { message name } }", "{}");
        assertThat(graphQLResponse.isOk()).isTrue();
        assertThat(graphQLResponse.get("data.greet.message")).isEqualTo("Hello, ");
        assertThat(graphQLResponse.get("data.greet.name")).isEqualTo("Adam");
    }
}
