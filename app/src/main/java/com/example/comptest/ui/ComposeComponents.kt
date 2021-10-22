package com.example.comptest.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.comptest.R
import com.example.comptest.SampleData.products
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
fun CategoryItem(){

    Box {

        Image(painter = painterResource(id = R.drawable.vege_pic),
            contentDescription = "Product photo", modifier = Modifier.height(140.dp))
       /*
        Text(text = "content",
            fontSize = 25.sp,
            textAlign = TextAlign.Center)*/
    }
}

@Composable
fun ProductItem(pictureId: Int? = null, productName: String? = null){

    val picId = pictureId ?: R.drawable.ic_baseline_local_grocery_store_24
    val prodName = productName ?: "product"

    Column(modifier = Modifier
        .width(150.dp)
        .height(150.dp), verticalArrangement = Arrangement.SpaceBetween) {
        Image(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
            painter = painterResource(id = picId),
            contentDescription = "Product photo")

        Text(text = prodName,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(bottom = 15.dp, start = 10.dp, end = 10.dp),
            fontSize = 14.sp,
            textAlign = TextAlign.Center)
    }
}

@Composable
fun <T> ComposableGridView(
    cols: Int = 1,
    list: List<T>,
    rowModifier: Modifier = Modifier,
    colModifier: Modifier = Modifier,
    child: @Composable (dataModal: T) -> Unit
) {

    val rows = 2 // (list.size / cols) + (if (list.size % cols > 0) 1 else 0)

    LazyRow{
        items(1){
            Column(modifier = colModifier) {

                for (r in 0 until rows) {
                    Row(modifier = rowModifier, horizontalArrangement = Arrangement.SpaceAround) {
                        for (cell in 0 until cols) {
                            val i = (r * cols) + cell
                            if (i < list.size) { child(list[i]) } else { break }
                        }
                    }
                }
            }
        }
    }
}


// Components: **************************************************************************************************************************************


@Composable
fun BaseCardViewShape(clickable: Boolean = false, allPadding: Dp = 0.dp, endPadding: Dp = 0.dp, function: @Composable BoxScope.() -> Unit) {

    Card(modifier = Modifier
        .padding(allPadding)
        .padding(end = endPadding)
        .border(width = 0.5.dp, color = Color.Gray, shape = RoundedCornerShape(7.dp))
        .clip(RoundedCornerShape(7.dp))
        .clickable(enabled = clickable, onClick = {})){

        Box(contentAlignment = Center, content = function)
    }
}

@Composable
fun MarkerOnScaleCircle(markerColor: Color){

    Box(modifier = Modifier
        .width(30.dp)
        .height(30.dp), contentAlignment = Center) {

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