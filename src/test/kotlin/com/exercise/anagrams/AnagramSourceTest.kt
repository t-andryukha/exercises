package com.exercise.anagrams

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AnagramSourceTest {

    @Test
    fun shouldGenerateCorrectAnagrams() {
        val anagram = AnagramSource("biro")
        val expectedAnagrams = setOf("biro", "bior", "brio", "broi", "boir", "bori", "ibro", "ibor", "irbo", "irob", "iobr", "iorb", "rbio", "rboi", "ribo", "riob", "roib", "robi", "obir", "obri", "oibr", "oirb", "orbi", "orib")
        assertEquals(expectedAnagrams, anagram.anagrams)


    }
}