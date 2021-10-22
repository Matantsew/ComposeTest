package com.example.comptest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.comptest.ui.BaseCardViewShape
import com.example.comptest.ui.CategoryItem
import com.example.comptest.ui.theme.CompTestTheme

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
    private fun CreateCategories(){

        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {                                                     // Categories
            Row(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)) {
                BaseCardViewShape(clickable = true, endPadding = 20.dp) {
                    CategoryItem()
                }
                BaseCardViewShape(clickable = true, endPadding = 20.dp) {
                    CategoryItem()
                }
                BaseCardViewShape(clickable = true, endPadding = 20.dp) {
                    CategoryItem()
                }
            }

            Row {
                BaseCardViewShape(clickable = true, endPadding = 20.dp) {
                    CategoryItem()
                }
                BaseCardViewShape(clickable = true, endPadding = 20.dp) {
                    CategoryItem()
                }
            }
        }
    }
}