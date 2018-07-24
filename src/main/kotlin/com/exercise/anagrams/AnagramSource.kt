package com.exercise.anagrams

import java.util.concurrent.atomic.AtomicInteger

private fun CharArray.swap(firstSwapIndex: Int, secondSwapIndex: Int) {
    val bufferElement = this[firstSwapIndex]
    this[firstSwapIndex] = this[secondSwapIndex]
    this[secondSwapIndex] = bufferElement
}

/**
 Write a program to generate all potential
anagrams of an input string.

For example, the potential anagrams of "biro" are

biro bior brio broi boir bori
ibro ibor irbo irob iobr iorb
rbio rboi ribo riob roib robi
obir obri oibr oirb orbi orib

 */
class AnagramSource(inputString: String, private val counter: AtomicInteger = AtomicInteger()) {
    val anagrams: Set<String>;

    init {
        val originalPhrase: CharArray = inputString.toCharArray()
        anagrams = generateAnagrams(originalPhrase)
    }

    private fun generateAnagrams(
            originalPhrase: CharArray,
            elementsToShuffle: Int = originalPhrase.size,
            result: HashSet<String> = HashSet(factorial(originalPhrase.size))): HashSet<String> {

        for (i in 1..elementsToShuffle) {
            val phraseLength = originalPhrase.size
            val firstSwapIndex = phraseLength - elementsToShuffle
            val secondSwapIndex = phraseLength - i
            var currentPhrase = originalPhrase
            if (firstSwapIndex != secondSwapIndex) {
                println("${counter.incrementAndGet()} cloning char array")
                currentPhrase = originalPhrase.clone()
                currentPhrase.swap(firstSwapIndex, secondSwapIndex)
            }
            if (elementsToShuffle <= 2) {
                result.add(currentPhrase.joinToString(separator = "") { it.toString() })
            } else {
                generateAnagrams(currentPhrase, elementsToShuffle - 1, result)
            }
        }
        return result;
    }

    private tailrec fun factorial(number: Int, result: Int = number): Int {
        if (number == 1) return result
        return factorial(number - 1, result * number)
    }

}
