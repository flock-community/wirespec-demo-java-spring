package com.example.demo;

import community.flock.wirespec.generated.GetUserEndpoint;
import community.flock.wirespec.generated.UserDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class UserController implements GetUserEndpoint.Handler {

    @Override
    public CompletableFuture<GetUserEndpoint.Response<?>> getUser(GetUserEndpoint.Request request) {
        UserDto dto = new UserDto(request.getPath().id(), "MyName");
        return CompletableFuture.completedFuture(new GetUserEndpoint.Response200(dto));
    }
}
