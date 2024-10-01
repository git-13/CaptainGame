package eu.tutorials.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.tutorials.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame()
                }
            }
        }
    }

    @Composable
    fun CaptainGame(){
        val treasuresFound = remember {mutableStateOf(0)}
        val direction = remember {mutableStateOf("North")}
        val stormOrTreasure = remember { mutableStateOf("") }

        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Treasures found: ${treasuresFound.value}")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Current direction: ${direction.value}")
            Spacer(modifier = Modifier.height(56.dp))
            Button(onClick = {
                direction.value = "North"
                if (Random.nextBoolean()){
                    treasuresFound.value +=1
                    stormOrTreasure.value = "Found a Treasure!"
                }else{
                    stormOrTreasure.value = "Storm Ahead!"
                }
            }) {
                Text("Sail North" )
            }
            Row {
                Button(onClick = {
                    direction.value = "West"
                    if (Random.nextBoolean()){
                        treasuresFound.value +=1
                        stormOrTreasure.value = "Found a Treasure!"
                    }else{
                        stormOrTreasure.value = "Storm Ahead!"
                    }
                }) {
                    Text("Sail West" )
                }
                Button(onClick = {
                    direction.value = "East"
                    if (Random.nextBoolean()){
                        treasuresFound.value +=1
                        stormOrTreasure.value = "Found a Treasure!"
                    }else{
                        stormOrTreasure.value = "Storm Ahead!"
                    }
                }) {
                    Text("Sail East" )
                }
            }

            Button(onClick = {
                direction.value = "South"
                if (Random.nextBoolean()){
                    treasuresFound.value +=1
                    stormOrTreasure.value = "Found a Treasure!"
                }else{
                    stormOrTreasure.value = "Storm Ahead!"
                }
            }) {
                Text("Sail South" )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = stormOrTreasure.value)
        }

    }

}

