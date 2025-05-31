package com.example.detect.presentation.view

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.detect.R
import com.example.detect.data.model.LoginRequest
import com.example.detect.data.model.utils.LoginValidator
import com.example.detect.presentation.navigation.NavigationActions
import com.example.detect.presentation.view.component.*
import com.example.detect.presentation.view.component.model.OutlinedTextFieldClass
import com.example.detect.ui.theme.PrimaryColor

@Composable
fun LoginPage(navController: NavController) {
    var checked by remember { mutableStateOf(true) }
    var loginRequest by remember { mutableStateOf(LoginRequest("", "")) }
    var isPasswordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Scaffold (topBar = { TopBox() })
    { innerPadding ->
        StaticColumn(Modifier.padding(innerPadding)) {
            MainOutlinedTextField(
                OutlinedTextFieldClass(
                    value = loginRequest.email,
                    onValueChange = { loginRequest = loginRequest.copy(email = it) },
                    label = "Email",
                    leadingIcon = Icons.Default.Email
                )
            )
            MainOutlinedTextField(
                OutlinedTextFieldClass(
                    value = loginRequest.password,
                    onValueChange = { loginRequest = loginRequest.copy(password = it) },
                    label = "Password",
                    isPasswordField = true,
                    isPasswordVisible = isPasswordVisible,
                    onVisibilityToggle = { isPasswordVisible = !isPasswordVisible },
                    leadingIcon = Icons.Default.Password
                )
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    //horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it }
                    )
                    PrimaryText("Remember me", Color.Black)
                }

                PrimaryText(
                    text = "Forgot password ?",
                    color = PrimaryColor,
                    modifier = Modifier.clickable { }
                )
            }
            AppButton("Login",onClick = {
                val errorMessage =  LoginValidator.loginValidationInfo(loginRequest)
                if ( errorMessage != null){
                    Toast.makeText(context,errorMessage, Toast.LENGTH_LONG).show()
                }else{
                    NavigationActions.navigateToHome(navController)
                }
            })
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )
            AuthBox("Continue with Google", R.drawable.devicon_google , {})
            AuthBox("Continue with apple", R.drawable.vector , {})
        }
    }
}