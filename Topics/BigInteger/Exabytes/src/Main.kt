import java.math.BigInteger

fun main() {
    val n = readln().toBigInteger()
    val exabyte = BigInteger("9223372036854775808")

    println("${n * exabyte}")
}