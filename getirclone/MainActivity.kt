package com.example.getirclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.getirclone.ui.theme.GetirCloneTheme
import com.example.getirclone.ui.theme.Purple40
import com.example.getirclone.ui.theme.newAmsterdam
import com.example.getirclone.ui.theme.pacifico

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetirCloneTheme {
                Anasayfa()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa() {
    val configuration = LocalConfiguration.current
    val ekranGenisligi = configuration.screenWidthDp
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Getir", fontFamily = newAmsterdam, color = Color.White)},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple40
                )
            )
        }
    ) {
        paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.img),
                contentDescription = "")
            Text(text = "Tahmini Teslimat 30dk",
                color = Purple40,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Chip(icerik = stringResource(id = R.string.kacmazFiyatlarButton))
                Chip(icerik = stringResource(id =R.string.indirimlerButton))

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Chip(icerik = stringResource(id =R.string.cokAlAzOdeButton))
                Chip(icerik = stringResource(id =R.string.kazandiranlarButton))

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Chip(icerik = stringResource(id =R.string.yazGeldiButton))
                Chip(icerik = stringResource(id =R.string.suIcecekButton))

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Chip(icerik = stringResource(id =R.string.etTavukButton))
                Chip(icerik = stringResource(id =R.string.meyveSebzeButton))

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Chip(icerik = stringResource(id =R.string.sutUrunleriButton))
                Chip(icerik = stringResource(id =R.string.firindanButton))
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GetirCloneTheme {
        Anasayfa()
    }
}