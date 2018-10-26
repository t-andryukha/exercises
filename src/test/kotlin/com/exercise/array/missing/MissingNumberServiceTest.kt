package com.exercise.array.missing

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MissingNumberServiceTest {

    @Test
    internal fun shouldReturnMissingNumber() {
        val array = arrayOf(2,7,4,6,12,8,1,11,9,10,3)
        assertEquals(5, MissingNumberService().getMissingNumber(array))
    }

    @Test
    internal fun shouldReturnMissingNumberWhenRepeated4TimesAgainst5() {
        val array = arrayOf(2,7,4,6,7,12,8,1,11,9,1,3,5,2,7,4,6,12,10,8,1,11,9,10,2,7,4,6,12,3,11,9,10,3,5,2,4,5,6,12,8,1,11,9,10,3,5,2,7,4,6,12,8,1,11,9,10,3,8)
        assertEquals(5, MissingNumberService().getMissingNumber(array, 5))
    }

}