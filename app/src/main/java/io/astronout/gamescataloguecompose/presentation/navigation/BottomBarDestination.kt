package io.astronout.gamescataloguecompose.presentation.navigation

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
import io.astronout.gamescataloguecompose.presentation.destinations.BookmarkScreenDestination
import io.astronout.gamescataloguecompose.presentation.destinations.DetailScreenDestination
import io.astronout.gamescataloguecompose.presentation.destinations.HomeScreenDestination
import io.astronout.gamescataloguecompose.presentation.destinations.SearchScreenDestination

enum class BottomBarDestination(
    val direction: DirectionDestinationSpec,
    @StringRes val label: Int,
    val icon: Int
) {
    Home(HomeScreenDestination, R.string.title_home, R.drawable.ic_ghost),
    Search(SearchScreenDestination, R.string.title_search, R.drawable.ic_search),
    Bookmark(BookmarkScreenDestination, R.string.title_bookmark, R.drawable.ic_bookmark),
}