package com.example.instagramclonecompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagramclonecompose.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun HomeScreen() {

    previewElements()

    Column(
        Modifier
            .fillMaxSize()
    ) {
        CustomToolbar()
        InstagramStories()
        InstagramFeed()
    }
}

@Composable
fun CustomToolbar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.instagram_icon), 
            contentDescription = "logo",
            modifier = Modifier
                .width(120.dp)
                .height(40.dp)
                .align(Alignment.TopStart)
        )

        Row(modifier = Modifier
            .align(Alignment.CenterEnd)
        ) {
            Icon(painter = painterResource(
                id = R.drawable.heart_icon),
                contentDescription = "notification",
                modifier = Modifier
                    .size(28.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                painter = painterResource(id = R.drawable.message_icon),
                contentDescription = "messages",
                modifier = Modifier
                    .size(28.dp)
            )
        }
    }
}


@Composable
fun InstagramStories() {

}

@Composable
fun InstagramFeed() {

}

@Preview
@Composable
fun previewElements() {
    CustomToolbar()
}
