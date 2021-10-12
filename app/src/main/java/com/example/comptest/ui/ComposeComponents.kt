package com.example.comptest.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comptest.R
import com.example.comptest.ui.theme.BrightGray
import com.example.comptest.ui.theme.Green
import com.example.comptest.ui.theme.TextGray
import com.example.comptest.ui.theme.Typography

@Composable
fun WeightView(value: Double){

    Column(
        Modifier
            .width(200.dp)
            .height(100.dp), horizontalAlignment = Alignment.End) {
        Row(modifier = Modifier
            .background(color = BrightGray)
            .height(32.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
            MarkerOnScaleCircle()
            Text(text = "kg", modifier = Modifier
                .width(30.dp)
                .align(CenterVertically), style = Typography.body1)
        }

        val valueToShow = if(value == 0.0) 0 else value

        Text(text = "$valueToShow", fontSize = 50.sp, modifier = Modifier.width(85.dp))
    }
}

@Composable
fun PricePerKGView(value: Double){

    Column(
        Modifier
            .width(200.dp)
            .height(100.dp), horizontalAlignment = Alignment.End) {
        Row(modifier = Modifier
            .background(color = BrightGray)
            .height(32.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.End){
            Text(text = "CHF/kg", modifier = Modifier
                .width(70.dp)
                .align(CenterVertically), style = Typography.body1)
        }

        val valueToShow = if(value == 0.0) 0 else value

        Text(text = "$valueToShow", fontSize = 50.sp, modifier = Modifier.width(85.dp))
    }
}

@Composable
fun InfoView(info: String){
    Box(
        modifier = Modifier
            .width(400.dp)
            .height(100.dp)
    ){
        Text(text = info, fontSize = 30.sp, modifier = Modifier.align(Center), color = TextGray)
    }
}


// Components: **************************************************************************************************************************************

@Composable
fun BaseCardViewShape(clickable: Boolean, function: @Composable BoxScope.() -> Unit) {

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
fun MarkerOnScaleCircle(){

    Box(Modifier.padding(15.dp)){
        Canvas(modifier = Modifier
            .width(7.dp)
            .height(7.dp),
            onDraw = {
                drawCircle(
                    color = Green,
                    12F,
                    style = Fill,
                    blendMode = BlendMode.Clear
                )
            })
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