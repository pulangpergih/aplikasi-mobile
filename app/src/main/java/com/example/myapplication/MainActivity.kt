package com.example.myapplication

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.Purple40
import com.example.myapplication.ui.theme.Pink40
import kotlinx.coroutines.delay

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    FormLogin()
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormLogin() {
    val context = LocalContext.current
    val username = remember { mutableStateOf(TextFieldValue("")) }
    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val no_telepon = remember { mutableStateOf(TextFieldValue("")) }
    val email = remember { mutableStateOf(TextFieldValue("")) }
    val alamat = remember { mutableStateOf(TextFieldValue("")) }
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {
//        Title
        Text(text = "Selamat Datang", fontSize = 24.sp)
//        Colmn Name
        Text(text = "Nama", modifier =
        Modifier
            .padding(4.dp)
            .fillMaxWidth())
        TextField(value = nama.value, onValueChange = {
            nama.value = it
        }
//            Colmn Username
            , modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth())
        Text(text = "Username", modifier =
        Modifier
            .padding(4.dp)
            .fillMaxWidth())
        TextField(value = username.value,
            onValueChange = {
                username.value = it
            }
//            Colmn Phone
            , modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth())
        Text(text = "Telepon", modifier =
        Modifier
            .padding(4.dp)
            .fillMaxWidth())
        TextField(value = no_telepon.value,
            onValueChange = {
                no_telepon.value = it
            }
//            Colmn Email
            , modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth())
        Text(text = "Email", modifier =
        Modifier
            .padding(4.dp)
            .fillMaxWidth())
        TextField(value = email.value,
            onValueChange = {
                email.value = it
            }
//            Colmn Address
            , modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth())
        Text(text = "Alamat", modifier =
        Modifier
            .padding(4.dp)
            .fillMaxWidth())
        TextField(value = alamat.value,
            onValueChange = {
                alamat.value = it
            }, modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth())
        val loginButtonColors = ButtonDefaults.buttonColors(
            containerColor = Purple40,
            contentColor = Pink40
        )
        val resetButtonColors = ButtonDefaults.buttonColors(
            containerColor = Pink40,
            contentColor = Purple40
        )
        Divider(modifier = Modifier
            .weight(1f)
            .width(0.dp))
        Row (modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {
                if (username.value.text == "Raka" &&
                    nama.value.text == "Raka Dwi KS" &&
                    email.value.text == "Rdks@mail.com" &&
                    no_telepon.value.text == "123456789" &&
                    alamat.value.text == "Bandung") {
                    Toast.makeText(context, "Berhasil Registrasi", Toast.LENGTH_SHORT).show()
                }else if( nama.value.text == "") {
                    Toast.makeText(context, "Nama harus diisi",
                        Toast.LENGTH_LONG).show()
                }else{
                Toast.makeText(context, "Registrasi Gagal",
                    Toast.LENGTH_LONG).show()
            }
            },  colors = loginButtonColors) {
                Text(
                    text = "Registrasi",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
            Button(modifier = Modifier.weight(5f), onClick = {
                nama.value = TextFieldValue("")
                username.value = TextFieldValue("")
                email.value = TextFieldValue("")
                no_telepon.value = TextFieldValue("")
                alamat.value = TextFieldValue("")
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

//    Column(modifier = Modifier
//        .padding(10.dp)
//        .fillMaxWidth()) {
////        Title
//        Text(text = "Selamat Datang", fontSize = 24.sp)
////        Colmn Username
//        Text(text = "Username", modifier =
//        Modifier
//            .padding(4.dp)
//            .fillMaxWidth())
//        TextField(value = username.value, onValueChange = {
//            username.value = it
//        }
////            Colmn Password
//            , modifier = Modifier
//                .padding(4.dp)
//                .fillMaxWidth())
//        Text(text = "Password", modifier =
//        Modifier.padding(4.dp).fillMaxWidth())
//        TextField(value = password.value,
//            visualTransformation = PasswordVisualTransformation(),
//            onValueChange = {
//                password.value = it
//            }, keyboardOptions = KeyboardOptions(keyboardType =
//            KeyboardType.Password),
//            modifier = Modifier.padding(4.dp).fillMaxWidth())
//        val loginButtonColors = ButtonDefaults.buttonColors(
//            containerColor = Purple40,
//            contentColor = Pink40
//        )
//        val resetButtonColors = ButtonDefaults.buttonColors(
//            containerColor = Pink40,
//            contentColor = Purple40
//        )
//        Divider(modifier = Modifier
//            .weight(1f)
//            .width(0.dp))
//        Row (modifier = Modifier
//            .padding(4.dp)
//            .fillMaxWidth()) {
//            Button(modifier = Modifier.weight(5f), onClick = {
//                if (username.value.text == "admin" &&
//                    password.value.text == "admin" ) {
//                    Toast.makeText(context, "Login Berhasil", Toast.LENGTH_SHORT).show()
//                }else if( username.value.text == "" && password.value.text == "") {
//                    Toast.makeText(context, "Username Harus Di isi.",
//                        Toast.LENGTH_LONG).show()
//                    Toast.makeText(context, "Password Harus Di isi.",
//                        Toast.LENGTH_LONG).show()
//                }else{
//                    Toast.makeText(context, "login Gagal",
//                        Toast.LENGTH_LONG).show()
//                }
//            },  colors = loginButtonColors) {
//                Text(
//                    text = "Login",
//                    style = TextStyle(
//                        color = Color.White,
//                        fontSize = 18.sp
//                    ), modifier = Modifier.padding(8.dp)
//                )
//            }
//            Button(modifier = Modifier.weight(5f), onClick = {
//                username.value = TextFieldValue("")
//                password.value = TextFieldValue("")
//                }, colors = resetButtonColors) {
//                Text(
//                    text = "Reset",
//                    style = TextStyle(
//                        color = Color.White,
//                        fontSize = 18.sp
//                    ), modifier = Modifier.padding(8.dp)
//                )
//            }
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        FormLogin()
    }
}