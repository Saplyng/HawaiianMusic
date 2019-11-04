package com.example.hawaiianmusic

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.ambient
import androidx.compose.sourceLocation
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Image
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.material.themeTextStyle
import androidx.ui.material.withOpacity
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Greeting("Android")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val imgDrums = +imageResource(R.drawable.ic_drums)
    val imgUkulele = +imageResource(R.drawable.ic_ukulele)
    val context = +ambient(ContextAmbient)
    var mediaPlayer: MediaPlayer? = MediaPlayer.create(context,R.raw.ukulele)
    val mediaPlayerDrums: MediaPlayer? = MediaPlayer.create(context,R.raw.drums)

    MaterialTheme {
        Column(
                crossAxisSize = LayoutSize.Expand,
                modifier=Spacing(16.dp)
        ) {
            Container(expanded = true, height = 180.dp) {
                Clip(shape = RoundedCornerShape(8.dp)) {
                    DrawImage(imgUkulele)
                }
            }

            HeightSpacer(16.dp)

            Container(alignment = Alignment.Center, expanded = true) {
                Button(text = "Play Drums", onClick = {
                    if (mediaPlayer != null) {
                        mediaPlayer.start()
                    }
                })
            }


            HeightSpacer(height = 32.dp)

            Container(expanded = true, height = 180.dp) {
                Clip(shape = RoundedCornerShape(8.dp)) {
                    DrawImage(imgDrums)
                }
            }
            HeightSpacer(height = 16.dp)

            Container(alignment = Alignment.Center, expanded = true){
                Button(text = "Play Drums", onClick = {
                    if (mediaPlayerDrums != null) {
                        mediaPlayerDrums.start()
                    }
                })
            }

        }
    }

}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        Greeting("Android")
    }
}
