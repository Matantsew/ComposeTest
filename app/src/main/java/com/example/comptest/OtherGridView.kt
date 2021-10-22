package com.example.comptest

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.comptest.SampleData.products
import com.example.comptest.ui.ProductItem

@Composable
fun <T> GridView(
    cols: Int = 1,
    list: List<T>,
    rowModifier: Modifier = Modifier,
    colModifier: Modifier = Modifier,
    child: @Composable (dataModal: T) -> Unit
) {

    val rows = (list.size / cols) + (if (list.size % cols > 0) 1 else 0)

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

@Preview
@Composable
fun PGrid(){
    GridView(cols = 7, products) {
        ProductItem(it.imageId, it.content)
    }
}