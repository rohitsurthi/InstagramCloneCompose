package com.example.instagramclonecompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.instagramclonecompose.ui.theme.InstagramCloneComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramCloneComposeTheme {
                InstagramApplication()
            }
        }
    }
}

@Preview
@Composable
fun previewThis() {
    InstagramApplication()
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InstagramApplication() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationbar(navController) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            InstagramNavigationGraph(navHostController = navController)
        }
    }
}

@Composable
fun BottomNavigationbar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val screensList = listOf(
        NavigationScreens.Home,
        NavigationScreens.Search,
        NavigationScreens.Post,
        NavigationScreens.Reel,
        NavigationScreens.Profile
    )

    BottomAppBar {
        screensList.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.route == screen.route,
                onClick = { navController.navigate(screen.route) },
                icon = {

                    if(screen.route == BottomNavigationRoutes.PROFILE.route) {
                        profileIconShow()
                    } else {
                        Icon(
                            painter = painterResource(id = screen.icon), contentDescription = "icons",
                            modifier = Modifier
                                .size(22.dp)
                        )
                    }
                },
                modifier = Modifier
                    .background(color = androidx.compose.ui.graphics.Color.White)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun profileIconShow() {
    Image(
        painter = painterResource(id = R.drawable.profile_icon),
        contentDescription = "current user",
        modifier = Modifier
            .size(24.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
        )
}