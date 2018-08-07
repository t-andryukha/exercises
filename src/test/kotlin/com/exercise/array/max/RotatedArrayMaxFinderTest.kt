package com.exercise.array.max

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RotatedArrayMaxFinderTest {
    @Test
    internal fun `should find max for rotated array`() {
        assertEquals(50,RotatedArrayService().findMax(arrayOf(40,45,50,4,8,23,25)))
    }

    @Test
    internal fun `should find max when it's the first`() {
        assertEquals(400,RotatedArrayService().findMax(arrayOf(400,3,5,7,25,100,150,300)))
    }

    @Test
    internal fun `should find max for not rotated array`() {
        assertEquals(300,RotatedArrayService().findMax(arrayOf(3,5,7,25,100,150,300)))
    }
}