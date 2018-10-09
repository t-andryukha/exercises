package com.exercise.line

import java.util.*

class HusbandsWivesArranger {

    fun arrange(randomLine: List<String>, spaceOverTimePriority: Boolean = false) = if (spaceOverTimePriority) {
        arrangeInNLogNTimeAndConstantSpace(randomLine)
    } else {
        arrangeInLinearTimeAndLinearSpace(randomLine)
    }


    private fun arrangeInLinearTimeAndLinearSpace(randomLine: List<String>): List<String> {
        //todo you know how many wives/husbands will be but you don't know the maximum husband index

        TODO()
    }

    private fun arrangeInNLogNTimeAndConstantSpace(randomLine: List<String>): List<String> {
        val sortedLine = randomLine.sorted().toTypedArray()

        val arrangedLine = ArrayList<String>(sortedLine.size)

        for (index in sortedLine.indices) {
            if (index >= sortedLine.size / 2) break;
            arrangedLine.add(sortedLine[index])
            arrangedLine.add(sortedLine[sortedLine.size / 2 + index])
        }
        return arrangedLine
    }

}

enum class Spouse(val prefix: String) {
    HUSBAND("H"), WIFE("W");
}

private fun <T> Array<T>.swap(index1: Int, index2: Int) {
    if (index1 >= this.size || index2 >= this.size) return
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}
