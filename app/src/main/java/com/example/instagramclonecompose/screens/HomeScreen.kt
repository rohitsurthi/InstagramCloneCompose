package com.example.instagramclonecompose.screens

import android.print.PageRange
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableOpenTarget
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.instagramclonecompose.R
import com.example.instagramclonecompose.models.Post
import com.example.instagramclonecompose.models.Stories
import com.example.instagramclonecompose.models.User
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import java.util.concurrent.ConcurrentLinkedDeque

@Composable
fun HomeScreen() {

    previewElements()

    Column(
        Modifier
            .fillMaxSize()
    ) {
        CustomToolbar()
        InstagramStories(getListOfSampleStories())
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .height(1.dp)
        )
        InstagramFeed(Modifier.fillMaxSize(), getPostListSampleData())
    }
}

@Composable
fun getListOfSampleStories(): List<Stories> = listOf(
    Stories(userName = "someuser3", userProfile = R.drawable.story_1),
    Stories(userName = "someuser4", userProfile = R.drawable.story_2),
    Stories(userName = "someuser5", userProfile = R.drawable.story_7),
    Stories(userName = "someuser6", userProfile = R.drawable.story_4),
    Stories(userName = "someuser7", userProfile = R.drawable.story_5),
    Stories(userName = "someuser8", userProfile = R.drawable.sample_story_image),
    Stories(userName = "someuser9", userProfile = R.drawable.story_3),
    Stories(userName = "someuser10", userProfile = R.drawable.story_1),
    Stories(userName = "someuser11", userProfile = R.drawable.sample_story_image),
    Stories(userName = "someuser12", userProfile = R.drawable.sample_story_image)
)


fun getPostListSampleData(): List<Post> = listOf(

    Post(
        profile = R.drawable.story_6,
        userName = "someuser69",
        postPhotoList = listOf(
            R.drawable.post_1,
            R.drawable.main_post_1,
            R.drawable.story_3
        ),
        description = "Some random description",
        postLikedBy = listOf(
            User(profile = R.drawable.story_7, userName = "someuser5"),
            User(profile = R.drawable.story_2, userName = "someuser8"),
            User(profile = R.drawable.story_4, userName = "someuser0"),
            User(profile = R.drawable.story_5, userName = "someuser1"),
            User(profile = R.drawable.story_7, userName = "someuser2"),
            User(profile = R.drawable.story_1, userName = "someuser3"),
            User(profile = R.drawable.sample_story_image, userName = "someuser4"),
        )
    ),
    Post(
        profile = R.drawable.story_5,
        userName = "someuser99",
        postPhotoList = listOf(
            R.drawable.story_3,
            R.drawable.story_7,
            R.drawable.story_4
        ),
        description = "Some random description",
        postLikedBy = listOf(
            User(profile = R.drawable.story_7, userName = "someuser4"),
        )
    ),
)

@Composable
fun CustomToolbar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 12.dp, end = 12.dp, bottom = 4.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.instagram_icon),
            contentDescription = "logo",
            modifier = Modifier
                .width(110.dp)
                .height(35.dp)
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
                    .size(26.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                painter = painterResource(id = R.drawable.message_icon),
                contentDescription = "messages",
                modifier = Modifier
                    .size(25.dp)
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
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = story.userProfile),
            contentDescription = "story_image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
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
                .padding(4.dp)
                .clip(CircleShape),
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
fun InstagramFeed(modifier: Modifier, postList: List<Post>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        LazyColumn {
            items(postList) { post ->
                PostItem(post)
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PostItem(post: Post) {
    val pagerState = rememberPagerState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterStart),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(
                        id = post.profile
                    ),
                    contentDescription = "profile_icon",
                    modifier = Modifier
                        .size(28.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = post.userName,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    modifier = Modifier
                        .width(120.dp),
                    overflow = TextOverflow.Ellipsis
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.more),
                contentDescription = "more_icon",
                Modifier
                    .size(14.dp)
                    .align(Alignment.CenterEnd)
                    .rotate(90F)
            )

        }

        PostImagesList(post.postPhotoList, pagerState)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, top = 12.dp, end = 12.dp, bottom = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.CenterStart)
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.heart_icon
                    ),
                    contentDescription = "like",
                    modifier = Modifier
                        .size(25.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    painter = painterResource(id = R.drawable.comment),
                    contentDescription = "comment",
                    modifier = Modifier
                        .size(25.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    painter = painterResource(id = R.drawable.share),
                    contentDescription = "share",
                    modifier = Modifier
                        .padding(top = 1.dp)
                        .size(24.dp)
                )
            }

            if (pagerState.pageCount > 1) {
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    activeColor = Color("#32B5FF".toColorInt()),
                    inactiveColor = Color("#C4C4C4".toColorInt()),
                    indicatorWidth = 6.dp,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.bookmark),
                contentDescription = "save post",
                modifier = Modifier
                    .size(22.dp)
                    .align(Alignment.CenterEnd)
            )

        }

        PostLikesDetails(post.postLikedBy)

        PostDescription(post)

        PostComments(post)

    }
}

