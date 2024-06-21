package com.github.wtt_clone

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.wtt_clone.screens.LatestScreen
import com.github.wtt_clone.screens.ProfileScreen
import com.github.wtt_clone.screens.EventsScreen
import com.github.wtt_clone.screens.PlayerInfoScreen
import com.github.wtt_clone.screens.PlayersScreen
import com.github.wtt_clone.screens.VideoScreen
import com.github.wtt_clone.ui.theme.toughorange


@Composable
fun App() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ) {
                BottomNavigationItem().bottomNavigationItems().forEachIndexed { _, navigationItem ->
                    val selected = navigationItem.route == currentDestination?.route
                    val sizeIcon: Dp by animateDpAsState(
                        targetValue =
                        if (selected) 28.dp else 24.dp
                    )
                    val selectedMod = when (selected) {
                        false -> Modifier
                            .size(sizeIcon)

                        true -> Modifier
                            .size(sizeIcon)
                            .graphicsLayer(alpha = 0.99f)
                            .drawWithCache {
                                onDrawWithContent {
                                    drawContent()
                                    drawRect(
                                        brush = Constants.gradientBrush,
                                        blendMode = androidx.compose.ui.graphics.BlendMode.SrcAtop
                                    )
                                }
                            }
                    }
                    NavigationBarItem(
                        selected = selected,
                        label = {
//                            var selected by remember { mutableStateOf(selected) }
                            val textColor: Color by animateColorAsState(
                                if (selected) Color.White else toughorange
                            )
                            Text(navigationItem.label, color = textColor)
                        },
                        icon = {
                            Icon(
                                tint = toughorange,
                                modifier = Modifier
                                    .then(selectedMod),
                                painter = painterResource(id = navigationItem.icon),
                                contentDescription = navigationItem.label
                            )
                        },
                        onClick = {
                            navController.navigate(navigationItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        },
        topBar = {
            WTTTopBar()
        },
        containerColor = MaterialTheme.colorScheme.primaryContainer,
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Latest.route,
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            composable(Screens.Latest.route) {
                LatestScreen(
                    navController
                )
            }
            composable(Screens.Events.route) {
                EventsScreen(
                    navController
                )
            }
            composable(Screens.Video.route) {
                VideoScreen(
                    navController
                )
            }
            composable(Screens.Players.route) {
                PlayersScreen(
                    navController
                )
            }
            composable(Screens.Profile.route) {
                ProfileScreen(
                    navController
                )
            }
            composable(
                Screens.PlayerInfo.route,
                arguments = listOf(
                    navArgument("name") { type = NavType.StringType },
                    navArgument("country") { type = NavType.StringType },
//                    navArgument("flag") { type = NavType.StringType },
                    navArgument("points") { type = NavType.StringType },
                    navArgument("ranking") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val playerData = PlayerData(
                    profileImage = backStackEntry.arguments?.getString("image") ?: "",
                    name = backStackEntry.arguments?.getString("name") ?: "",
                    country = backStackEntry.arguments?.getString("country") ?: "",
                    ranking = backStackEntry.arguments?.getString("ranking") ?: "",
                    countryFlag = backStackEntry.arguments?.getString("flag") ?: "",
                    points = backStackEntry.arguments?.getString("points") ?: "",
                    lastMatch = ""
                )
                PlayerInfoScreen(
                    navController,
                    name = playerData.name,
                    ranking = playerData.ranking,
                    points = playerData.points,
                    country = playerData.country,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WTTTopBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        title = {
            Text("")
        },
        navigationIcon = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 120.dp),
                    painter = painterResource(id = R.drawable.main_logo),
                    contentDescription = "Home"
                )
            }
        }
    )
}
