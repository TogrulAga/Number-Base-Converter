fun main() {
    println(List(3) { readln().toBigDecimal() }.reduce { acc, bigDecimal -> acc + bigDecimal })
}