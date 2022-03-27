package com.example.composition.data

import com.example.composition.domain.entity.GameSettings
import com.example.composition.domain.entity.Level
import com.example.composition.domain.entity.Question
import com.example.composition.domain.repository.GameRepository
import java.lang.Integer.max
import java.lang.Math.min
import kotlin.random.Random

object GameRepositoryImpl: GameRepository {

    private const val MIN_VISIBLE_NUMBER = 1
    private const val MIN_SUM_VALUE = 2

    override fun getGameSettings(level: Level): GameSettings {
        return when(level){
            Level.TEST -> GameSettings(20, 5, 50, 30)
            Level.EASY -> GameSettings(10, 2, 10, 60)
            Level.NORMAL -> GameSettings(30, 5, 20, 120)
            Level.HARD -> GameSettings(50, 5, 10, 180)
        }
    }

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_VISIBLE_NUMBER, sum)
        val answer = sum - visibleNumber
        val options = HashSet<Int>()
        val from = max(answer - countOfOptions, MIN_VISIBLE_NUMBER)
        val to = min(MIN_SUM_VALUE, answer + countOfOptions)
        options.add(answer)
        while (options.size < countOfOptions){
            val option = Random.nextInt(from, to)
            options.add(option)
        }
        return Question(sum, visibleNumber, options.toList())
    }
}