package com.example.demo;

import community.flock.wirespec.generated.GetTodoEndpoint;
import community.flock.wirespec.generated.TodoDto;
import community.flock.wirespec.integration.spring.java.client.WirespecWebClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TodoService implements GetTodoEndpoint.Handler {

    private final WirespecWebClient webClient;

    public TodoService(WirespecWebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public CompletableFuture<GetTodoEndpoint.Response<?>> getTodo(GetTodoEndpoint.Request request) {
        return webClient.send(request);
    }
}
