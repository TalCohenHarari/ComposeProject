package com.composeproject.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.composeproject.data.ImageWithText
import com.composeproject.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileScreen(
    userName: String,
    profileDescriptionMap: HashMap<String, String>,
    followedList: List<String>,
) {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = userName, modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection(followedList = followedList, profileDescriptionMap = profileDescriptionMap)
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(15.dp))
        HighlightSection(
            highlights = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.youtube),
                    text = "YouTube"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.telegram),
                    text = "Telegram"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.qa),
                    text = "Q&A"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.discord),
                    text = "Discord"
                )
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            imageWithTextList = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_grid),
                    text = "Posts"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_reels),
                    text = "Reels"
                ), ImageWithText(
                    image = painterResource(id = R.drawable.ic_igtv),
                    text = "IGTV"
                )
            ),
            modifier = Modifier
        ) {
            selectedTabIndex = it
        }
        when (selectedTabIndex) {
            0 -> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.pikachu),
                    painterResource(id = R.drawable.bulbasaur),
                    painterResource(id = R.drawable.charmander),
                    painterResource(id = R.drawable.bulbasaur),
                    painterResource(id = R.drawable.pikachu),
                    painterResource(id = R.drawable.mewtwo),
                    painterResource(id = R.drawable.charmander),
                    painterResource(id = R.drawable.mewtwo),
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}