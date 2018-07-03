package bowling.result.frame

import bowling.result.game.ResultToken

/**
X indicates a strike
/ indicates a spare
- indicates a miss
| indicates a frame boundary
The characters after the || indicate bonus balls
 */
class FrameResult(frameResultTokens: String) {

    val pinsPerBall: List<Int>
    val totalNumberOfPins: Int
    var isSpare: Boolean = false
    var isStrike: Boolean = false

    init {

        var firstBallResult = 0
        var secondBallResult = 0

        val firstBallResultToken = frameResultTokens[0]
        if (firstBallResultToken == ResultToken.MISS.token) {
            firstBallResult = 0
        } else if (firstBallResultToken == ResultToken.STRIKE.token) {
            firstBallResult = 10
            this.isStrike = true;
        } else {
            firstBallResult = firstBallResultToken.toInt()
        }

        if (!isStrike) {
            val secondBallResultToken = frameResultTokens[1]
            if (secondBallResultToken == ResultToken.MISS.token) {
                secondBallResult = 0
            } else if (secondBallResultToken == ResultToken.SPARE.token) {
                secondBallResult = 10 - firstBallResult
                this.isSpare = true;
            } else {
                secondBallResult = secondBallResultToken.toInt()
            }
        }

        pinsPerBall = listOf(firstBallResult, secondBallResult)
        totalNumberOfPins = firstBallResult + secondBallResult
    }

}
