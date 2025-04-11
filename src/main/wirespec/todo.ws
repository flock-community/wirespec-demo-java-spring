type TodoDto {
    id: Integer,
    name: String
}

endpoint GetTodo GET /api/todos/{id: Integer} -> {
    200 -> TodoDto
    400 -> String
}
