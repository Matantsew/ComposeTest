package com.example.comptest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.comptest.ui.theme.CompTestTheme

class MenuFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(
                ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner)
            )

            setContent {
                CompTestTheme {
                    Surface{
                        Column {

                            val listOfProducts = remember {
                                SampleData.products
                            }

                            LaunchProductMenu(products = listOfProducts)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun ProductItem(){

        Card(modifier = Modifier
            .padding(50.dp)
            .border(width = 0.5.dp, color = Gray, shape = RoundedCornerShape(10.dp))
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
    fun Picture() {

        Image(painter = painterResource(id = R.drawable.vege_pic),
            contentDescription = "Product photo", modifier = Modifier.clip(RoundedCornerShape(10.dp)))
    }

    @Composable
    fun LaunchProductMenu(products: MutableList<Product>) {
        LazyRow(
            modifier = Modifier
                .padding(10.dp)
        ) {
            items(products) { message ->
                ProductItem(/*message.content*/)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        CompTestTheme {
            Row {
                ProductItem()
            }
        }
    }
}