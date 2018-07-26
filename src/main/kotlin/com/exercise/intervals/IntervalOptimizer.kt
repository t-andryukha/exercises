package com.exercise.intervals

class IntervalOptimizer {
    fun optimize(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) return intervals

        val optimizedIntervals = mutableListOf<IntArray>()
        var lastStart = intervals[0][0];
        var lastEnd = intervals[0][1];
        for (i in 1 until intervals.size) {
            val currInterval = intervals[i]
            if (currInterval[0] <= lastEnd) {
                lastEnd = currInterval[1]
            } else {
                optimizedIntervals.add(intArrayOf(lastStart, lastEnd))
                lastStart = currInterval[0]
                lastEnd = currInterval[1]
            }
        }
        optimizedIntervals.add(intArrayOf(lastStart, lastEnd))
        return optimizedIntervals.toTypedArray()
    }

}
