fun main() {
    val answer : Int =
        try { readLine()!!.toInt() }
        catch (e: Exception){ 42}
        finally { println("The answer is a number") }
    println(answer)
}