package fr.eni.ecole.eni_shop.ui.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormTextInput(
    label: String,
    modifier : Modifier = Modifier,
    setValue: (String) -> Unit, inputType: String? = null,
    value: String,
    placeholder: @Composable () -> Unit = {},
    enabled: Boolean = true,
    trailingIcon: @Composable () -> Unit = {}
) {
    var textFieldValue by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .border(2.dp, Color.LightGray, RoundedCornerShape(16.dp))
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = label,
            fontSize = 20.sp
        );
        TextField(
            enabled = enabled,
            trailingIcon = trailingIcon,
            value = value,
            onValueChange = setValue,
            keyboardOptions = KeyboardOptions(
                keyboardType = when (inputType) {
                    "number" -> KeyboardType.Number
                    "text" -> KeyboardType.Text
                    "email" -> KeyboardType.Email
                    else -> KeyboardType.Text
                }
            ),
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            placeholder = placeholder
        )
    }
}