package com.example.instagramclonecompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.instagramclonecompose.R
import com.example.instagramclonecompose.models.Stories
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun HomeScreen() {

    previewElements()

    Column(
        Modifier
            .fillMaxSize()
    ) {
        CustomToolbar()
        InstagramStories(getListOfStories())
        InstagramFeed()
    }
}

fun getListOfStories(): List<Stories> = listOf (
    Stories(userName = "Instagram", userProfile = R.drawable.sample_story_image),
    Stories(userName = "Instagram", userProfile = R.drawable.sample_story_image),
    Stories(userName = "Instagram", userProfile = R.drawable.sample_story_image),
    Stories(userName = "Instagram", userProfile = R.drawable.sample_story_image),
    Stories(userName = "Instagram", userProfile = R.drawable.sample_story_image),
    Stories(userName = "Instagram", userProfile = R.drawable.sample_story_image),
    Stories(userName = "Instagram", userProfile = R.drawable.sample_story_image),
    Stories(userName = "Instagram", userProfile = R.drawable.sample_story_image),
    Stories(userName = "Instagram", userProfile = R.drawable.sample_story_image),
    Stories(userName = "Instagram", userProfile = R.drawable.sample_story_image),
    Stories(userName = "Instagram", userProfile = R.drawable.sample_story_image),
    Stories(userName = "Instagram", userProfile = R.drawable.sample_story_image),
    Stories(userName = "Instagram", userProfile = R.drawable.sample_story_image),
    Stories(userName = "Instagram", userProfile = R.drawable.sample_story_image)
)

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

        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd)
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.heart_icon
                ),
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
fun InstagramStories(storyList: List<Stories>) {
    LazyRow {
        items(storyList) { story ->
            StoryItem(story = story)
        }
    }
}

@Composable
fun StoryItem(story: Stories) {
    Column(
        modifier = Modifier
            .padding(6.dp)
    ) {
        Image(
            painter = painterResource(id = story.userProfile),
            contentDescription = "story_image",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    brush = Brush.linearGradient(
                        listOf(
                            Color("#DE0046".toColorInt()),
                            Color("#F7A34B".toColorInt())
                        )
                    ),
                    shape = CircleShape
                )
                .padding(4.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(
            modifier = Modifier
                .height(4.dp)
        )

        Text(
            text = story.userName.toString(),
            modifier = Modifier.width(60.dp),
            textAlign = TextAlign.Center,
            fontSize = 10.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@Composable
fun InstagramFeed() {

}

@Preview
@Composable
fun previewElements() {
    CustomToolbar()
}

@Preview
@Composable
fun previewStoryElements() {
    StoryItem(story = Stories(userName = "some user name", userProfile = R.drawable.sample_story_image))
}

