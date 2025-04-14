type TodoDto {
    id: Integer,
    task: String
}

endpoint GetTodo GET /api/todos/{id: Integer} -> {
    200 -> TodoDto
    400 -> String
}

endpoint CreateTodo POST String /api/todos #{token: String} -> {
    200 -> Unit
}
