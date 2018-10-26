package com.exercise.array.missing

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MissingNumberServiceTest {

    @Test
    internal fun shouldReturnMissingNumber() {
        val array = arrayOf(2,7,4,6,12,8,1,11,9,10,3)
        assertEquals(5, MissingNumberService().getMissingNumber(array))
    }

}