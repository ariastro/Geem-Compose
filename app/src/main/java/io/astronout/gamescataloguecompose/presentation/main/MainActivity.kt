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
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.navigate
import dagger.hilt.android.AndroidEntryPoint
import io.astronout.core.theme.GamesCatalogueComposeTheme
import io.astronout.gamescataloguecompose.domain.model.BottomBarDestination
import io.astronout.gamescataloguecompose.presentation.NavGraphs

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
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(
                                navController = navController,
                                items = BottomBarDestination.values().toList(),
                                onItemClick = {
                                    navController.navigate(it.direction) {
                                        launchSingleTop = true
                                    }
                                }
                            )
                        }
                    ) {
                        Box(modifier = Modifier.padding(it)) {
                            DestinationsNavHost(navGraph = NavGraphs.root, navController = navController)
                        }
                    }
                }
            }
        }
    }
}