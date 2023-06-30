package com.example.instagramclonecompose

sealed class NavigationScreens (
    val title: String,
    val icon: Int,
    val route: String
) {
    object Home: NavigationScreens(title = "home", icon = androidx.core.R.drawable.notification_icon_background, route = BottomNavigationRoutes.HOME.route)
    object Post: NavigationScreens(title = "post", icon = androidx.core.R.drawable.notification_icon_background, route = BottomNavigationRoutes.POST.route)
    object Profile: NavigationScreens(title = "profile", icon = androidx.core.R.drawable.notification_icon_background, route = BottomNavigationRoutes.PROFILE.route)
    object Reel: NavigationScreens(title = "reel", icon = androidx.core.R.drawable.notification_icon_background, route = BottomNavigationRoutes.REEL.route)
    object Search: NavigationScreens(title = "search", icon = androidx.core.R.drawable.notification_icon_background, route = BottomNavigationRoutes.SEARCH.route)
}

enum class BottomNavigationRoutes(val route: String) {
    HOME("home"),
    POST("post"),
    PROFILE("profile"),
    REEL("reel"),
    SEARCH("search")
}