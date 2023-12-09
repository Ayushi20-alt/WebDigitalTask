package com.example.webdigitaltask.presentation.Car

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.webdigitaltask.R
import com.example.webdigitaltask.domain.model.Car
import com.example.webdigitaltask.presentation.Dimens.ExtraSmallPadding
import com.example.webdigitaltask.presentation.Dimens.MediumPadding1
import kotlinx.coroutines.runBlocking

@Composable
fun CarScreen(state : CarState,viewModel: CarViewModel, navController: NavController)
{
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(scrollState),
    ) {

        var carName by remember { mutableStateOf("") }
        var color by remember { mutableStateOf("") }
        var modelYear by remember { mutableStateOf("") }
        var cost by remember { mutableStateOf("") }
        var carType by remember { mutableStateOf("") }

        Text(
            text = "Car Name:",
            modifier = Modifier.padding(bottom = 8.dp)
        )
        TextField(
            value = carName,
            onValueChange = {carName = it},
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Color:",
            modifier = Modifier.padding(bottom = 8.dp, top = 16.dp)
        )
        TextField(
            value = color,
            onValueChange = { color = it },
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Car Type: AC/NON-AC",
            modifier = Modifier.padding(bottom = 8.dp, top = 16.dp)
        )
        TextField(
            value = carType.toString(),
            onValueChange = { carType = it },
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Model Year:",
            modifier = Modifier.padding(bottom = 8.dp, top = 16.dp)
        )
        TextField(
            value = modelYear.toString(),
            onValueChange = { modelYear = it },
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Cost:",
            modifier = Modifier.padding(bottom = 8.dp, top = 16.dp)
        )
        TextField(
            value = cost,
            onValueChange = { cost = it },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.size(16.dp))

        Button(
            onClick = {
                val car = Car(name = carName, color = color, carType = carType, model = modelYear, cost = cost)
                runBlocking { viewModel.upsertarticle(car)
                }
            },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Click Me!")
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MediumPadding1, start = MediumPadding1, end = MediumPadding1)
        ) {
            Text(text = "Articles",
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.black)
            )
            Spacer(modifier = Modifier.size(16.dp))
            ArticlesList(articles = state.articles)
        }
    }

}

@Composable
fun ArticlesList(
    modifier: Modifier = Modifier,
    articles : List<Car>
){
    LazyColumn(
        modifier
            .fillMaxSize()
            .height(500.dp),
        verticalArrangement = Arrangement.spacedBy(MediumPadding1),
        contentPadding = PaddingValues(all = ExtraSmallPadding)
    ){
        items(count = articles.size) {
            // if articles is not null we will show the article card for that
            val article = articles[it]
            ArticleCard(article)}
        }
}

