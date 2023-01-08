package Day05

import readInput

fun main() {
    fun getStacks(input: List<String>): ArrayDeque<ArrayDeque<Char>> {

        val itr = input.listIterator();

        var stacks = ArrayDeque<ArrayDeque<Char>>();

        for ((i, line) in itr.withIndex()) {
            val lineArray = line.toCharArray();
            var currentStack = 1;

            for((j, char) in lineArray.withIndex()) {

                if(j !== 0 && j % 4 == 0) {
                    val thisChar = lineArray[j-3];
                    var thisStack = ArrayDeque<Char>();

                    // check to see if this stack has already been created
                    try {
                        thisStack = stacks[currentStack - 1];
                    } catch (ex : Exception) {
                        // Add the new stack because it doesn't yet exist
                        stacks.addLast(thisStack);
                    }

                    currentStack++;

                    if (lineArray[j-2] == ']') {
                        thisStack.addLast(thisChar);
                    }
                } else if(j == lineArray.size - 1) {
                    val thisChar = lineArray[j-1];
                    var thisStack = ArrayDeque<Char>();

                    // check to see if this stack has already been created
                    try {
                        thisStack = stacks[currentStack - 1];
                    } catch (ex : Exception) {
                        // Add the new stack because it doesn't yet exist
                        stacks.addLast(thisStack);
                    }
                    if (lineArray[j] == ']') {
                        thisStack.addLast(thisChar);
                    }
                    break;
                }
            }

            if (line.length == 0) {
                break;
            }
        }

        return stacks;
    }

    fun instructionParser(instructionString: String): ArrayDeque<Int> {
        val instructionArray = instructionString.split(' ');
        var instructions = ArrayDeque<Int>();

        instructions.addLast(Integer.parseInt(instructionArray[1])); // "amount"
        instructions.addLast(Integer.parseInt(instructionArray[3])); // "from"
        instructions.addLast(Integer.parseInt(instructionArray[5])); // "to"

        return instructions;
    }

    fun getInstructions(input: List<String>): ArrayDeque<ArrayDeque<Int>> {
        val itr = input.listIterator();

        var instructions = ArrayDeque<ArrayDeque<Int>>();

        for ((i, line) in itr.withIndex()) {
            if(line.contains("move")){
                instructions.addLast(instructionParser(line));
            }
        }

        return instructions;
    }

    fun printAnswer(stacks: ArrayDeque<ArrayDeque<Char>>) {
        var answer = "";
        stacks.map {
            var topChar = it[0];
            answer += topChar;
        }

        println(answer);
    }

    fun part1(input: List<String>): Int {

        fun processStacks(
            stacks: ArrayDeque<ArrayDeque<Char>>,
            instructions: ArrayDeque<ArrayDeque<Int>>) {

            for ((i, instruction) in instructions.withIndex()) {
                val move = instruction[0];
                val from = instruction[1] - 1; // account for zero-index
                val to = instruction[2] - 1;   // account for zero-index

                for(i in 1 .. move) {
                    stacks[to].addFirst(stacks[from].removeFirst());
                }
            }

        }

        var stacks: ArrayDeque<ArrayDeque<Char>> = getStacks(input);
        var instructions: ArrayDeque<ArrayDeque<Int>> = getInstructions(input);

        processStacks(stacks, instructions);

        printAnswer(stacks);

        return input.size
    }

    fun part2(input: List<String>): Int {

        fun processStacks(
            stacks: ArrayDeque<ArrayDeque<Char>>,
            instructions: ArrayDeque<ArrayDeque<Int>>) {

            for ((i, instruction) in instructions.withIndex()) {
                val move = instruction[0];
                val from = instruction[1] - 1; // account for zero-index
                val to = instruction[2] - 1;   // account for zero-index
                var tempStack = ArrayDeque<Char>();



                for(i in 1 .. move) {
                    tempStack.addLast(stacks[from].removeFirst());
                }
                stacks[to] = ArrayDeque<Char>(tempStack + stacks[to]);
            }

        }

        var stacks: ArrayDeque<ArrayDeque<Char>> = getStacks(input);
        var instructions: ArrayDeque<ArrayDeque<Int>> = getInstructions(input);

        processStacks(stacks, instructions);

        printAnswer(stacks);

        return input.size
    }

    val input = readInput("Day05/Day05")
    println(part1(input))
    println(part2(input))
}
