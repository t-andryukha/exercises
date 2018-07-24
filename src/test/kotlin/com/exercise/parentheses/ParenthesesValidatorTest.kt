package com.exercise.parentheses

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Write a program to determine if the the parentheses (),
the brackets [], and the braces {}, in a string are balanced.

For example:

{{)(}} is not balanced because ) comes before (

({)} is not balanced because ) is not balanced between {}
and similarly the { is not balanced between ()

[({})] is balanced

{}([]) is balanced

{()}[[{}]] is balanced
 */
internal class ParenthesesValidatorTest {

    @Test
    internal fun `should be not balanced when ) comes before (`() {
        assertFalse(ParenthesesValidator().isBalanced("{{)(}}"))
    }

    @Test
    internal fun `should be not balanced when ) is not balanced between {}`() {
        assertFalse(ParenthesesValidator().isBalanced("({)}"))
    }

    @Test
    internal fun `should be balanced #1`() {
        assertTrue(ParenthesesValidator().isBalanced("[({})]"))
    }

    @Test
    internal fun `should be balanced #2`() {
        assertTrue(ParenthesesValidator().isBalanced("{}([])"))
    }

    @Test
    internal fun `should be balanced #3`() {
        assertTrue(ParenthesesValidator().isBalanced("{()}[[{}]]"))
    }

}