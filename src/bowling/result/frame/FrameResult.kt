package bowling.result.frame

import bowling.ResultToken.*

private const val PINS_PER_FRAME = 10

/**
X indicates a strike
/ indicates a spare
- indicates a miss
| indicates a frame boundary
The characters after the || indicate bonus balls
 */
class FrameResult(frameResultTokens: String) {

    val pinsPerBall = mutableListOf<Int>()
    var totalNumberOfPins: Int = 0
    var isSpare: Boolean = false
    var isStrike: Boolean = false

    init {
        for (frameResultToken in frameResultTokens) {
            val ballResult: Int
            when (frameResultToken) {
                MISS.token -> ballResult = 0
                STRIKE.token -> {
                    ballResult = PINS_PER_FRAME
                    this.isStrike = true;
                }
                SPARE.token -> {
                    ballResult = PINS_PER_FRAME - totalNumberOfPins
                    this.isSpare = true;
                }
                else -> ballResult = frameResultToken.toString().toInt()
            }
            pinsPerBall.add(ballResult)
            totalNumberOfPins += ballResult
        }
    }

}
