package com.example.comptest.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comptest.R

@Composable
fun Keyboard() {

    Column{
        Row_1()
        Row_2()
        Row_3()
        Row_4()
    }
}

@Composable
private fun Row_1(){

    var value by remember { mutableStateOf("") }

    Row(modifier = Modifier
        .padding(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
        .fillMaxWidth()){

        BaseCardViewShape(endPadding = 5.dp) {
            Box(modifier = Modifier
                    .width(490.dp)
                    .height(50.dp),
                contentAlignment = Alignment.Center) {
                BasicTextField(
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
                    value = value,
                    onValueChange = { value = it },
                    maxLines = 1,
                    singleLine = true,
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        fontSize = 25.sp,
                    )
                )
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Image(painter = painterResource(id = R.drawable.ic_outline_backspace_24),
                contentDescription = "backspace",
                modifier = Modifier
                    .width(105.dp)
                    .height(50.dp)
                    .padding(10.dp))
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Image(painter = painterResource(id = R.drawable.ic_baseline_clear_24),
                contentDescription = "clear",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .padding(10.dp))
        }

    }
}

@Composable
private fun Row_2(){

    Row(modifier = Modifier
        .padding(start = 5.dp, bottom = 5.dp)
        .fillMaxWidth()){

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "Q")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "W")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "E")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "R")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "T")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "Z")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "U")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "I")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "O")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "P")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "Ü")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "^")
            }
        }
    }

}

@Composable
private fun Row_3(){

    Row(modifier = Modifier
        .padding(start = 5.dp, bottom = 5.dp)
        .fillMaxWidth()){

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "A")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "S")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "D")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "F")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "G")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "H")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "J")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "K")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "L")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "Ö")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "Ä")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Image(painter = painterResource(id = R.drawable.ic_baseline_language_24),
                contentDescription = "clear",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .padding(10.dp))
        }
    }
}

@Composable
private fun Row_4(){

    Row(modifier = Modifier
        .padding(start = 5.dp, bottom = 5.dp)
        .fillMaxWidth()){

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "Y")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "X")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "C")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "V")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "B")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "N")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .fillMaxSize()) {
                Text(modifier = Modifier.align(Alignment.Center),
                    text = "M")
            }
        }

        BaseCardViewShape(clickable = true, endPadding = 5.dp){
            Box(modifier = Modifier
                .height(50.dp)
                .width(270.dp)
                .fillMaxSize()) {

            }
        }
    }
}