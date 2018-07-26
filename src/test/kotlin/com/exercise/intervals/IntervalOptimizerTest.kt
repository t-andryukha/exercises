package com.exercise.intervals

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

internal class IntervalOptimizerTest {

    @Test
    internal fun shouldMergeOverlappingIntervals() {
        val optimizedIntervals = arrayOf(
                intArrayOf(1, 6),
                intArrayOf(8, 10)
        )
        val intervals = arrayOf(
                intArrayOf(1, 4),
                intArrayOf(3, 6),
                intArrayOf(8, 10)
        )
        assertEquals(Arrays.deepToString(optimizedIntervals), Arrays.deepToString(IntervalOptimizer().optimize(intervals)))
    }

    @Test
    internal fun shouldMergeCorrectlyLastInterval() {
        val optimizedIntervals = arrayOf(
                intArrayOf(1, 3),
                intArrayOf(4, 6),
                intArrayOf(8, 12)
        )
        val intervals = arrayOf(
                intArrayOf(1, 3),
                intArrayOf(4, 6),
                intArrayOf(8, 10),
                intArrayOf(9, 12)
        )
        assertEquals(Arrays.deepToString(optimizedIntervals), Arrays.deepToString(IntervalOptimizer().optimize(intervals)))
    }

    @Test
    internal fun shouldMergeNegativeIntervals() {
        val optimizedIntervals = arrayOf(
                intArrayOf(-7, -4),
                intArrayOf(-3, 6),
                intArrayOf(8, 10)
        )
        val intervals = arrayOf(
                intArrayOf(-7, -4),
                intArrayOf(-3, 6),
                intArrayOf(8, 10)
        )
        assertEquals(Arrays.deepToString(optimizedIntervals), Arrays.deepToString(IntervalOptimizer().optimize(intervals)))
    }

}
