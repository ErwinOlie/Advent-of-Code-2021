val input = object {}.javaClass.getResource("input.txt")!!.readText()
    .lines()
    .map { it.toInt() }

fun main() {
    val answer1 = input
        .windowed(2)
        .count { it[1] > it[0] }
    println(answer1)

    val answer2 = input
        .windowed(3)
        .map { it.sum() }
        .windowed(2)
        .count { it[1] > it[0] }
    println(answer2)
}
