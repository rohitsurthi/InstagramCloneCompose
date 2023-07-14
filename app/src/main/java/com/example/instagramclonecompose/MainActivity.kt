package com.example.instagramclonecompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
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
    ) {
        InstagramNavigationGraph(navHostController = navController)
    }
}

@Composable
fun BottomNavigationbar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val screensList = listOf(
        NavigationScreens.Home,
        NavigationScreens.Post,
        NavigationScreens.Reel,
        NavigationScreens.Search,
        NavigationScreens.Profile
    )

    BottomAppBar {
        screensList.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.route == screen.route,
                onClick = { navController.navigate(screen.route) },
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon), contentDescription = "icons",
                        modifier = Modifier.size(22.dp)
                    )
                },
                modifier = Modifier
                    .background(color = androidx.compose.ui.graphics.Color.White)
                    .fillMaxHeight()
            )
        }
    }
}