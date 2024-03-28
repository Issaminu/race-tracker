package com.enset.race_tracker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

class RaceParticipant(private val initialProgress: Float = 0f,
                      private val maxProgress: Int = 100,
                      private val progressIncrement: Int = 1,
                      private val progressDelayMillis: Long = 1000L,
                      private var raceInProgress: Boolean = false,
                      val name: String = "Player") {
    var currentProgress by mutableFloatStateOf(initialProgress)
        private set
    var onRunStateChange = { raceInProgress = it }

    suspend fun run() {
        while (currentProgress < maxProgress) {
            delay(progressDelayMillis)
            currentProgress += progressIncrement
        }
    }
    fun reset() {
        currentProgress = initialProgress
    }
}
