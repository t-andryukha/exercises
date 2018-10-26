package com.exercise.array.missing

class MissingNumberService {

    fun getMissingNumber(array: Array<Int>): Int {
        var xorSum = 0
        for (sequentialNumber in 1 .. array.size+1) {
            xorSum = xorSum.xor(sequentialNumber)
        }
        for (actualNumber in array) {
            xorSum = xorSum.xor(actualNumber)
        }
        return xorSum
    }

}
