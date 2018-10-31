package com.exercise.array.median

class MedianService {

    /**
     * Median is a middle element of the array when it's sorted
     */
    fun findMedian(array: Array<Int>): Int {
        val searchIndex = (array.size - 1) / 2
        return findElement(array.toList(), searchIndex)
    }

    private fun findElement(list: List<Int>, searchIndex: Int): Int {
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()
        val pivotElement = list[searchIndex]//using searchIndex for pivot to find faster in sorted array
        for ((index, element) in list.withIndex()) {
            if (index == searchIndex) continue
            if (element > pivotElement) {
                right.add(element)
            } else {
                left.add(element)
            }
        }
        val pivotIndex = left.size

        return when {
            pivotIndex == searchIndex -> pivotElement
            searchIndex < pivotIndex -> findElement(left, searchIndex)
            else -> findElement(right, searchIndex - pivotIndex-1)
        }
    }

}
