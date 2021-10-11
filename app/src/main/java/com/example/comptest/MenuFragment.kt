package com.example.comptest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.example.comptest.ui.BaseCardView
import com.example.comptest.ui.ProductItem
import com.example.comptest.ui.WeightView
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
                        Row{
                            BaseCardView(clickable = false) {
                                WeightView()
                            }
                        }
                        Column {

                            val listOfProducts = remember {
                                SampleData.products
                            }

                            //LaunchProductMenu()
                        }
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        CompTestTheme {
            Row {
                WeightView()
            }
        }
    }
}