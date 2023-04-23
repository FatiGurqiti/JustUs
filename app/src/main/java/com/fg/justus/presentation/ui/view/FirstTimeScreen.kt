package com.fg.justus.presentation.ui.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fg.justus.R
import com.fg.justus.presentation.ui.navigation.Screen
import com.fg.justus.presentation.ui.viewmodel.MainViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

private lateinit var navCtrl: NavController

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {
    navCtrl = navController
    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPagerScreen()
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPagerScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val pagerState = rememberPagerState()

        HorizontalPager(
            count = 3,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { currentPage ->
            when (currentPage) {
                0 -> FirstPage()
                1 -> SecondPage()
                2 -> ThirdPage()
            }
        }
    }
}

@Composable
fun FirstPage() {
    Column(
        modifier = GradientBackgroundModifier(
            firstColor = Color(0xFF00AAFF),
            secondColor = Color(0x560098B7)
        ),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Welcome to \n Just Us",
            color = Color.White,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Image(
            painterResource(R.drawable.first_strip),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = "Where we \n" +
                    "keep things for\nourselves",
            color = Color.White,
            fontSize = 32.sp,
            textAlign = TextAlign.Start,
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = "Skip",
                color = Color(0x90FFFFFF),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(8.dp))
            ThreeDot(0)
        }
    }
}

@Composable
fun SecondPage() {
    Column(
        modifier = GradientBackgroundModifier(
            firstColor = Color(0xFF23FA79),
            secondColor = Color(0x6523FA79)
        ),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Spacer(modifier = Modifier.fillMaxHeight(.05f))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Data safer than\n ever",
            color = Color.White,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.fillMaxHeight(.12f))
        Image(
            painterResource(R.drawable.second_stripe),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = "With extra layer of \nencryption your data is safe\nfrom everyone!",
            color = Color.White,
            fontSize = 28.sp,
            textAlign = TextAlign.End,
        )

        Spacer(modifier = Modifier.height(32.dp))
        ThreeDot(1)
    }
}

@Composable
fun ThirdPage() {
    Column(
        modifier = GradientBackgroundModifier(
            firstColor = Color(0xFFFFE600),
            secondColor = Color(0x90FFE601)
        ),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Your data on \nyour control",
            color = Color.White,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = "Save your \ndata locally,\nupon your\n request",
            color = Color.White,
            fontSize = 28.sp,
            textAlign = TextAlign.End,
        )

        Image(
            painterResource(R.drawable.third_stripe),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .fillMaxHeight(0.25f),
                onClick = { endFirstTimeScreen() }
            ) {
                Text(text = "Start", fontSize = 18.sp)
            }
        }
        ThreeDot(2)
    }
}

@Composable
private fun GradientBackgroundModifier(firstColor: Color, secondColor: Color): Modifier {
    return Modifier
        .fillMaxSize()
        .background(
            brush = Brush.linearGradient(
                colors = listOf(firstColor, secondColor),
                start = Offset(0f, 0f),
                end = Offset.Infinite
            )
        )
}


@Composable
fun ThreeDot(bigDot: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        for (i in 0..2) {
            val size = if (i == bigDot) 16.dp else 12.dp
            val color = if (i == bigDot) Color.White else Color(0x70FFFFFF)
            Canvas(
                modifier = Modifier
                    .size(size = size)
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {
                drawCircle(color = color)
            }

            Spacer(modifier = Modifier.width(20.dp))
        }

    }
}

fun endFirstTimeScreen() {
    navCtrl.navigate(Screen.SecondScreen.route)
}