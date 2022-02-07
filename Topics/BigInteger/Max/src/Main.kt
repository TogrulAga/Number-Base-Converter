import java.math.BigInteger

fun main() {
    val (a, b) = List(2) { readln().toBigInteger() }

    println((a + b + (a - b).abs()) / BigInteger("2"))
}