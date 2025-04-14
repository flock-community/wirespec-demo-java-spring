package community.flock.demo.client;

import community.flock.wirespec.generated.CreateTodoEndpoint;
import community.flock.wirespec.generated.GetTodoEndpoint;
import community.flock.wirespec.integration.spring.java.client.WirespecWebClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TodoService {

    private final WirespecWebClient webClient;

    public TodoService(WirespecWebClient webClient) {
        this.webClient = webClient;
    }

    public CompletableFuture<GetTodoEndpoint.Response<?>> getById(long id) {
        return webClient.send(new GetTodoEndpoint.Request(id));
    }

    public CompletableFuture<GetTodoEndpoint.Response<?>> createTodo(long id) {
        return webClient.send(new CreateTodoEndpoint.Request("",""));
    }
}
