package com.dendroide.clonindriveruber.presentation.screens.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dendroide.clonindriveruber.R
import com.dendroide.clonindriveruber.presentation.components.DefaultTextField

@Composable
fun LoginScreen() {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Scaffold(contentWindowInsets = WindowInsets.navigationBars) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFA8951A), Color(0xFFFFE540))
                    )
                )
                .padding(paddingValues)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .rotate(90f)
                        .padding(top = 10.dp)
                )
                Spacer(
                    modifier = Modifier.height(120.dp)
                )
                Text(
                    text = "Register",
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .rotate(90f)
                        .padding(top = 35.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 60.dp, bottom = 35.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xFFADA047), Color(0xFFF5E059))
                        ), shape = RoundedCornerShape(topStart = 35.dp, bottomStart = 35.dp)
                    )
            ) {
                Column(modifier = Modifier
                    .statusBarsPadding()
                    .padding(start = 25.dp)) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Welcome",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "back...",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 15.dp)){
                        Image(
                            modifier = Modifier
                                .size(200.dp)
                                .align(Alignment.CenterEnd),
                            painter = painterResource(id = R.drawable.car_white),
                            contentDescription = ""
                        )
                    }

                    Text(
                        text = "Log in",
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    DefaultTextField(
                        modifier = Modifier,
                        value = email,
                        label = "Email",
                        icon = Icons.Outlined.Email,
                        onValueChange = {
                            email = it
                        },
                        keyboardType = KeyboardType.Email
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    DefaultTextField(
                        modifier = Modifier,
                        value = password,
                        label = "Password",
                        icon = Icons.Outlined.Lock,
                        onValueChange = {
                            password = it
                        },
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Box(modifier = Modifier.fillMaxWidth()){
                        Button(modifier = Modifier
                            .align(Alignment.Center)
                            .width(250.dp)
                            .height(55.dp),
                            colors = ButtonDefaults.buttonColors(Color.Black)
                            , onClick = {

                        }) {
                            Text(text = "Iniciar sesion", fontSize = 18.sp)
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Row (modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                        Spacer(
                            modifier = Modifier
                                .width(30.dp)
                                .height(1.dp)
                                .background(Color.Black)
                        )
                        Text(text = "O",
                            modifier = Modifier.padding(horizontal = 10.dp),
                            color = Color.Black,
                            fontSize = 20.sp
                        )
                        Spacer(
                            modifier = Modifier
                                .width(30.dp)
                                .height(1.dp)
                                .background(Color.Black)
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))

                    Row (modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center){
                        Text(text = "No tienes cuenta?",
                            color = Color.Black,
                            fontSize = 17.sp
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "Registrate",
                            color = Color.Black,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(50.dp))
                }
            }
        }
    }

}