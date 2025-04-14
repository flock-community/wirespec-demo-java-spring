package community.flock.demo.provider;

import community.flock.wirespec.generated.GetTodoEndpoint;
import community.flock.wirespec.generated.TodoDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.*;

@RestController
class TodoController implements GetTodoEndpoint.Handler {

    @Override
    public CompletableFuture<GetTodoEndpoint.Response<?>> getTodo(GetTodoEndpoint.Request request) {
        TodoDto dto = new TodoDto(request.getPath().id(), "Create a Wirespec definition");
        return completedFuture(new GetTodoEndpoint.Response200(dto));
    }
}
