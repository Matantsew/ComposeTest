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
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comptest.R
import com.example.comptest.ui.theme.*

@Composable
fun WeightView(value: Double){

    Column(
        Modifier
            .width(150.dp), horizontalAlignment = End
    ) {
        Row(modifier = Modifier
            .background(color = BrightGray)
            .height(32.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){

                val markerColor = if(value == 0.0) Gray else Green
                MarkerOnScaleCircle(markerColor)

                Text(text = "kg", modifier = Modifier
                    .padding(end = 12.dp)
                    .align(CenterVertically), style = Typography.body1)
        }

        val valueToShow = if(value == 0.0) 0 else value

        Text(text = "$valueToShow", fontSize = 40.sp, modifier = Modifier.padding(end = 12.dp), textAlign = TextAlign.Center)
    }
}

@Composable
fun PricePerKGView(value: Double){

    Column(
        Modifier
            .width(150.dp), horizontalAlignment = End
    ) {
        Row(modifier = Modifier
            .background(color = BrightGray)
            .height(32.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.End){
            Text(text = "CHF/kg", modifier = Modifier
                .padding(end = 12.dp)
                .align(CenterVertically), style = Typography.body1)
        }

        val valueToShow = if(value == 0.0) 0 else value
        val textColor = if(value == 0.0) TextGray else Color.Black

        Text(text = "$valueToShow", color = textColor, fontSize = 40.sp, modifier = Modifier.padding(end = 12.dp), textAlign = TextAlign.Center)
    }
}

@Composable
fun TotalPriceView(value: Double){

    Column(
        Modifier
            .width(150.dp), horizontalAlignment = End
    ) {
        Row(modifier = Modifier
            .background(color = BrightGray)
            .height(32.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.End){
            Text(text = "CHF", modifier = Modifier
                .padding(end = 12.dp)
                .align(CenterVertically), style = Typography.body1)
        }

        val valueToShow = if(value == 0.0) 0 else value

        Text(text = "$valueToShow", color = Green, fontSize = 40.sp, modifier = Modifier.padding(end = 12.dp), textAlign = TextAlign.Center)
    }
}

@Composable
fun InfoView(info: String){
    Box(
        modifier = Modifier
            .height(100.dp)
    ){
        Text(text = info, fontSize = 23.sp, modifier = Modifier
            .align(Center)
            .padding(start = 70.dp, end = 70.dp), color = TextGray)
    }
}

@Composable
fun ProductItem(){

    Box {

        Image(painter = painterResource(id = R.drawable.vege_pic),
            contentDescription = "Product photo", modifier = Modifier.height(140.dp))
       /*
        Text(text = "content",
            fontSize = 25.sp,
            textAlign = TextAlign.Center)*/
    }
}



// Components: **************************************************************************************************************************************

@Composable
fun BaseCardViewShape(clickable: Boolean = false, endPadding: Dp = 0.dp, function: @Composable BoxScope.() -> Unit) {

    Card(modifier = Modifier
        .padding(end = endPadding)
        .border(width = 0.5.dp, color = Color.Gray, shape = RoundedCornerShape(7.dp))
        .clip(RoundedCornerShape(7.dp))
        .clickable(enabled = clickable, onClick = {})){

        Box(contentAlignment = Center, content = function)
    }
}

@Composable
fun MarkerOnScaleCircle(markerColor: Color){

    Box(modifier = Modifier.width(30.dp).height(30.dp), contentAlignment = Center) {

            Canvas(modifier = Modifier
                .padding(top = 3.dp, start = 3.dp)
                .width(15.dp)
                .height(15.dp),
                onDraw = {
                    drawCircle(
                        color = markerColor
                    )
                }
            )
    }
}