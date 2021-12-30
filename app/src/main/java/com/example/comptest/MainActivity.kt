package com.example.comptest

import android.os.Bundle
import android.widget.Button
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import com.example.comptest.SampleData.products
import com.example.comptest.ui.BaseCardViewShape
import com.example.comptest.ui.ComposableGridView
import com.example.comptest.ui.ProductItem
import com.example.comptest.ui.theme.CompTestTheme
import java.util.*

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_test).setOnClickListener {

            val calendar = Calendar.getInstance()

            val dialog = CustomDatePickerDialog(
                this,
                null,
                this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH))

            dialog.show()
        }

/*
        setContent {
            CompTestTheme {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomCenter) {
                    Keyboard()
                }
            }
        }*/
    }

    @Composable
    fun TestGrid(){
        CompTestTheme{

            val columns = if(products.size % 2 == 0)products.size / 2 else products.size / 2 + 1

            ComposableGridView(cols = columns, products){
                BaseCardViewShape(clickable = true, allPadding = 10.dp) {
                    ProductItem(pictureId = it.imageId, productName = it.content)
                }
            }
        }
    }

    @Composable
    fun CreateProducts(){

        CompTestTheme{
            Column(modifier = Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {                                                     // Categories
                Row(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)) {
                    BaseCardViewShape(clickable = true, endPadding = 20.dp) {
                        ProductItem(R.drawable.sliced_bread, "Sliced bread")
                    }
                    BaseCardViewShape(clickable = true, endPadding = 20.dp) {
                        ProductItem(R.drawable.bread, "Bread")
                    }
                    BaseCardViewShape(clickable = true, endPadding = 20.dp) {
                        ProductItem(R.drawable.vege_pic, "Vege")
                    }
                }

                Row {
                    BaseCardViewShape(clickable = true, endPadding = 20.dp) {
                        ProductItem(R.drawable.photo, "Hello there! I'm trying to lengthen the text:)")
                    }
                    BaseCardViewShape(clickable = true, endPadding = 20.dp) {
                        ProductItem(R.drawable.vege_pic, "Cherries from Canada")
                    }
                    BaseCardViewShape(clickable = true, endPadding = 20.dp) {
                        ProductItem(productName = "Apple")
                    }
                }
            }

        }
    }
}