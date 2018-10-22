package com.exercise.array.majority

class MajorityElementService {
    fun getMajorityElement(array: Array<Any>): Any? {
        //1) sorting+counting - time O(nlogn), space O(1)
        //2) hash table - time O(n), space O(n)
        //3) cancellation approach (Moore's Voting algorithm) - the best one time O(n), space O(1)
        var majorityElem: Any? = null;
        var count = 1;
        for (currElem in array) {
            if (currElem != majorityElem) count--
            if (count == 0) {
                majorityElem = currElem
                count = 1
            }
        }

        count = 0;
        for (currElem in array) {
            if (currElem == majorityElem) count++
        }

        if (count <= array.size / 2) majorityElem = null

        return majorityElem
    }

}
