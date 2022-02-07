fun main() {
    val (a, b) = List(2) { readln().toBigInteger() }
    val (q, r) = a.divideAndRemainder(b)

    println("$a = $b * $q + $r")

}