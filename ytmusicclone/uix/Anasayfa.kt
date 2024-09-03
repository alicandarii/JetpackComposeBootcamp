package com.example.ytmusicclone.uix


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ytmusicclone.data.entity.Muzik
import com.example.ytmusicclone.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa() {

    val muzikListesi = remember { mutableStateListOf<Muzik>() }
    val muzikListesi2 = remember { mutableStateListOf<Muzik>() }

    LaunchedEffect(key1 = true) {
        val m1 = Muzik(1, R.drawable.indir, "Summertime Sadness", "Lana Del Rey ", " 19Mn kez dinlendi")
        val m2 = Muzik(2, R.drawable.belong, "I Belong To You", "Lenny Kravitz", "14 Mn kez dinlendi")
        val m5 = Muzik(5, R.drawable.merhaba, "Merhaba", "Barış Akarsu ", "11 Mn kez dinlendi")
        muzikListesi.add(m1)
        muzikListesi.add(m2)
        muzikListesi.add(m5)

        val m3 = Muzik(1, R.drawable.baris, "Kimdir O", "Barış Akarsu", "10 Mn kez dinlendi")
        val m4 = Muzik(2, R.drawable.wannabeyours, "I Wanna be Your Slave", "Maneskin", "15 Mn kez dinlendi")
        val m7 = Muzik(3, R.drawable.chery, "Cheri Cheri Lady ", "Modern Talking ", "13 Mn kez dinlendi")
        muzikListesi2.add(m3)
        muzikListesi2.add(m4)
        muzikListesi2.add(m7)

    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                        Row(
                            modifier = Modifier.padding(5.dp),
                        ) {
                            Image(painter = painterResource(id = R.drawable.app_icon_music_600), contentDescription ="" ,Modifier.width(30.dp))
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(text = "YtMusic", color = Color.White)
                            Spacer(modifier = Modifier.width(175.dp))
                            Image(painter = painterResource(id = R.drawable.notification) , contentDescription ="" ,Modifier.size(25.dp))
                            Spacer(modifier = Modifier.width(5.dp))
                            Image(painter = painterResource(id = R.drawable.search) , contentDescription ="" ,Modifier.size(25.dp))
                            Spacer(modifier = Modifier.width(5.dp))
                            Image(painter = painterResource(id = R.drawable.account) , contentDescription ="" ,Modifier.size(25.dp))
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF121212)
                )
            )
        },
        bottomBar = {
            NavigationBar (
                containerColor = Color(0xFF1F1F1F)
            ){
                NavigationBarItem(selected = true, onClick = {  }, icon = {
                    Image(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }, label = { Text(text = "Ana Sayfa", color = Color.White) })
                NavigationBarItem(selected = false, onClick = {  }, icon = {
                    Image(
                        painter = painterResource(id = R.drawable.yours),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }, label = { Text(text = "Sana Özel", color = Color.White) })

                NavigationBarItem(selected = false, onClick = {  }, icon = {
                    Image(
                        painter = painterResource(id = R.drawable.cmmms),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp).background(color = Color.Black)
                    )
                }, label = { Text(text = "Keşfet", color = Color.White) })

                NavigationBarItem(selected = false, onClick = {  }, icon = {
                    Image(
                        painter = painterResource(id = R.drawable.library),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }, label = { Text(text = "Kitaplık", color = Color.White) })
            }
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFF121212))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Button(
                    onClick = {  },
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .padding(horizontal = 4.dp),
                    contentPadding = PaddingValues(horizontal = 10.dp),
                    shape = RoundedCornerShape(50),
                    border = BorderStroke(1.dp, Color.LightGray),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
                ) {
                    Text("Rahatlama", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                }
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .padding(horizontal = 4.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    shape = RoundedCornerShape(50),
                    border = BorderStroke(1.dp, Color.LightGray),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
                ) {
                    Text("Enerjik", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                }
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .padding(horizontal = 4.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    shape = RoundedCornerShape(50),
                    border = BorderStroke(1.dp, Color.LightGray),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
                ) {
                    Text("Hüzünlü", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                }
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .padding(horizontal = 4.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp),
                    shape = RoundedCornerShape(50),
                    border = BorderStroke(1.dp, Color.LightGray),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
                ) {
                    Text("Antrenman", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                }
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = "Sizin için seçilen trend şarkılar", color = Color.White, fontSize = 15.sp)
                Text(text = "Tümünü oynat", color = Color.Gray ,modifier = Modifier.clickable {  })
            }

            


            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()

            ) {

                items(
                    count = muzikListesi.count(),
                    itemContent = {
                        val muzik = muzikListesi[it]
                        Card(
                            modifier = Modifier
                                .padding(all = 4.dp)
                                .fillMaxWidth()
                                .height(50.dp)
                                .background(color = Color(0xFF1F1F1F)),

                        ) {
                            Box(modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    brush = Brush.linearGradient(
                                        colors = listOf(
                                            Color(0xFF1F1F1F),
                                            Color(0xFF121212)
                                        ),
                                        start = Offset(0f, 0f),
                                        end = Offset(0f, Float.POSITIVE_INFINITY)
                                    )
                                )){

                                Row(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Row(
                                        modifier = Modifier.padding(),
                                        horizontalArrangement = Arrangement.SpaceAround,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(id = muzik.imageResId),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .width(75.dp)
                                                .height(75.dp)
                                                .padding(4.dp)
                                        )
                                        Column(
                                            modifier = Modifier
                                                .padding(all = 4.dp)
                                                .background(
                                                    color = Color.Transparent
                                                ),

                                        ) {

                                            Text(text = muzik.muzik_ad, fontSize = 17.sp, color = Color.White)
                                            Row {
                                                Text(text = muzik.sarkici, color = Color.Gray, fontSize = 12.sp)
                                                Spacer(modifier = Modifier.width(10.dp))
                                                Image(painter = painterResource(id = R.drawable.arrow), contentDescription = "")
                                                Text(
                                                    text = muzik.dinlenme_sayisi,
                                                    color = Color.Gray,
                                                    fontSize = 12.sp
                                                )
                                            }


                                        }
                                        Spacer(modifier = Modifier.width(84.dp))
                                        Image(painter = painterResource(id = R.drawable.more2), contentDescription = "",Modifier.size(25.dp))
                                    }
                                }
                            }
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(3.dp))

            Row(
                modifier = Modifier
                    .padding(all = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Hızlı Seçimler", fontSize = 15.sp, color = Color.White)
                Text(text = "Tümünü oynat",Modifier.clickable {  }, color = Color.Gray)
            }

            Spacer(modifier = Modifier.height(4.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 300.dp)
            ) {
                items(count = muzikListesi2.count()) {
                    index ->
                    val muzik2 = muzikListesi2[index]
                    Card(
                        modifier = Modifier
                            .padding(all = 4.dp)
                            .fillMaxWidth()
                            .height(50.dp)
                    ){
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        Color(0xFF1F1F1F),
                                        Color(0xFF121212)
                                    ),
                                    start = Offset(0f, 0f),
                                    end = Offset(0f, Float.POSITIVE_INFINITY)
                                )
                            )){
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Row(
                                    modifier = Modifier.padding(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = muzik2.imageResId),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .width(75.dp)
                                            .height(75.dp)
                                            .padding(4.dp)
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Column(
                                        modifier = Modifier
                                            .background(color = Color.Transparent)
                                    ) {
                                        Text(text = muzik2.muzik_ad, fontSize = 20.sp, color = Color.White)
                                        Row {
                                            Text(text = muzik2.sarkici, color = Color.Gray, fontSize = 12.sp)
                                            Spacer(modifier = Modifier.width(10.dp))
                                            Image(painter = painterResource(id = R.drawable.arrow), contentDescription = "")
                                            Text(
                                                text = muzik2.dinlenme_sayisi,
                                                color = Color.Gray,
                                                fontSize = 12.sp
                                            )
                                        }
                                    }
                                }
                                Image(
                                    painter = painterResource(R.drawable.more2),
                                    contentDescription = "",
                                    modifier = Modifier.size(25.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}