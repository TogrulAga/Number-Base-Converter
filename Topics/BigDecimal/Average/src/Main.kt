import java.math.RoundingMode

fun main() {
    println(
        (List(3) { readln().toBigDecimal() }.reduce { acc, bigDecimal -> acc + bigDecimal } / 3.toBigDecimal())
            .setScale(0, RoundingMode.DOWN)
    )
}