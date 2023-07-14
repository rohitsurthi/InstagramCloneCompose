package com.example.instagramclonecompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.instagramclonecompose.screens.HomeScreen
import com.example.instagramclonecompose.screens.PostScreen
import com.example.instagramclonecompose.screens.ProfileScreen
import com.example.instagramclonecompose.screens.ReelScreen
import com.example.instagramclonecompose.screens.SearchScreen

@Composable
fun InstagramNavigationGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = NavigationScreens.Home.route ) {

        composable(route = NavigationScreens.Home.route) {
            HomeScreen()
        }

        composable(route = NavigationScreens.Post.route) {
            PostScreen()
        }

        composable(route = NavigationScreens.Profile.route) {
            ProfileScreen()
        }

        composable(route = NavigationScreens.Reel.route) {
            ReelScreen()
        }

        composable(route = NavigationScreens.Search.route) {
            SearchScreen()
        }
    }
}
