package com.exercise.gcd

/**
 * Find Greatest Common Denominator for 2 numbers
 */
class GCDFinder {
    fun find(num1: Int, num2: Int): Int {
        val smallestNum = Math.min(num1, num2)
        val greatestNum = Math.max(num1, num2)
        return findRecursively(smallestNum, greatestNum)
    }

    /**
     * Euclid's algorithm
     */
    private tailrec fun findRecursively(num1: Int, num2: Int): Int {
        if (num2 % num1 == 0) return num1
        return findRecursively(num2%num1, num2)
    }

    /**
     * Euclid's algorithm in iterative form
     */
    private fun findIteratively(num1: Int, num2: Int): Int {
        println("for $num1 and $num2 divisors are:")
        val smallestNum = Math.min(num1, num2)
        val greatestNum = Math.max(num1, num2)
        var divisor = smallestNum
        while (divisor > 1) {
            println("   $divisor")
            if (num1 % divisor == 0 && num2 % divisor == 0) return divisor
            divisor = greatestNum % divisor
        }
        return 1
    }

}
