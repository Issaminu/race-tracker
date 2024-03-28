package com.enset.race_tracker.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.enset.race_tracker.RaceParticipant
import com.enset.race_tracker.RaceScreen
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


@Composable
fun RaceTrackerApp() {
    val playerOne = RaceParticipant(name="Player 1", progressIncrement = 10)
    val playerTwo = RaceParticipant(name="Player 2", progressIncrement = 20)
    var raceInProgress by remember { mutableStateOf(false) }
    if (raceInProgress) {
        LaunchedEffect(playerOne, playerTwo) {
            coroutineScope {
                launch {playerOne.run()}
                launch {playerTwo.run()}
            raceInProgress = false
        }}
    }
    RaceScreen(playerOne, playerTwo)
}


@Preview
@Composable
fun PreviewRaceScreen() {
    RaceTrackerApp()
}
