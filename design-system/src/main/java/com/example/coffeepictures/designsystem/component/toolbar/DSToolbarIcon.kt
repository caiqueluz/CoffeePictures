package com.example.coffeepictures.designsystem.component.toolbar

import androidx.compose.ui.graphics.vector.ImageVector

interface DSToolbarIcon {
    val imageVector: ImageVector
    val onIconClicked: () -> Unit

    data class Model(
        override val imageVector: ImageVector,
        override val onIconClicked: () -> Unit,
    ) : DSToolbarIcon
}
