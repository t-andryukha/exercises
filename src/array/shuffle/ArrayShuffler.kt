package array.shuffle

/**
 * Write a program to shuffle an array.

Start by writing a function which will accept two
integer arguments (min,max) and generate a random
integer between min and max where:
o) min is an inclusive lower bound
o) max is an exclusive upper bound
For example (1,7) should generate random integers
from {1,2,3,4,5,6} suitable for a dice roll.
How will you test this?

Use this function to write shuffle:
Iterate through the array and for each element[i]
generate a random integer (min=r,max=array.size)
swap the integers at indexes i and r

The shuffle function
o) does not mutate the array argument
o) returns an array
o) the returned array is randomly shuffled!
o) the returned array is a permutation of the array argument

 */
class ArrayShuffler(val randomGenerator: RandomGenerator) {

    /**
     * Use this function to write shuffle:
    Iterate through the array and for each element[i]
    generate a random integer (min=r,max=array.size)
    swap the integers at indexes i and r
     */
    inline fun <reified T> shuffle(sourceArray: Array<T>): Array<T> {
        val shuffledArray: Array<T> = arrayOfNulls<T>(sourceArray.size) as Array<T>//we are sure that we fill the array with below loop
        for (i in 0 until shuffledArray.size) {
            val randomIndex = randomGenerator.between(i, shuffledArray.size)
            shuffledArray[i] = sourceArray[randomIndex]
        }
        return shuffledArray
    }

}
