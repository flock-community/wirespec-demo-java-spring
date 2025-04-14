package com.example.demo;

import community.flock.wirespec.generated.GetTodoEndpoint;
import community.flock.wirespec.generated.GetUserEndpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class UserController implements GetUserEndpoint.Handler {

    private final TodoService service;

    @Override
    public CompletableFuture<GetUserEndpoint.Response<?>> getUser(GetUserEndpoint.Request request) {
        try {
            CompletableFuture<GetTodoEndpoint.Response<?>> resp = service.getById(request.getPath().id());
            GetTodoEndpoint.Response<?> response = resp.get();
            System.out.println(resp);
            System.out.println(response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return CompletableFuture.completedFuture(new GetUserEndpoint.Response200(null));
    }
}
