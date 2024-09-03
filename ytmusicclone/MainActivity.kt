package com.example.ytmusicclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ytmusicclone.ui.theme.YTMusicCloneTheme
import com.example.ytmusicclone.uix.Anasayfa

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YTMusicCloneTheme {
                Anasayfa()
            }
        }
    }
}
