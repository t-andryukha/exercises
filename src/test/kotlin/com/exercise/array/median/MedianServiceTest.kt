package com.exercise.array.median

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MedianServiceTest {

    @Test
    internal fun `should return median element given odd num elements`() {
        val array = arrayOf(2,4,6,23,120,300,300,436,70)
        assertEquals(70, MedianService().findMedian(array))
    }

    @Test
    internal fun `should return median element given even num of elements`() {
        val array = arrayOf(2,4,6,23,120,300,300,436,70,1)
        assertEquals(23, MedianService().findMedian(array))
    }
}