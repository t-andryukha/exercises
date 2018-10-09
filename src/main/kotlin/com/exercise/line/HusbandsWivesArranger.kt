package com.exercise.line

import java.util.*

class HusbandsWivesArranger {

    fun arrange(randomLine: List<String>, spaceOverTimePriority: Boolean = false) = if (spaceOverTimePriority) {
        arrangeInNLogNTimeAndConstantSpace(randomLine)
    } else {
        arrangeInLinearTimeAndLinearSpace(randomLine)
    }


    /**
     * Method is accounting on indices starting from 1 and increasing by 1
     */
    private fun arrangeInLinearTimeAndLinearSpace(randomLine: List<String>): List<String?> {
        val arrangedLine = arrayOfNulls<String>(randomLine.size)
        for (spouse in randomLine.iterator()) {
            val spouseIndex = spouse.substring(1).toInt()
            val arrangedIndex =
                    if (spouse.startsWith(Spouse.HUSBAND.prefix)) {
                        spouseIndex * 2 - 2
                    } else {
                        spouseIndex * 2 - 1
                    }
            arrangedLine[arrangedIndex] = spouse
        }
        return arrangedLine.toList()
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

    /**
     * the argument array will be mutated
     * Method is accounting on indices starting from 1 and increasing by 1
     */
    fun arrangeMutatingArgument(randomLine: Array<String>): List<String?> {
        //todo insertion sort
        val arrangedLine = arrayOfNulls<String>(randomLine.size)
        for (spouse in randomLine.iterator()) {
            val spouseIndex = spouse.substring(1).toInt()
            val arrangedIndex =
                    if (spouse.startsWith(Spouse.HUSBAND.prefix)) {
                        spouseIndex * 2 - 2
                    } else {
                        spouseIndex * 2 - 1
                    }
            arrangedLine[arrangedIndex] = spouse
        }
        TODO()
        return arrangedLine.toList()
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
