package com.arc.tcg.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.arc.tcg.ui.screens.carddetails.CardDetails
import com.arc.tcg.ui.screens.cardslist.CardList

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.List.route) {
        composable(Screen.List.route) {
            CardList(onItemClicked = { id ->
                navController.navigate("${Screen.Details.route}/$id")
            })
        }
        composable(Screen.Details.route + "/{id}",
            arguments = listOf(navArgument(Arg.ID){
                type = NavType.StringType
                nullable = true
            })) {
            CardDetails()
        }
    }
}

object Arg {
    const val ID = "id"
}