package com.fg.justus.presentation.ui.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.fg.justus.R
import com.fg.justus.presentation.ui.navigation.Screen
import com.fg.justus.presentation.ui.viewmodel.MainViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

class FirstTime(
    private val navController: NavController,
    private val viewModel: MainViewModel
) {
    @Composable
    fun FirstTimeScreen() {
        Box(modifier = Modifier.fillMaxSize()) {
            HorizontalPagerScreen()
        }
    }

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    private fun HorizontalPagerScreen() {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            HorizontalPager(
                count = 3,
                state = rememberPagerState(),
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
    private fun FirstPage() {
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
                painterResource(R.drawable.straight_stripes),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .rotate(30f)
                    .padding(8.dp),
                text = "Where we keep things\nfor ourselves",
                color = Color.White,
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
            )
            ThreeDot(0)
        }
    }

    @Composable
    private fun SecondPage() {
        Column(
            modifier = GradientBackgroundModifier(
                firstColor = Color(0xFF23FA79),
                secondColor = Color(0x6523FA79)
            ),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Data safer than\n ever",
                color = Color.White,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.fillMaxHeight(.05f))

            ConstraintLayout {
                val (round_image, description) = createRefs()
                Image(
                    painterResource(R.drawable.round_stripes),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(round_image) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                        },
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(description) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                        },
                    text = "With extra layer of \nencryption your\ndata is safe\nfrom everyone!",
                    color = Color.White,
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center,
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
            ThreeDot(1)
        }
    }

    @Composable
    private fun ThirdPage() {
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

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painterResource(R.drawable.bubly_stripes),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                text = "Save your data locally,\nupon your request",
                color = Color.White,
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .fillMaxHeight(0.25f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1B17EE)),
                    onClick = { finishFirstTimeScreen() }
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
    private fun ThreeDot(bigDot: Int) {
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

    private fun finishFirstTimeScreen() {
        viewModel.changeFirstTime()
        navController.navigate(Screen.SecondScreen.route)
    }
}