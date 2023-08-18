package com.akshawty.rizzcard

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.akshawty.rizzcard.ui.NewCardActivity
import com.akshawty.rizzcard.ui.RizzAppScreen

enum class Screens {
    MainScreen,
    NewCardScreen
}
@Composable
fun RizzCardApp(
    model: UIModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.name,

        ) {
        composable(route = Screens.MainScreen.name) {
            RizzAppScreen(model = model) {
                navController.navigate(Screens.NewCardScreen.name)
            }
        }

        composable(route = Screens.NewCardScreen.name) {
            NewCardActivity(
                onConfirmButtonClick = {
                    navController.popBackStack()
                    model.addNewCard()

                },
                onCancelButtonClick = {
                    navController.popBackStack()
                },
                model = model
            )
        }
    }
}