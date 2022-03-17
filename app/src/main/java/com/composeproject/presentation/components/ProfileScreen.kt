package com.composeproject.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "Tal_Cohen_Harari_Official")
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
    }
}