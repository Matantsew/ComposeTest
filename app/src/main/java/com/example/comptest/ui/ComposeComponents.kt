package com.example.comptest.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comptest.R
import com.example.comptest.ui.theme.BrightGray

@Composable
fun BaseCardView(clickable: Boolean, function: @Composable BoxScope.() -> Unit) {

    Card(modifier = Modifier
        .padding(50.dp)
        .border(width = 0.5.dp, color = Color.Gray, shape = RoundedCornerShape(7.dp))
        .clip(RoundedCornerShape(7.dp))
        .clickable(enabled = clickable, onClick = {})){

        Box(contentAlignment = Alignment.Center, content = function)
    }
}

@Preview
@Composable
fun WeightView(){

    Column(Modifier.width(200.dp)) {
        Row(modifier = Modifier
            .background(color = BrightGray)
            .fillMaxWidth()){
            Text(text = "kg", modifier = Modifier.padding(5.dp))
        }

        Text(text = "20.35", fontSize = 30.sp, modifier = Modifier.padding(5.dp))
    }
}

@Composable
fun Picture() {

    Image(painter = painterResource(id = R.drawable.vege_pic),
        contentDescription = "Product photo", modifier = Modifier.clip(RoundedCornerShape(10.dp)))
}

@Composable
fun ProductItem(){

    Card(modifier = Modifier
        .padding(50.dp)
        .border(width = 0.5.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
        .clip(RoundedCornerShape(10.dp))
        .clickable(enabled = true, onClick = {

        })){

        Box(contentAlignment = Alignment.Center) {
            Picture()
/*
                Text(text = content,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center)*/
        }
    }
}

@Composable
fun LaunchProductMenu() {
    Row(
        modifier = Modifier
            .padding(10.dp)
    ) {
        ProductItem()
    }
}