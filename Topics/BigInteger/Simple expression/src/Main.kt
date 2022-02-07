fun main() {
    val (a, b, c, d) = List(4) { readln().toBigInteger() }

    println("${-a * b + c - d}")
}