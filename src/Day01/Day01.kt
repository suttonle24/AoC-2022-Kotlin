package Day01

import readInput

fun main() {
    fun part1(input: List<String>): Int {
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

    fun part2(input: List<String>): Int {
        var topThreeTotal = 0;

        var totals = mutableListOf<Int>();

        val itr = input.listIterator();

        var count = 0;

        while (itr.hasNext()) {
            var current = 0;
            current = try {
                itr.next().toInt();
            } catch (nfe: NumberFormatException) {
                0;
            }

            if(current > 0) {
                count += current
            } else {
                totals.add(count)
                count = 0
            }
        }

        totals.sortDescending();

        topThreeTotal = totals.get(0) + totals.get(1) + totals.get(2);

        println("total: $topThreeTotal")

        return input.size
    }

    val input = readInput("Day01/Day01")
    println(part1(input))
    println(part2(input))
}
