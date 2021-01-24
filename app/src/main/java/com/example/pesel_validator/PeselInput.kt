package com.example.pesel_validator

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pesel_validator.pesel.Validator
import com.example.pesel_validator.ui.theme.*
import java.util.*

@Preview(showBackground = true)
@Composable
fun PeselInput(){
    val peselState = remember { mutableStateOf(TextFieldValue(""))}
    val empty = peselState.value.text.isEmpty()
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedTextField(
            value = peselState.value,
            onValueChange = {
                peselState.value = it
            },
            leadingIcon = { Icon(Icons.Filled.Person) },
            label = {
                val labelContent = if(!Validator.invalid(peselState.value.text) or empty)
                    "Enter your pesel" else "Enter a valid pesel"
                Text(text = labelContent)
            },
            placeholder = { Text(text = "np. 85081334012") },
            isErrorValue = Validator.invalid(peselState.value.text) and !empty,
            activeColor = indigo500,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onImeActionPerformed = { action, softwareController ->
                if (action == ImeAction.Done) {
                    softwareController?.hideSoftwareKeyboard()
                }
            }
        )
        Text(
            textAlign = TextAlign.Center,
            text = if (!Validator.invalid(peselState.value.text) or empty)
                "" else "Must contain 11 digits",
            style = MaterialTheme.typography.caption.copy(color = Color.Red),
            modifier = Modifier.padding(top = 8.dp)
        )
        Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if(!empty and !Validator.invalid(peselState.value.text)){
                Row(){
                    if(Validator.checkSum(peselState.value.text)){
                        Icon(Icons.Filled.CheckCircle, tint = Color.Green)
                        Text(text = "Pesel is valid")
                    }
                    else {
                        Icon(Icons.Filled.Close, tint = Color.Red)
                        Text(text = "Pesel is invalid")
                    }
                }
            }

            Spacer(modifier = Modifier.padding(12.dp))

            Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Text(text = if (!empty and !Validator.invalid(peselState.value.text)) {
                    if(Validator.isMale(peselState.value.text)) "MALE" else "FEMALE"
                } else "")

                Text(text = if (!empty and !Validator.invalid(peselState.value.text)) {
                    Validator.getBirthDate(peselState.value.text)
                } else "")
            }
        }
    }
}