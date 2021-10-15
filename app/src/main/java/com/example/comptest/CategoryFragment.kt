package com.example.comptest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.comptest.ui.BaseCardViewShape
import com.example.comptest.ui.ProductItem
import com.example.comptest.ui.theme.CompTestTheme
import com.example.comptest.ui.theme.LightPink
import com.example.comptest.ui.theme.TransparentWhite

class CategoryFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(
                ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner)
            )
            
            setContent {
                CompTestTheme {
                    Surface {
                        CreateCategories()
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun CreateCategories(){

        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {                                                     // Categories
            Row(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)) {
                BaseCardViewShape(clickable = true, endPadding = 20.dp) {
                    ProductItem()
                }
                BaseCardViewShape(clickable = true, endPadding = 20.dp) {
                    ProductItem()
                }
                BaseCardViewShape(clickable = true, endPadding = 20.dp) {
                    ProductItem()
                }
            }

            Row {
                BaseCardViewShape(clickable = true, endPadding = 20.dp) {
                    ProductItem()
                }
                BaseCardViewShape(clickable = true, endPadding = 20.dp) {
                    ProductItem()
                }
            }
        }
    }
}