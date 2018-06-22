package anagrams

class AnagramSource(inputString: String) {
    val anagrams: Set<String>;

    init {
        val originalPhrase: CharArray = inputString.toCharArray()
        anagrams = getAnagrams(originalPhrase)
    }

    private fun getAnagrams(originalPhrase: CharArray): Set<String> {
        val anagrams = HashSet<String>()
        for (combinationId in 0..factorial(originalPhrase.size)) {
            anagrams.add(getAnagram(combinationId, originalPhrase))
        }
        return anagrams;
    }

    private fun getAnagram(combinationId: Int, originalPhrase: CharArray): String {
        val anagramBuilder = StringBuilder()
        for (anagramIndex in 0..originalPhrase.size) {
            val charIndex = anagramIndex + combinationId + ...
            val char = originalPhrase[charIndex]
            anagramBuilder.append(char)
        }
        return anagramBuilder.toString()
    }

    /*
        0123 - move 3
        0132
        0312
        3012 - move 2
        3021
        3201
        2301 - move 1
        2310
        2130
        1230 - move 0
        1203
        1023
        0123 - duplicate

    =================

    0123- 1, elements include - 2
    0132 -2, elements include - 2

    0321 -3 elements (determine by factorial) include - 3
    0312 -4 elements include - 3
    0213 -5 elements include - 3
    0231 -6 elements include - 3

    0123 -7 elements include - 4
    0123 -8
    0123 -9
    0123 -10
    0123 -11
    0123 -12

    0123 -13
    0123 -14
    0123 -15
    0123 -16
    0123 -17
    0123 -18

====================================

    0123- 1, elements include - 2
    0132 -2, elements include - 2

    0231 -3 elements include - 3
    0213 -4 elements include - 3
    0312 -5 elements include - 3
    0321 -6 elements include - 3

    1320 -7 elements include - 4
    1302 -8
    1203 -9
    1230 -10
    1032 -11
    1023 -12

    3021 -13
    3012 -14
    3210 -15
    3201 -16
    3102 -17
    3120 -18


    =====================

    0123- 1, elements include - 2
    0132 -2, elements include - 2

    0312 -3 elements include - 3
    0321 -4 elements include - 3
    0231 -5 elements include - 3
    0213 -6 elements include - 3

    2013 -7 elements include - 4
    2031 -8
    2301 -9
    2310 -10
    2130 -11
    2103 -12

    1203 -13
    1230 -14
    1320 -15
    1302 -16
    1032 -17
    1023 -18...





        0123 - move 3
        0132
        0312
        3012 - move 2
        3021
        3201
        2301 - move 1
        2310
        2130
        1230 - move 0
        1203
        1023
        0123 - duplicate
        0213 - move 2(not the edge element)
        2013
        2103- move 1
        1203


        0123 - 0
        0132 - 1

        0213 - 2
        0231 - 3
        0321 - 4
        0312 - 5


        3012 - 6
        3021 - 7

        3201 - 8
        3210 - 9
        3120 - 10
        3102 - 11


    substract or if negative -> then sum
    if substract or sum not in range -> leave as is?
    0123 - 0
    1012 - 1
    2301 - 2
    3120 - 3

on increasing n -> start to substract n times left?
    0123 - 4=3*n=1+1


======================
======================
======================

    01 23
    01 32

    0 213
    0 231
    0 312
    0 321

    1 023
    1 032
    ...
     */

    private fun factorial(size: Int): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
