package com.example.showdialog

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.showdialog.ui.theme.ShowDialogTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowDialogTheme {
                Surface(color = MaterialTheme.colors.background) {
                    /**call the dialog box*/
                    var visible by remember { mutableStateOf(false) }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = { visible = !visible },
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Text(text = "Click Aqui!")

                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        if (visible) {
                            AlertDialogBoxs(c = this@MainActivity)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AlertDialogBoxs(c: Context){
    /**open the Dialog box*/
    val openDialog = remember{ mutableStateOf(true)}
    /**set Dialog */
    if (openDialog.value){
        AlertDialog(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            ,
            onDismissRequest = { openDialog.value = false },
            title = {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(25.dp))
                ){

                    Text(
                        text = "Mensaje de Alerta",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )


                }
            },
            text = {
                Text(text = "Hola! ,\nDeseas confirmar?",
                    color = Color.White
                )
            },
            confirmButton = {
                TextButton(modifier = Modifier
                    .padding(
                        start = 5.dp,
                        end = 15.dp,
                        top = 5.dp,
                        bottom = 5.dp
                    )
                    .background(
                        color = colorResource(id = R.color.teal_700),
                        shape = CircleShape
                    )
                    ,onClick = {
                        openDialog.value = false
                        Toast.makeText(c,"Confirmaste la Accion",Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Text(text = "Si",
                        color = Color.White
                    )
                }
            },
            dismissButton = {
                TextButton(modifier = Modifier
                    .padding(
                        start = 15.dp,
                        end = 5.dp,
                        top = 5.dp,
                        bottom = 5.dp
                    )
                    .background(
                        color = colorResource(id = R.color.teal_700),
                        shape = CircleShape
                    )
                    ,
                    onClick = {
                        openDialog.value = false
                        Toast.makeText(c,"No Confirmaste la Accion",Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Text(text = "No",
                        color = Color.White
                    )
                }
            },
            backgroundColor = colorResource(id = R.color.purple_700),
            contentColor = colorResource(id = R.color.purple_700),
            shape = RoundedCornerShape(25.dp)

        )
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ShowDialogTheme() {
        /**ok now call the function*/
        /**ok now call the function*/
        var c = MainActivity()
        AlertDialogBoxs(c =c )
    }
}