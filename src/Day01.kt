fun main() {


    fun part1(input: List<String>): Int {
        return solvePart1(input)
    }

    fun part2(input: List<String>): Int {
        return solvePart2(input)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 142)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()



}

val words: Map<String, Int> = mapOf(
    "one" to 1,
    "two" to 2,
    "three" to 3,
    "four" to 4,
    "five" to 5,
    "six" to 6,
    "seven" to 7,
    "eight" to 8,
    "nine" to 9
)

fun String.possibleWordsAt(startingAt: Int): List<String> =
    (3..5).map { len ->
        substring(startingAt, (startingAt + len).coerceAtMost(length))
    }

fun calibrationValue(row: String): Int =
    "${row.first { it.isDigit() }}${row.last { it.isDigit() }}".toInt()

fun solvePart1(input: List<String>): Int =
    input.sumOf { calibrationValue(it) }

fun solvePart2(input: List<String>): Int =
    input.sumOf { row ->
        calibrationValue(
            row.mapIndexedNotNull { index, c ->
                if (c.isDigit()) c
                else
                    row.possibleWordsAt(index).firstNotNullOfOrNull { candidate ->
                        words[candidate]
                    }
            }.joinToString()
        )
    }
