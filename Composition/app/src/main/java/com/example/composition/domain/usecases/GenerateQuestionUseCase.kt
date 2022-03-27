package com.example.composition.domain.usecases

import com.example.composition.domain.entity.Question
import com.example.composition.domain.repository.GameRepository

class GenerateQuestionUseCase(          //useCase, который работает с GameRepository
    private val repository: GameRepository
) {
    operator fun invoke(maxSumValue: Int): Question {           //нужен для того, чтобы работать с объектом GenerateQuestionUseCase как с методом
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    private companion object{
        private const val COUNT_OF_OPTIONS = 6

    }
}