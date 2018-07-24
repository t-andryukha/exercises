package com.exercise.bowling

enum class ResultToken(val token:Char) {
   BOUNDARY('|'),
   STRIKE('X'),
   SPARE('/'),
   MISS('-'),
}