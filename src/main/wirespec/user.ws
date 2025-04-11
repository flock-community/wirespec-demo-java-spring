type UserDto {
    id: Integer,
    name: String
}

endpoint GetUser GET /api/users/{id: Integer} -> {
    200 -> UserDto
    400 -> String
}
