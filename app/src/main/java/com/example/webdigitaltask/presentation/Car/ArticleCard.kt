package com.example.webdigitaltask.presentation.Car

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.webdigitaltask.domain.model.Car
import com.example.webdigitaltask.ui.theme.WebDigitalTAskTheme

@Composable
fun ArticleCard(
   car : Car
){
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = car.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Model Year: ${car.model}",
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Color: ${car.color}",
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "AC/Non-AC: ${car.carType}",
            )
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(MaterialTheme.shapes.medium)
            ) {
                // Text
                Text(
                    text = "Cost: $${car.cost}",
                    color = Color.Green
                )

                // Delete Icon
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(16.dp)
                )
            }
        }
    }
}




//@Preview(showSystemUi = true)
//@Composable
//fun ArticleCardPreview(){
//    WebDigitalTAskTheme {
//        ArticleCard(ca = "Ferrari", color = "yellow", carType = "AC", modelYear = "idk", cost = "very much")
//    }
//}