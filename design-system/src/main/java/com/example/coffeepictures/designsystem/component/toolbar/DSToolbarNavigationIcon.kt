package com.example.coffeepictures.designsystem.component.toolbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack

sealed interface DSToolbarNavigationIcon : DSToolbarIcon {
    data class Back(
        override val onIconClicked: () -> Unit,
    ) : DSToolbarNavigationIcon {
        override val imageVector = Icons.AutoMirrored.Filled.ArrowBack
    }
}
