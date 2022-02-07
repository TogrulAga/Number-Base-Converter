fun main() {
    println(List(2) { readln().toBigDecimal() }.reduce { acc, bigDecimal -> acc * bigDecimal })
}