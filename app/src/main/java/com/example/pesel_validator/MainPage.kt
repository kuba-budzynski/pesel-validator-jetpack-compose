package com.example.pesel_validator

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pesel_validator.ui.theme.*

@Preview(showBackground = true)
@Composable
fun MainPage(){
    Surface(color = gray200, modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxHeight(1f)
        ){
            Text(
                text="PESEL Validator",
                color = gray600,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Spacer(modifier = Modifier.padding(12.dp))
            PeselInput()
        }
    }
}