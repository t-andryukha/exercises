package com.exercise.gcd

class GCDFinder {
    fun find(num1: Int, num2: Int): Int {
        return findIteratively(num1, num2)
    }

    private fun findRecursively(num1: Int, num2: Int): Int {
        TODO()
    }

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
