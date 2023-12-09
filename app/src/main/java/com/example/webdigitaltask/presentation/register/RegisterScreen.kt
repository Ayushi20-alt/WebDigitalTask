package com.example.webdigitaltask.presentation.register

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.webdigitaltask.data.remote.dto.registerdto.Register

@Composable
fun RegistrationScreen(viewmodel: RegisterViewModel, navController: NavController) {

    val nameErrorState = remember { mutableStateOf(false) }
    val mobileErrorState = remember { mutableStateOf(false) }
    val emailErrorState = remember { mutableStateOf(false) }
    val passwordErrorState = remember { mutableStateOf(false) }
    val confirmPasswordErrorState = remember { mutableStateOf(false) }
    val genderErrorState = remember { mutableStateOf(false) }
    val ageErrorState = remember { mutableStateOf(false) }
    val addressErrorState = remember { mutableStateOf(false) }
    val cityErrorState = remember { mutableStateOf(false) }
    val pincodeErrorState = remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
    ) {
        var context = LocalContext.current
        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var mobileNo by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }
        var gender by remember { mutableStateOf("") }
        var age by remember { mutableStateOf("") }
        var address by remember { mutableStateOf("") }
        var city by remember { mutableStateOf("") }
        var pincode by remember { mutableStateOf("") }
        // starting text
        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Red)) {
                append("R")
            }
            withStyle(style = SpanStyle(color = Color.Black)) {
                append("egistration")
            }
        }, fontSize = 30.sp)
        Spacer(Modifier.size(16.dp))
        // Name
        OutlinedTextField(
            value = name,
            onValueChange = {
                if (nameErrorState.value) {
                    nameErrorState.value = false
                }
                name = it
            },

            modifier = Modifier.fillMaxWidth(),
            isError = nameErrorState.value,
            label = {
                Text(text = "Name*")
            },
        )
        if (nameErrorState.value) {
            Text(text = "Required", color = Color.Red)
        }
        Spacer(Modifier.size(16.dp))

        // Email
        OutlinedTextField(
            value = email,
            onValueChange = {
                if (emailErrorState.value) {
                    emailErrorState.value = false
                }
                email = it
            },

            modifier = Modifier.fillMaxWidth(),
            isError = emailErrorState.value,
            label = {
                Text(text = "Email*")
            },
        )
        if (emailErrorState.value) {
            Text(text = "Required", color = Color.Red)
        }
        Spacer(modifier = Modifier.size(16.dp))

        // Mobile No.
        OutlinedTextField(
            value = mobileNo,
            onValueChange = {
                if (mobileErrorState.value) {
                    mobileErrorState.value = false
                }
                mobileNo = it
            },
            modifier = Modifier.fillMaxWidth(),
            isError = mobileErrorState.value,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
                autoCorrect = false
            ),
            label = {
                Text(text = "Mobile No*")
            },
        )
        if (mobileErrorState.value) {
            Text(text = "Required", color = Color.Red)
        }

        Spacer(modifier = Modifier.size(16.dp))

        // Gender
        OutlinedTextField(
            value = gender,
            onValueChange = {
                if (genderErrorState.value) {
                    genderErrorState.value = false
                }
                gender = it
            },

            modifier = Modifier.fillMaxWidth(),
            isError = genderErrorState.value,
            label = {
                Text(text = "Gender*")
            },
        )
        if (genderErrorState.value) {
            Text(text = "Required", color = Color.Red)
        }

        Spacer(modifier = Modifier.size(16.dp))

        // City
        OutlinedTextField(
            value = city,
            onValueChange = {
                if (cityErrorState.value) {
                    cityErrorState.value = false
                }
                city = it
            },

            modifier = Modifier.fillMaxWidth(),
            isError = cityErrorState.value,
            label = {
                Text(text = "City*")
            },
        )
        if (cityErrorState.value) {
            Text(text = "Required", color = Color.Red)
        }

        Spacer(modifier = Modifier.size(16.dp))

        // Address
        OutlinedTextField(
            value = address,
            onValueChange = {
                if (addressErrorState.value) {
                    addressErrorState.value = false
                }
                address = it
            },

            modifier = Modifier.fillMaxWidth(),
            isError = addressErrorState.value,
            label = {
                Text(text = "Address*")
            },
        )
        if (addressErrorState.value) {
            Text(text = "Required", color = Color.Red)
        }
        Spacer(modifier = Modifier.size(16.dp))

        // age and pincode
        Row() {
            OutlinedTextField(
                value = age,
                onValueChange = {
                    if (ageErrorState.value) {
                        ageErrorState.value = false
                    }
                    age = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    autoCorrect = false
                ),
                modifier = Modifier.fillMaxWidth(0.3f),
                label = {
                    Text(text = "Age*")
                },
            )
            if (ageErrorState.value) {
                Text(text = "Required", color = Color.Red)
            }
            Spacer(modifier = Modifier.size(16.dp))
            OutlinedTextField(
                value = pincode,
                onValueChange = {
                    if (pincodeErrorState.value) {
                        pincodeErrorState.value = false
                    }
                    pincode = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    autoCorrect = false
                ),
                label = {
                    Text(text = "Pincode*")
                },
            )
            if (pincodeErrorState.value) {
                Text(text = "Required", color = Color.Red)
            }
        }

        Spacer(modifier = Modifier.size(16.dp))

        // Password
        val passwordVisibility = remember { mutableStateOf(true) }
        OutlinedTextField(
            value = password,
            onValueChange = {
                if (passwordErrorState.value) {
                    passwordErrorState.value = false
                }
                password = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Password*")
            },
            isError = passwordErrorState.value,
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility.value = !passwordVisibility.value
                }) {
                    Icon(
                        imageVector = if (passwordVisibility.value) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                        contentDescription = "visibility",
                        tint = Color.Red
                    )
                }
            },
            visualTransformation = if (passwordVisibility.value) PasswordVisualTransformation() else VisualTransformation.None
        )
        if (passwordErrorState.value) {
            Text(text = "Required", color = Color.Red)
        }

        Spacer(Modifier.size(16.dp))

        // Comfirm Password
        val cPasswordVisibility = remember { mutableStateOf(true) }
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {
                if (confirmPasswordErrorState.value) {
                    confirmPasswordErrorState.value = false
                }
                confirmPassword = it
            },
            modifier = Modifier.fillMaxWidth(),
            isError = confirmPasswordErrorState.value,
            label = {
                Text(text = "Confirm Password*")
            },
            trailingIcon = {
                IconButton(onClick = {
                    cPasswordVisibility.value = !cPasswordVisibility.value
                }) {
                    Icon(
                        imageVector = if (passwordVisibility.value) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                        contentDescription = "visibility",
                        tint = Color.Red
                    )
                }
            },
            visualTransformation = if (cPasswordVisibility.value) PasswordVisualTransformation() else VisualTransformation.None
        )
        if (confirmPasswordErrorState.value) {
            val msg = if (confirmPassword.isEmpty()) {
                "Required"
            } else if (confirmPassword != password) {
                "Password not matching"
            } else {
                ""
            }
            Text(text = msg, color = Color.Red)
        }
        Spacer(Modifier.size(16.dp))

        // Navigating Button
        Button(
            onClick = {
                when {
                    name.isEmpty() -> {
                        nameErrorState.value = true
                    }

                    age.isEmpty() -> {
                        ageErrorState.value = true
                    }

                    address.isEmpty() -> {
                        addressErrorState.value = true
                    }

                    city.isEmpty() -> {
                        cityErrorState.value = true
                    }

                    pincode.isEmpty() -> {
                        pincodeErrorState.value = true
                    }

                    gender.isEmpty() -> {
                        nameErrorState.value = true
                    }

                    mobileNo.isEmpty() -> {
                        mobileErrorState.value = true
                    }

                    email.isEmpty() -> {
                        emailErrorState.value = true
                    }

                    password.isEmpty() -> {
                        passwordErrorState.value = true
                    }

                    confirmPassword.isEmpty() -> {
                        confirmPasswordErrorState.value = true
                    }

                    confirmPassword != password -> {
                        confirmPasswordErrorState.value = true
                    }

                    else -> {
                        Toast.makeText(
                            context,
                            "Registered successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                        var data = Register(name = name, gender = gender , age = age.toInt() ,
                            phone = mobileNo ,email = email, address = address, city = city,
                            password = password, confirm = confirmPassword , pincode = pincode)
                        viewmodel.register(data)
                        navController.navigate("home_screen") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                }
            },
            content = {
                Text(text = "Register", color = Color.White)
            },
            modifier = Modifier.fillMaxWidth(),
            //  colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        )
        Spacer(Modifier.size(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            TextButton(onClick = {
                navController.navigate("login_screen") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }) {
                Text(text = "Login", color = Color.Red)
            }
        }
    }
}