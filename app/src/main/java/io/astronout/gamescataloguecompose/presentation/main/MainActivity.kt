package io.astronout.gamescataloguecompose.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
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
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContent {
            GamesCatalogueComposeTheme {
//                val colors = MaterialTheme.colorScheme
//                val systemUiController = rememberSystemUiController()
//                var statusBarColor by remember { mutableStateOf(colors.onPrimary) }
//                var navigationBarColor by remember { mutableStateOf(colors.onPrimary) }

//                val animatedStatusBarColor by animateColorAsState(
//                    targetValue = statusBarColor,
//                    animationSpec = tween(),
//                    label = ""
//                )
//                val animatedNavigationBarColor by animateColorAsState(
//                    targetValue = navigationBarColor,
//                    animationSpec = tween(),
//                    label = ""
//                )

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
//                        LaunchedEffect(animatedStatusBarColor, animatedNavigationBarColor) {
//                            systemUiController.setStatusBarColor(animatedStatusBarColor)
//                            systemUiController.setNavigationBarColor(animatedNavigationBarColor)
//                        }
                    }
                }
            }
        }
    }
}