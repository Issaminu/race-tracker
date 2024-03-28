package com.enset.race_tracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.enset.race_tracker.ui.RaceTrackerApp
import com.enset.race_tracker.ui.theme.RacetrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RacetrackerTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    RaceTrackerApp()
                }
            }
        }
    }
}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RaceScreen(player1: RaceParticipant, player2: RaceParticipant) {
    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppTitle()
                Spacer(modifier = Modifier.height(32.dp))
                ProgressBar(player1)
                Spacer(modifier = Modifier.height(10.dp))
                ProgressBar(player2)
                Spacer(modifier = Modifier.height(32.dp))
                StartButton()
                Spacer(modifier = Modifier.height(16.dp))
                ResetButton()
            }
        }
    )
}

@Composable
fun AppTitle(){
    Text("Run a race", style = MaterialTheme.typography.headlineMedium)
}

@Composable
fun ProgressBar(player:RaceParticipant) {
    Row(verticalAlignment = Alignment.CenterVertically) {
    Text(player.name, modifier = Modifier.padding(end = 16.dp))
    LinearProgressIndicator(
        modifier = Modifier
            .height(16.dp)
            .width(270.dp)
            .clip(RoundedCornerShape(5.dp)),
        color = MaterialTheme.colorScheme.primary,
        progress = player.currentProgress
    )}
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
        Text((100*player.currentProgress).toInt().toString()+"%", modifier = Modifier.padding(start = 76.dp))
    Text("100%", modifier = Modifier.padding(end = 15.dp))
}}

@Composable
fun StartButton() {
    Button(
        onClick = ,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(24.dp),
    ) {
        Text(
            text = "Start",
        )
    }
}

@Composable
fun ResetButton() {
    OutlinedButton(
        onClick = { /* Handle reset button click */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(24.dp)
    ) {
        Text(
            text = "Reset",
            textAlign = TextAlign.Center
        )
    }
}
