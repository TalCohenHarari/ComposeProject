package com.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            Scaffold(scaffoldState = scaffoldState) {
                val counter = produceState(initialValue = 0){
                    delay(3000L)
                    value = 4
                }
                if(counter.value % 5 == 0 && counter.value > 0){
                    LaunchedEffect(key1 = scaffoldState.snackbarHostState){
                        scaffoldState.snackbarHostState.showSnackbar("Hello")
                    }
                }
                Button(onClick = {}) {
                    Text(text = "Click me: ${counter.value}")
                }
            }
        }
    }
}

var i = 0

@Composable
fun MyComposable(backDispatcher: OnBackPressedDispatcher){

    // "remember" will create this callback once
    val callback = remember{
        object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                // Do something
            }
        }
    }

    // Sometimes we have code that request cleanup (free some memory or resources etc..)  after composable finished composing, so we should use "DisposableEffect"
    DisposableEffect(key1 = backDispatcher){
        backDispatcher.addCallback(callback)
        onDispose {
            callback.remove()
        }
    }

    //This will execute just if the recompose was success, otherwise this block wil not executed
    SideEffect {
        i++
    }
    Button(onClick = {}) {
        Text(text = "Click Me")
    }
}