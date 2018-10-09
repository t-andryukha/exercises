package com.exercise.line

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HusbandsWivesArrangerTest {

    @Test
    internal fun `should arrange correctly`() {
        val arrangedLine = listOf("H2", "W2", "H3", "W3", "H4", "W4", "H6", "W6")
        val randomComparator = Comparator { o1: String, o2: String -> if (Math.random() > 0.5) 1 else -1 }
        val randomLine = arrangedLine.sortedWith(randomComparator)
        assertEquals(arrangedLine, HusbandsWivesArranger().arrange(randomLine, true))
    }

    @Test
    internal fun `should arrange correctly in linear time`() {
        val arrangedLine = listOf("H2", "W2", "H3", "W3", "H4", "W4", "H6", "W6")
        val randomComparator = Comparator { o1: String, o2: String -> if (Math.random() > 0.5) 1 else -1 }
        val randomLine = arrangedLine.sortedWith(randomComparator)
        assertEquals(arrangedLine, HusbandsWivesArranger().arrange(randomLine))
    }

}