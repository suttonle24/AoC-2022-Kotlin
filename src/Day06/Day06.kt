package Day06

import readInput

fun main() {
    fun getFirstPacketMarker(input: CharArray): Int {
        for ((i, char) in input.withIndex()) {
            if (i > 3) {
                if (input[i] != input[i-1] &&   // i
                    input[i] != input[i-2] &&   // i
                    input[i] != input[i-3] &&   // i
                    input[i-1] != input[i] &&   // i-1
                    input[i-1] != input[i-2] && // i-1
                    input[i-1] != input[i-3] && // i-1
                    input[i-2] != input[i] &&   // i-2
                    input[i-2] != input[i-1] && // i-2
                    input[i-2] != input[i-3] && // i-2
                    input[i-3] != input[i] &&   // i-3
                    input[i-3] != input[i-1] && // i-3
                    input[i-3] != input[i-2]) { // i-3
                    return i+1;
                }
            }
        }

        return 0;
    }

    fun hasDuplicates(list: List<Char>): Boolean {
        return list.size != list.distinct().count();
    }

    fun msgDetector(input: CharArray, lookback: Int): Int {
        var charIndex = 0;
        for ((i, char) in input.withIndex()) {
            if (i > lookback) {
                val checkSet = input.slice(IntRange(i - lookback + 1, i));

                if(!hasDuplicates(checkSet)) {
                    charIndex = i;
                    break;
                }
            }
        }

        return if(charIndex != 0) {
            charIndex + 1;
        } else {
            charIndex;
        }
    }

    fun part1(input: List<String>): Int {

        val firstPacketMarker: Int = getFirstPacketMarker(input.get(0).toCharArray());

        println(firstPacketMarker);

        return input.size
    }

    fun part2(input: List<String>): Int {

        val firstMsgMarker = msgDetector(input.get(0).toCharArray(), 14);

        println(firstMsgMarker);

        return input.size
    }

    val input = readInput("Day06/Day06input")
    println(part1(input))
    println(part2(input))
}
