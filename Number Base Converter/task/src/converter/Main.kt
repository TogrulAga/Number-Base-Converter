package converter

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.pow

fun main() {
    val converter = Converter()
    converter.convert()
}

class Converter {
    private var direction: String = ""
    private var number10: BigDecimal = BigDecimal("0")
    private var sourceNumber: String = ""
    private var sourceBase: Int = 0
    private var targetBase: Int = 0
    private val hexNumbers: String = ('0'..'9').joinToString("") + ('a'..'z').joinToString("")

    fun convert() {
        print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ")
        direction = readln()

        while (direction != "/exit") {
            if (direction.split(" ").count() == 2) {
                sourceBase = direction.split(" ")[0].toInt()
                targetBase = direction.split(" ")[1].toInt()

                if (sourceBase in 2..36 && targetBase in 2..36) {
                    convertSourceToTarget()
                }
            }

            print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ")
            direction = readln()
        }
    }

    private fun convertSourceToTarget() {
        print("Enter number in base $sourceBase to convert to base $targetBase (To go back type /back) ")
        sourceNumber = readln()

        while (sourceNumber != "/back") {
            convertToDecimal()
            convertFromDecimal()

            print("Enter number in base $sourceBase to convert to base $targetBase (To go back type /back) ")
            sourceNumber = readln()
        }
    }

    private fun convertToDecimal(){
        number10 = BigDecimal("0")

        for ((i, digit) in sourceNumber.split(".")[0].reversed().withIndex()) {
            number10 += hexNumbers.indexOf(digit).toBigDecimal() * BigDecimal.valueOf(sourceBase.toDouble().pow(i.toDouble()).toLong())
        }

        if (sourceNumber.split(".").count() != 2) return

        if (sourceNumber.split(".")[1].all { it == '0' }) {
            number10 += ("0." + sourceNumber.split(".")[1]).toBigDecimal()
            return
        }

        for ((i, digit) in sourceNumber.split(".")[1].withIndex()) {
            number10 += hexNumbers.indexOf(digit).toBigDecimal() * BigDecimal.valueOf(sourceBase.toDouble().pow(-(i + 1)))
            number10 = number10.setScale(5, RoundingMode.HALF_UP)
        }
    }

    private fun convertFromDecimal() {
        var result = ""

        var (integer, franctional) = number10.divideAndRemainder(BigDecimal.ONE)

        while (true) {
            val remainder = (integer % targetBase.toBigDecimal()).toInt()
            result += hexNumbers[remainder]

            if (integer >= targetBase.toBigDecimal()) {
                integer = integer.divide(targetBase.toBigDecimal(), RoundingMode.FLOOR)
            } else {
                break
            }
        }

        if (franctional == BigDecimal.ZERO) {
            println("Conversion result: ${result.reversed()}\n")
            return
        }

        result = result.reversed() + "."

        for (i in 0..4) {
            val (whole, fraction) = (franctional * targetBase.toBigDecimal()).divideAndRemainder(BigDecimal.ONE)

            if (whole != BigDecimal.ONE && fraction != BigDecimal.ZERO) {
                result += hexNumbers[whole.toInt()]
                franctional = fraction
                continue
            }
        }

        println("Conversion result: $result\n")
    }
}