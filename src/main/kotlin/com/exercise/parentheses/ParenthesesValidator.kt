package com.exercise.parentheses

import java.util.*

class ParenthesesValidator {
    fun isBalanced(parentheses: String): Boolean {
        val openParenthesesStack = Stack<Char>()
        for (currentParenthesis in parentheses.toCharArray()) {
            if (currentParenthesis.isStart()) {
                openParenthesesStack.push(currentParenthesis)
            } else {
                if (openParenthesesStack.pop().getEndParenthesis() != currentParenthesis) return false
            }
        }
        return true
    }

}

private fun Char.getEndParenthesis(): Char {
    return Brace.fromStartBrace(this)?.endBrace ?: ' '
}

private fun Char.isStart(): Boolean {
    return Brace.fromStartBrace(this) != null
}

enum class Brace(val startBrace: Char, val endBrace: Char) {
    CURLY('(', ')'), CURVE('{', '}'), SQUARE('[', ']');

    companion object {
        private val lookupMap = Brace.values().associateBy(Brace::startBrace)
        fun fromStartBrace(startBrace: Char) = lookupMap[startBrace]
    }
}

