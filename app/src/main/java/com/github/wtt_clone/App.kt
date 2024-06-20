package com.github.wtt_clone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.github.wtt_clone.screens.LatestScreen
import com.github.wtt_clone.screens.ProfileScreen
import com.github.wtt_clone.screens.EventsScreen
import com.github.wtt_clone.screens.PlayersScreen
import com.github.wtt_clone.screens.VideoScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                BottomNavigationItem().bottomNavigationItems().forEachIndexed { _, navigationItem ->
                    NavigationBarItem(
                        selected = navigationItem.route == currentDestination?.route,
                        label = {
                            Text(navigationItem.label)
                        },
                        icon = {
                            Icon(
                                navigationItem.icon,
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
        }
    }
}