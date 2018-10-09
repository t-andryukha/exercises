package com.exercise.line

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HusbandsWivesArrangerTest {

    @Test
    internal fun `should arrange correctly`() {
        val arrangedLine = listOf("H2", "W2", "H3", "W3", "H4", "W4", "H6", "W6")
        val randomComparator = Comparator { _: String, _: String -> if (Math.random() > 0.5) 1 else -1 }
        val randomLine = arrangedLine.sortedWith(randomComparator)
        assertEquals(arrangedLine, HusbandsWivesArranger().arrange(randomLine, true))
    }

    @Test
    internal fun `should arrange correctly in linear time given that wives and husbands start from 1 and increase by 1`() {
        val arrangedLine = listOf("H1", "W1", "H2", "W2", "H3", "W3", "H4", "W4")
        val randomComparator = Comparator { _: String, _: String -> if (Math.random() > 0.5) 1 else -1 }
        val randomLine = arrangedLine.sortedWith(randomComparator)
        assertEquals(arrangedLine, HusbandsWivesArranger().arrange(randomLine))
    }

    @Test
    internal fun `should arrange correctly mutating argument given that wives and husbands start from 1 and increase by 1`() {
        val arrangedLine = listOf("H1", "W1", "H2", "W2", "H3", "W3", "H4", "W4")
        val randomComparator = Comparator { _: String, _: String -> if (Math.random() > 0.5) 1 else -1 }
        val randomLine = arrangedLine.sortedWith(randomComparator)
        val randomLineArray = randomLine.toTypedArray()
        HusbandsWivesArranger().arrangeMutatingArgument(randomLineArray)
        assertEquals(arrangedLine.toTypedArray(), randomLineArray)
    }

}