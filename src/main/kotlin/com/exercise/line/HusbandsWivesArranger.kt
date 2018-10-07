package com.exercise.line

class HusbandsWivesArranger {

    fun arrange(randomLine: List<String>): List<String> {
//        return this.arrangeInLinearTimeAndLinearSpace(randomLine)
        return this.arrangeInNLogNTimeAndConstantSpace(randomLine)
    }

    private fun arrangeInLinearTimeAndLinearSpace(randomLine: List<String>): List<String> {
        randomLine.
    }

    private fun arrangeInNLogNTimeAndConstantSpace(randomLine: List<String>): List<String> {
        val sortedLine = randomLine.sorted().toTypedArray()
        for ((index, spouse) in sortedLine.withIndex()) {
            if (spouse.startsWith(Spouse.HUSBAND.prefix)) {
                sortedLine.swap(index, index * 2)
            } else if (spouse.startsWith(Spouse.WIFE.prefix)) {
                sortedLine.swap(index, index / 2)
            }
        }
        return sortedLine.asList()
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