@Composable
fun PostComments(post: Post) {
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        Text(
            text = "View all 5 comments",
            fontWeight = FontWeight.Light,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(start = 5.dp, bottom = 2.dp)
        )

        Row(
            modifier = Modifier
        ) {
            Image(
                painter = painterResource(id = post.profile),
                contentDescription = "story_image",
                modifier = Modifier
                    .padding(start = 5.dp)
                    .size(24.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "Add a comment...",
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(CenterVertically)
            )
        }

        Text(
            text = "2 hours ago",
            fontWeight = FontWeight.Light,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(start = 5.dp, top = 2.dp)
        )
    }
}

@Composable
fun PostDescription(post: Post) {

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(Color.Black, fontWeight = FontWeight.Bold)) {
            append("${post.userName} ")
        }
        append(post.description)
        withStyle(style = SpanStyle(Color.Black, fontWeight = FontWeight.Light)) {
            append("...more")
        }
    }

    Text(
        text = annotatedString,
        fontSize = 12.sp,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier
            .padding(start = 10.dp, bottom = 2.dp)
    )

}

@Composable
fun PostLikesDetails(likedBy: List<User>) {
    if (likedBy.size > 10) {
        Text(
            text = "${likedBy.size} likes",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 4.dp)
        )
    } else if (likedBy.size == 1) {

        Text(
            text = " liked by ${likedBy[0].userName}",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 4.dp)
        )
    } else {

        val annotatedString = buildAnnotatedString {
            withStyle(style = SpanStyle(Color.Black, fontWeight = FontWeight.Light)) {
                append("Liked by")
            }
            withStyle(style = SpanStyle(Color.Black, fontWeight = FontWeight.Bold)) {
                append(" ${likedBy[0].userName} ")
            }
            withStyle(style = SpanStyle(Color.Black, fontWeight = FontWeight.Light)) {
                append("and ")
            }
            withStyle(style = SpanStyle(Color.Black, fontWeight = FontWeight.Bold)) {
                append("${likedBy.size - 1} others")
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 10.dp, bottom = 5.dp)
        ) {
            showSomeUsersWhoLiked(likedBy)
            Spacer(modifier = Modifier.padding(horizontal = 3.dp))
            Text(
                text = annotatedString,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun showSomeUsersWhoLiked(likedBy: List<User>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(-6.dp)
    ) {
        items(likedBy.take(3)) { likedBy ->
            Image(
                painter = painterResource(id = likedBy.profile),
                contentDescription = "story_image",
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun postImagesCount(modifier: Modifier = Modifier, pagerState: PagerState) {
    Row(
        modifier = modifier
            .clip(CircleShape)
            .background(Color.Black.copy(0.5f))
            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Text(text = (pagerState.currentPage + 1).toString(), color = Color.White)
        Text(text = "/", color = Color.White)
        Text(text = (pagerState.pageCount).toString(), color = Color.White)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PostImagesList(postImagesList: List<Int>, pagerState: PagerState) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        HorizontalPager(
            count = postImagesList.size,
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { currentPage ->
            Image(
                painter = painterResource(id = postImagesList[currentPage]),
                contentDescription = "post images",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

        }

        if (pagerState.pageCount > 1) {
            postImagesCount(
                modifier = Modifier
                    .align(TopEnd)
                    .padding(top = 10.dp, end = 10.dp),
                pagerState = pagerState
            )
        }
    }
}

@Preview
@Composable
fun previewElements() {
    CustomToolbar()
}

@Preview
@Composable
fun previewStoryElements() {
    StoryItem(
        story = Stories(
            userName = "some user name",
            userProfile = R.drawable.sample_story_image
        )
    )
}

@Preview
@Composable
fun previewPostElements() {
    PostItem(
        post = Post(
            profile = R.drawable.sample_story_image,
            userName = "Rock_the_bock",
            postPhotoList = listOf(R.drawable.post_1),
            description = "something post",
            postLikedBy = listOf(
                User(profile = R.drawable.sample_story_image, userName = "john_the_born"),
                User(profile = R.drawable.sample_story_image, userName = "seth_the_beth"),
            )
        )
    )
}


