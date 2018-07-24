package com.exercise.array.shuffle

class RandomGenerator {
    fun between(min: Int, max: Int): Int {
        //this could be achieved with existing util
//        return ThreadLocalRandom.current().nextInt(min, max)
        if (max <= min) throw IllegalArgumentException()
        var random: Int
        do {
            random = (Math.random() * max).toInt()
        } while (random < min)

        return random
    }

}
