package com.exercise.array.shuffle

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

/**
The shuffle function
o) does not mutate the array argument
o) returns an array
o) the returned array is randomly shuffled!
o) the returned array is a permutation of the array argument
 */
class ArrayShufflerTest {

    private val sourceArray = arrayOf(1, 2, 3, "four", 5, 6, "seven")

    @Test
    fun shouldNotMutateArgument() {
        val clonedSourceArray = sourceArray.clone()
        ArrayShuffler(RandomGenerator()).shuffle(sourceArray)
        assertEquals(clonedSourceArray.toList(), sourceArray.toList())

    }

    @Test
    fun shouldReturnRandomlyShuffledArray() {
        val shuffled1 = ArrayShuffler(RandomGenerator()).shuffle(sourceArray)
        val shuffled2 = ArrayShuffler(RandomGenerator()).shuffle(sourceArray)
        assertNotEquals(sourceArray, shuffled1)
        assertNotEquals(sourceArray, shuffled2)
        assertNotEquals(shuffled1, shuffled2)
    }

    @Test
    fun shouldReturnPermutationOfTheGivenArray() {
        val shuffledArray = ArrayShuffler(RandomGenerator()).shuffle(sourceArray)
        shuffledArray.forEach { assertTrue(sourceArray.contains(it)) }
        sourceArray.forEach { assertTrue(shuffledArray.contains(it)) }
    }


}