package com.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn {
                itemsIndexed(
                    listOf("This", "is", "jetpack", "jetpack", "compose")
                ) { index, item ->
                    Text(
                        text = item,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp),
                    )
                }
//                items(5000) {
//                    Text(
//                        text = "Item $it",
//                        fontSize = 24.sp,
//                        textAlign = TextAlign.Center,
//                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(vertical = 24.dp),
//                    )
//                }
            }
        }
    }
}
/** LazyColumn/Row is the equivalent to recyclerView.
 * LazyColumn already scrollable by default.
 * "Column" are loading all the list in one time, "LazyColumn" load the list exact like RecyclerView.
 * "items" = loop our items (need to give the size list) and the index is "it"
 * [itemsIndexed gives us the index and the item].
 *
 * */