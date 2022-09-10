package com.dmsoftware.calculator.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dmsoftware.calculator.navigation.Route
import com.dmsoftware.calculator.presentation.AppBarState
import com.dmsoftware.calculator.presentation.CalculatorHistoryScreen
import com.dmsoftware.calculator.presentation.calculator.CalculatorScreen
import com.dmsoftware.calculator.ui.theme.MaterialCalculatorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialCalculatorTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                var appBarState by remember {
                    mutableStateOf(AppBarState())
                }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState,

                    topBar = {
                        TopAppBar(
                            title = {
                                Text(appBarState.title)
                            },
                            actions = {
                                appBarState.actions?.invoke(this)
                            },
                            backgroundColor = MaterialTheme.colors.primary,
                            contentColor = Color.White,
                            elevation = 10.dp
                        )
                    },
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Route.CALCULATOR
                    ) {
                        composable(Route.CALCULATOR) {
                            CalculatorScreen(
                                onNextClick = {
                                    navController.navigate(Route.CALCULATOR_HISTORY)
                                },
                                onComposing = {
                                    appBarState = it
                                }
                            )
                        }
                        composable(Route.CALCULATOR_HISTORY) {
                            CalculatorHistoryScreen(
                                onComposing = {
                                    appBarState = it
                                })
                                }
                        }
                    }
                }
            }
        }
}