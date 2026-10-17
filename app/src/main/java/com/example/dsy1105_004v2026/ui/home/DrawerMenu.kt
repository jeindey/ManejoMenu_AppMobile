package com.example.dsy1105_004v2026.ui.home

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Grass
import androidx.compose.material.icons.filled.LunchDining
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController

@Composable

fun DrawerMenu(
    username: String,
    navController: NavController

)
{//inicio drawer
    Column(modifier=Modifier.fillMaxSize())
    {//inicio columna
        Box(
            modifier= Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(MaterialTheme.colorScheme.primary)
        ) //fin box
        {
            Text(
                text="Categorias: $username",
                style= MaterialTheme.typography.headlineSmall,
                color= MaterialTheme.colorScheme.onPrimary,
                modifier= Modifier
                    .align(Alignment.BottomStart)
            )
        }

        //Items
        //LazyColumn: Crea una ista de elementos que pueden despazar
        LazyColumn(modifier = Modifier.weight(1f)) {
            item {
                NavigationDrawerItem(
                    label = {Text("Hamburguesa BBQ, ")},
                    selected = false,
                    onClick = {
                        val nombre= Uri.encode("Hamburguesa Clasica")
                        val precio="5000"

                        navController.navigate("ProductoFormScreen/$nombre/$precio")



                    /*fin accion*/},
                    icon = { Icon(Icons.Default.LunchDining,
                        contentDescription = "BBQ")}

                )
            }//fin item1

            item {
                NavigationDrawerItem(
                    label = {Text("Hamburguesa Veggie, ")},
                    selected = false,
                    onClick = {/*accion*/},
                    icon = { Icon(Icons.Default.Grass,
                        contentDescription = "Veggier")}

                )
            }//fin item2

            item {
                NavigationDrawerItem(
                    label = {Text("Hamburguesa Clasica, ")},
                    selected = false,
                    onClick = {/*accion*/},
                    icon = { Icon(Icons.Default.Fastfood,
                        contentDescription = "Clasica")}

                )
            }//fin item3

        }// fin lazy column

    }//fin columna

}//fin drawer

@Preview(showBackground =  true)
@Composable

fun DrawerMenuPreview(){
    val navController = rememberNavController()
    DrawerMenu(username = "Usuario Prueba", navController=navController)

}// fin DrawerMenuPreview