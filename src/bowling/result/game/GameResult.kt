package bowling.result.game

import bowling.result.frame.FrameResult
import bowling.result.game.ResultToken.*

/**
X indicates a strike
/ indicates a spare
- indicates a miss
| indicates a frame boundary
The characters after the || indicate bonus balls
 */

private const val BONUS_BOUNDARY = "||"

class GameResult(gameResult: String) {

    val mainFrameResult: List<FrameResult>

    val bonusFrameResult: FrameResult


    init {
        val mainResult = gameResult.substringBefore(BONUS_BOUNDARY)
        val bonusResult = gameResult.substringAfter(BONUS_BOUNDARY)
        this.mainFrameResult = mainResult.split(BOUNDARY.token).map { FrameResult(it) }
        this.bonusFrameResult = FrameResult(bonusResult)
    }


}

