package com.exercise.array.majority

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class MajorityElementServiceTest {

    @Test
    internal fun `should return majority element`() {
        val array = arrayOf<Any>(1, 4, 4, 2, 4, 5, 4, 6, 4, 2, 4, 4)
        assertEquals(4, MajorityElementService().getMajorityElement(array));
    }

    @Test
    internal fun `should return null if no majority element found`() {
        val array = arrayOf<Any>(1, 4, 4, 2, 4, 5, 4, 6, 4, 2, 4, 6)
        assertNull(MajorityElementService().getMajorityElement(array));
    }
}