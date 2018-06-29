package array.shuffle

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

/**
Start by writing a function which will accept two
integer arguments (min,max) and generate a random
integer between min and max where:
o) min is an inclusive lower bound
o) max is an exclusive upper bound
For example (1,7) should generate random integers
from {1,2,3,4,5,6} suitable for a dice roll.
How will you test this?
 */
class RandomGeneratorTest {
    @Test
    internal fun `should return number between min inclusive and max exclusive`() {
        val min = 4
        val max = 10
        val random = RandomGenerator().between(min, max)
        assertTrue { random in min..9 }
    }

    @Test
    internal fun `should distribute random equally between lower and upper bound`() {
        val loverBound = 5
        val upperBound = 11
        val randomCounts = HashMap<Int, Int>()
        val numToGenerate = 1000000

        for (i in 0 until numToGenerate) {
            val random = RandomGenerator().between(loverBound, upperBound)
            randomCounts.putIfAbsent(random, 1)?.let { existingCnt -> randomCounts.put(random, existingCnt + 1) }
        }

        println("random counts distribution: $randomCounts")
        val idealRandomCount = numToGenerate / (upperBound - loverBound)
        val maxDisproportionallyPercentage = 1
        for (i in loverBound until upperBound) {
            val occurrences = randomCounts[i]
            val maxAllowableValue = idealRandomCount * (100 + maxDisproportionallyPercentage) / 100
            val minAllowableValue = idealRandomCount * (100 - maxDisproportionallyPercentage) / 100
            assertTrue("random number $i occurrences statistics is too far from ideal: $occurrences is not in range of $minAllowableValue, $maxAllowableValue") {
                occurrences in maxAllowableValue downTo minAllowableValue
            }
        }
    }

    @Test
    internal fun `should throw exception if max less than min`() {
        assertThrows(IllegalArgumentException::class.java) {
            RandomGenerator().between(10, 4)
        }


    }
}