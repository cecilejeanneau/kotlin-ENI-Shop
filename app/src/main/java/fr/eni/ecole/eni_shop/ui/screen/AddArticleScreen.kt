package fr.eni.ecole.eni_shop.ui.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import fr.eni.ecole.eni_shop.ui.common.EniShopTopBar
import fr.eni.ecole.eni_shop.ui.common.FormTextInput

@Composable
fun AddArticlesScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    Scaffold(
        topBar = { EniShopTopBar(navController = navHostController) },
        modifier = Modifier
            .padding(4.dp),
    ) {
        Column(
            modifier = Modifier.padding(it)
            .verticalScroll(rememberScrollState())
        ) {
            AddArticleForm(navHostController = navHostController)
        }
    }
}

@Composable
fun CategoriesDropDownMenu(
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    onDismissRequest: () -> Unit = {},
    onCategoryChange: (String) -> Unit
) {
    val categories: List<String> =
        listOf(
            "electronics",
            "jewelery",
            "men's clothing",
            "women's clothing"
        );

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest,
    ) {
        categories.forEach { category ->
            DropdownMenuItem(
                text = { Text(text = category) },
                onClick = {
                    onDismissRequest();
                    onCategoryChange(category)
                },
            )
        }
    }
}

@Composable
fun AddArticleForm(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    var title by rememberSaveable {
        mutableStateOf("")
    }
    var description by rememberSaveable {
        mutableStateOf("")
    }
    var price by rememberSaveable {
        mutableStateOf("")
    }
    var category by rememberSaveable {
        mutableStateOf("")
    }
    var expanded by rememberSaveable {
        mutableStateOf(false);
    }

    val context = LocalContext.current;

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FormTextInput(
            label = "Titre",
            setValue = {
                title = it
            },
            value = title,
        );
        FormTextInput(
            label = "Description",
            setValue = {
                description = it
            },
            value = description,
        );
        FormTextInput(
            label = "Prix",
            setValue = {
                price = it
            },
            value = price,
            inputType = "double"
        );

        FormTextInput(
            modifier = Modifier.clickable {
                // need to disable by default the other click from textfield
                expanded = !expanded
            },
            label = "Catégorie",
            setValue = {
                category = it
            },
            enabled = false,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Dropdown"
                )
            },
            value = category,
            placeholder = {
                Text(text = "Choisir une catégorie")
            },
        );
        CategoriesDropDownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            onCategoryChange = {
                category = it;
            }
        );
        Button(
            onClick = {
                Toast.makeText(
                    context,
                    "$title a été ajouté",
                    Toast.LENGTH_LONG
                ).show();
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Enregistrer");
        }
    }
}