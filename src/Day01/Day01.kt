package Day01

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        var highestTotal = 0;
        var index = 0;
        var indexWithHighest = 0;
        var currentTotal = 0;

        val itr = input.listIterator();
        while (itr.hasNext()) {
            var cal = 0;

            cal = try {
                itr.next().toInt();
            } catch (nfe: NumberFormatException) {
                0;
            }

            if(cal > 0) {
                currentTotal += cal;
            } else {
                if(highestTotal < currentTotal) {
                    highestTotal = currentTotal;
                    indexWithHighest = index;
                }
                currentTotal = 0;
                index++;
            }
        }

        println(highestTotal);
        println(indexWithHighest);

        return input.size
    }

    val input = readInput("Day01/Day01")
    println(part2(input))
}
