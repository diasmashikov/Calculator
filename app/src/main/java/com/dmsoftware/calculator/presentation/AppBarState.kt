package com.dmsoftware.calculator.presentation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable

data class AppBarState(
    var navigationIcon: @Composable (() -> Unit)? = {},
    var title: String = "",
    var actions: (@Composable RowScope.() -> Unit)? = null
)