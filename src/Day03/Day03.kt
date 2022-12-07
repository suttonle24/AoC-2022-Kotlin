package Day03

import readInput


//--- Day 3: Rucksack Reorganization ---
//One Elf has the important job of loading all of the rucksacks with supplies for the jungle journey. Unfortunately, that Elf didn't quite follow the packing instructions, and so a few items now need to be rearranged.
//
//Each rucksack has two large compartments. All items of a given type are meant to go into exactly one of the two compartments. The Elf that did the packing failed to follow this rule for exactly one item type per rucksack.
//
//The Elves have made a list of all of the items currently in each rucksack (your puzzle input), but they need your help finding the errors. Every item type is identified by a single lowercase or uppercase letter (that is, a and A refer to different types of items).
//
//The list of items for each rucksack is given as characters all on a single line. A given rucksack always has the same number of items in each of its two compartments, so the first half of the characters represent items in the first compartment, while the second half of the characters represent items in the second compartment.
//
//For example, suppose you have the following list of contents from six rucksacks:
//
//vJrwpWtwJgWrhcsFMMfFFhFp
//jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
//PmmdzqPrVvPwwTWBwg
//wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
//ttgJtRGJQctTZtZT
//CrZsJsPPZsGzwwsLwLmpwMDw
//
//The first rucksack contains the items vJrwpWtwJgWrhcsFMMfFFhFp, which means its first compartment contains the items vJrwpWtwJgWr, while the second compartment contains the items hcsFMMfFFhFp. The only item type that appears in both compartments is lowercase p.
//The second rucksack's compartments contain jqHRNqRjqzjGDLGL and rsFMfFZSrLrFZsSL. The only item type that appears in both compartments is uppercase L.
//The third rucksack's compartments contain PmmdzqPrV and vPwwTWBwg; the only common item type is uppercase P.
//The fourth rucksack's compartments only share item type v.
//The fifth rucksack's compartments only share item type t.
//The sixth rucksack's compartments only share item type s.
//To help prioritize item rearrangement, every item type can be converted to a priority:
//
//Lowercase item types a through z have priorities 1 through 26.
//Uppercase item types A through Z have priorities 27 through 52.
//In the above example, the priority of the item type that appears in both compartments of each rucksack is 16 (p), 38 (L), 42 (P), 22 (v), 20 (t), and 19 (s); the sum of these is 157.
//
//Find the item type that appears in both compartments of each rucksack. What is the sum of the priorities of those item types?


fun main() {
    fun part1(input: List<String>): Int {
        val lcPriorities = mapOf(
            'a' to 1,
            'b' to 2,
            'c' to 3,
            'd' to 4,
            'e' to 5,
            'f' to 6,
            'g' to 7,
            'h' to 8,
            'i' to 9,
            'j' to 10,
            'k' to 11,
            'l' to 12,
            'm' to 13,
            'n' to 14,
            'o' to 15,
            'p' to 16,
            'q' to 17,
            'r' to 18,
            's' to 19,
            't' to 20,
            'u' to 21,
            'v' to 22,
            'w' to 23,
            'x' to 24,
            'y' to 25,
            'z' to 26
        );
        val ucPriorities = mapOf(
            'A' to 27,
            'B' to 28,
            'C' to 29,
            'D' to 30,
            'E' to 31,
            'F' to 32,
            'G' to 33,
            'H' to 34,
            'I' to 35,
            'J' to 36,
            'K' to 37,
            'L' to 38,
            'M' to 39,
            'N' to 40,
            'O' to 41,
            'P' to 42,
            'Q' to 43,
            'R' to 44,
            'S' to 45,
            'T' to 46,
            'U' to 47,
            'V' to 48,
            'W' to 49,
            'X' to 50,
            'Y' to 51,
            'Z' to 52
        );

        var left = mutableListOf<String>();
        var right = mutableListOf<String>();
        var sumOfItems = 0;

        val itr = input.listIterator();

        itr.forEach {
            left.add(it.substring(0, it.length / 2));
            right.add(it.substring(it.length / 2));
        }

        val leftItr = left.listIterator();

        for ((index, leftSide) in leftItr.withIndex()) {
            var priorityValue = 0;

            for (i in leftSide.indices) {
                if(right[index].contains(leftSide[i])) {
                    val commonLetter = leftSide[i];

                    if(commonLetter.isUpperCase()) {
                        priorityValue = ucPriorities.getValue(commonLetter);
                    } else {
                        priorityValue = lcPriorities.getValue(commonLetter);
                    }

                    break;
                }
            }

            sumOfItems += priorityValue;
        }

        return input.size
    }

    fun part2(input: List<String>): Int {

        return input.size
    }

    val input = readInput("Day03/Day03")
    println(part1(input))
    println(part2(input))
}
