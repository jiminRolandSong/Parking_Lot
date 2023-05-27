fun isNumber(input: String) : Any {
    val num = input.toIntOrNull()
    return (num ?: input)
} // write this function