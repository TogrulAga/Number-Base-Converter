import java.math.BigInteger

fun main() {
    val number1 = BigInteger(readln())
    val number2 = BigInteger(readln())

    val gcd = number1.gcd(number2)

    println(number1 * number2 / gcd)
}