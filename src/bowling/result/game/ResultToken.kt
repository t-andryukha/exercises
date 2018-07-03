package bowling.result.game

enum class ResultToken(val token:Char) {
   BOUNDARY('|'),
   STRIKE('X'),
   SPARE('/'),
   MISS('-'),
}