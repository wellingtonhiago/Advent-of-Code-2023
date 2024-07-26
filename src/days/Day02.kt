package days

import println
import readInput

fun main() {

    fun part1(input: List<String>): Int {
        return solvePart1()
    }

    fun part2(input: List<String>): Int {
        return solvePart2()
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

fun solvePart1() = 0

fun solvePart2() = 0