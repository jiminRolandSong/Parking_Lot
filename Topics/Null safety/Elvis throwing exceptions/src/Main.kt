fun main() {
    val line = readlnOrNull() // you need to add something
        ?: throw IllegalStateException()
    print("Elvis says: $line")
}
