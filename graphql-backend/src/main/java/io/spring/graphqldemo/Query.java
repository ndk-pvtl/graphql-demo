package io.spring.graphqldemo;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    public Greeting greet(String name) {
        return Greeting.builder().message("Hello, ").name(name).build();
    }

    public String anonymousGreeting() {
        return "Hello, stranger!";
    }
}