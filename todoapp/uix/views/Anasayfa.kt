package com.example.todoapp.uix.views

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todoapp.R
import com.example.todoapp.data.entity.ToDo
import com.example.todoapp.uix.viewmodel.AnasayfaViewModel
import com.google.gson.Gson
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(navController: NavController, anasayfaViewModel: AnasayfaViewModel){
    val aramaYapiliyorMu = remember{ mutableStateOf(false) }
    val tf = remember{ mutableStateOf("") }
    val icerikListe = anasayfaViewModel.todoListe.observeAsState(listOf())
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }


    LaunchedEffect(key1 = true) {
        anasayfaViewModel.icerikYukle()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { if (aramaYapiliyorMu.value) {
                    TextField(
                        value =tf.value,
                        onValueChange = {
                            tf.value = it
                            anasayfaViewModel.ara(it)
                        },
                        label = { Text(text = "Ara")},
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedLabelColor = Color.White,
                            focusedIndicatorColor = Color.White,
                            unfocusedLabelColor = Color.Black,
                            unfocusedIndicatorColor = Color.Black
                        )
                        )
                }else {
                    Text(text = "ToDo")
                }
                },
                actions = {
                    if (aramaYapiliyorMu.value){
                        IconButton(onClick = {
                            aramaYapiliyorMu.value = false
                            tf.value = ""
                        }) {
                            Icon(painter = painterResource(id = R.drawable.close), contentDescription = "")
                        }
                    }else{
                        IconButton(onClick = {
                            aramaYapiliyorMu.value = true
                        }) {
                            Icon(painter = painterResource(id = R.drawable.search), contentDescription = "")
                        }
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("toDoKayitSayfa")},
                content = { Icon(painter = painterResource(id = R.drawable.add), contentDescription = "")})
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {
        paddingValues ->
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            columns = GridCells.Fixed(count = 2),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(
                count =icerikListe.value.count(),
                itemContent = {
                    val todo = icerikListe.value[it]
                    Card(modifier = Modifier
                        .padding(all = 5.dp)
                        .fillMaxWidth()
                        .aspectRatio(1f)) {
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                val icerikJson =
                                    Gson().toJson(todo)
                                navController.navigate("toDoDetaySayfa/$icerikJson")
                            },
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row (
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceAround
                                //verticalAlignment = Alignment.CenterVertically
                            ){
                                Text(text = todo.todo_icerik, fontSize = 20.sp)
                            }
                            Spacer(modifier = Modifier.size(90.dp))
                            IconButton(onClick = {
                                scope.launch {
                                    val sb = snackbarHostState.showSnackbar(
                                        message = "${todo.todo_icerik} silinsin mi ?",
                                        actionLabel = "Evet"
                                    )
                                    if (sb == SnackbarResult.ActionPerformed) {
                                        anasayfaViewModel.sil(todo.todo_id)
                                    }
                                }
                            }) {
                                Icon(painter = painterResource(id = R.drawable.close), contentDescription = "", tint = Color.Gray)
                            }
                        }

                    }
                }
            )

        }

    }

}