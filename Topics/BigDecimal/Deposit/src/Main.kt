import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.pow

fun main() {
    val money = readln().toBigDecimal()
    val percentage = readln().toBigDecimal()
    val years = readln().toInt()

    println(
        "Amount of money in the account: ${(
            money * (BigDecimal.ONE + percentage.setScale(2, RoundingMode.FLOOR) / 100.toBigDecimal())
                .pow(years)
            )
            .setScale(2, RoundingMode.CEILING)}"
    )
}