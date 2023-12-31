package com.example.instagramclonecompose

import androidx.compose.ui.res.painterResource

sealed class NavigationScreens (
    val title: String,
    val icon: Int = R.drawable.home_icon,
    val route: String
) {
    object Home: NavigationScreens(title = "home", icon = R.drawable.home_icon, route = BottomNavigationRoutes.HOME.route)
    object Post: NavigationScreens(title = "post", icon = R.drawable.add, route = BottomNavigationRoutes.POST.route)
    object Profile: NavigationScreens(title = "profile", route = BottomNavigationRoutes.PROFILE.route)
    object Reel: NavigationScreens(title = "reel", icon = R.drawable.reels_icon, route = BottomNavigationRoutes.REEL.route)
    object Search: NavigationScreens(title = "search", icon = R.drawable.search_icon, route = BottomNavigationRoutes.SEARCH.route)
}

enum class BottomNavigationRoutes(val route: String) {
    HOME("home"),
    POST("post"),
    PROFILE("profile"),
    REEL("reel"),
    SEARCH("search")
}