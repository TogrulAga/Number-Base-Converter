import java.math.BigInteger

fun main() {
    val (number1, number2) = List(2) { BigInteger(readln()) }
    val sum = number1 + number2

    println("${number1 * BigInteger("100") / sum }% ${number2 * BigInteger("100") / sum }%")
}