package com.exercise.array.missing

class MissingNumberService {

    fun getMissingNumber(array: Array<Int>, repetitionTimes: Int = 1): Int {
        var xorSum = 0
        for (repetition in 1..repetitionTimes) {
            for (sequentialNumber in 1..(array.size + 1) / repetitionTimes) {
            xorSum = xorSum.xor(sequentialNumber)
        }
        }
        for (actualNumber in array) {
            xorSum = xorSum.xor(actualNumber)
        }
        return xorSum
    }

}
