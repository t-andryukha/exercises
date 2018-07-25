package com.exercise.gcd

class GCDFinder {
    fun find(num1: Int, num2: Int): Int {
        for (divisor in Math.min(num1, num2) downTo 1) {
            if (num1 % divisor == 0 && num2 % divisor == 0) return divisor
        }
        return 1
    }

}
