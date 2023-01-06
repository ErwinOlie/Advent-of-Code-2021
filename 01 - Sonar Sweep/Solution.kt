package nl.erwinolie.`Advent-of-Code-2021`.`01 - Sonar Sweep`

import nl.erwinolie.extensions.input

val input = input()
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
