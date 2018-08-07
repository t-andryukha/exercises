package com.exercise.array.max

class RotatedArrayService {
    /**
     * Given sorted rotated array find max in logarithmic time (O(logn))
     */
    fun findMax(array: Array<Int>): Int {
        if (array.isEmpty()) return Int.MIN_VALUE
        val notRotated = array.last() > array.first()
        if (notRotated) return array.last()
        return findMax(array, 0, array.size - 1)
    }

    private tailrec fun findMax(array: Array<Int>, start: Int, end: Int): Int {
        val mid = (start + end) / 2
        if (array[mid] > array[mid + 1]) return array[mid]

        return if (array[mid + 1] < array[start]) {
            findMax(array, start, mid - 1)
        } else {
            findMax(array, mid + 1, end)
        }
    }

}
