package io.astronout.gamescataloguecompose.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import io.astronout.gamescataloguecompose.presentation.NavGraphs
import io.astronout.gamescataloguecompose.presentation.appCurrentDestinationAsState
import io.astronout.gamescataloguecompose.presentation.startAppDestination

@Composable
fun BottomNavigationBar(
    navController: NavController,
    items: List<BottomBarDestination>,
    modifier: Modifier = Modifier,
    onItemClick: (BottomBarDestination) -> Unit
) {
    val currentDestination = navController.appCurrentDestinationAsState().value ?: NavGraphs.root.startAppDestination
    NavigationBar(modifier = modifier) {
        items.forEach { bottomNavItem ->
            NavigationBarItem(
                selected = currentDestination == bottomNavItem.direction,
                onClick = {
                    if (bottomNavItem.direction != currentDestination) {
                        onItemClick(bottomNavItem)
                    }
                },
                label = {
                    Text(text = stringResource(bottomNavItem.label))
                },
                icon = {
                    Icon(
                        imageVector = if (currentDestination == bottomNavItem.direction) bottomNavItem.selectedIcon else bottomNavItem.unselectedIcon,
                        contentDescription = stringResource(bottomNavItem.label)
                    )
                }
            )
        }
    }
}