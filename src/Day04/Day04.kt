package Day04

import readInput

fun main() {
    fun part1(input: List<String>): Int {

        var fullContainments = 0;

        val itr = input.listIterator();

        itr.forEach {
            var leftStr = "";
            var leftLow = 0;
            var leftHigh = 0;
            var rightStr = "";
            var rightLow = 0;
            var rightHigh = 0;

            leftStr = it.substring(0, it.indexOf(','));
            rightStr = it.substring(it.indexOf(',') + 1, it.length);

            leftLow = leftStr.substring(0, leftStr.indexOf('-')).toInt();
            leftHigh = leftStr.substring(leftStr.indexOf('-') + 1, leftStr.length).toInt();

            rightLow = rightStr.substring(0, rightStr.indexOf('-')).toInt();
            rightHigh = rightStr.substring(rightStr.indexOf('-') + 1, rightStr.length).toInt();

            if (leftLow <= rightLow && leftHigh >= rightHigh) {
                fullContainments++;
            } else if (leftLow >= rightLow && leftHigh <= rightHigh) {
                fullContainments++;
            }
        }

        println("Total full containments: $fullContainments");

        return input.size
    }

    fun part2(input: List<String>): Int {

        return input.size
    }

    val input = readInput("Day04/Day04")
    println(part1(input))
    println(part2(input))
}
