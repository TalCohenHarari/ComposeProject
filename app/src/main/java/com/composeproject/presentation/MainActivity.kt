package com.composeproject.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.composeproject.presentation.components.ProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Data
        val profileDescriptionMap = HashMap<String, String>()
        val followedList = ArrayList<String>()

        //Ui
        setData(profileDescriptionMap, followedList)
        setContent {
            ProfileScreen(
                userName = "ash_ketchum_Official",
                profileDescriptionMap = profileDescriptionMap,
                followedList = followedList
            )
        }
    }

    private fun setData(
        profileDescriptionMap: HashMap<String, String>,
        followedList: ArrayList<String>
    ) {
        //Profile-Description Map
        profileDescriptionMap["displayName"] = "Pokemon mentor"
        profileDescriptionMap["description"] = "10 years experience in capturing Pokemon\n" +
                "Want me to help you learn how to capture Pokemon? Send me an email! \uD83D\uDCE7\n" +
                "subscribe to my YouTube channel:"
        profileDescriptionMap["url"] = "https://youtube.com"

        //Followed List
        followedList.add("philliplackner")
        followedList.add("codinginflow")
    }
}