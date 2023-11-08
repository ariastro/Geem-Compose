package io.astronout.gamescataloguecompose.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.navigate
import dagger.hilt.android.AndroidEntryPoint
import io.astronout.core.theme.GamesCatalogueComposeTheme
import io.astronout.gamescataloguecompose.presentation.NavGraphs
import io.astronout.gamescataloguecompose.presentation.navigation.BottomBarDestination
import io.astronout.gamescataloguecompose.presentation.navigation.BottomNavigationBar

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GamesCatalogueComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val shouldShowBottomBar = navController
                        .currentBackStackEntryAsState().value?.destination?.route in BottomBarDestination.values()
                        .map { it.direction.route }

                    Scaffold(
                        bottomBar = {
                            if (shouldShowBottomBar) {
                                BottomNavigationBar(
                                    navController = navController,
                                    items = BottomBarDestination.values().toList(),
                                    onItemClick = {
                                        navController.navigate(it.direction) {
                                            navController.graph.startDestinationRoute?.let { route ->
                                                popUpTo(route) {
                                                    saveState = true
                                                }
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }
                                )
                            }
                        }
                    ) {
                        Box(modifier = Modifier.padding(it)) {
                            DestinationsNavHost(
                                navGraph = NavGraphs.root,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}