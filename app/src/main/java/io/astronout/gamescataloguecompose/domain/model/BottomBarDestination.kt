package io.astronout.gamescataloguecompose.domain.model

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec
import io.astronout.gamescataloguecompose.R
import io.astronout.gamescataloguecompose.presentation.destinations.DetailScreenDestination
import io.astronout.gamescataloguecompose.presentation.destinations.HomeScreenDestination

enum class BottomBarDestination(
    val direction: DirectionDestinationSpec,
    @StringRes val label: Int,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
) {
    Home(HomeScreenDestination, R.string.title_home, Icons.Filled.Home, Icons.Outlined.Home),
    Search(DetailScreenDestination, R.string.title_search, Icons.Filled.Search, Icons.Outlined.Search),
    Bookmark(DetailScreenDestination, R.string.title_bookmark, Icons.Default.BookmarkBorder, Icons.Default.BookmarkBorder),
}