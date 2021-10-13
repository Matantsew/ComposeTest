package com.example.comptest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.comptest.ui.*
import com.example.comptest.ui.theme.CompTestTheme
import com.google.accompanist.flowlayout.FlowRow

class MenuFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(
                ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner)
            )

            setContent {
                CompTestTheme {
                    Surface{
                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(20.dp)){
                            FlowRow {
                                BaseCardViewShape(endPadding = 20.dp) {
                                    WeightView(value = 0.0)
                                }

                                BaseCardViewShape {
                                    PricePerKGView(0.0)
                                }
                            }

                            FlowRow{
                                BaseCardViewShape(endPadding = 20.dp) {
                                    InfoView("Pick a category below")
                                }

                                BaseCardViewShape {
                                    TotalPriceView(0.0)
                                }
                            }
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
            FlowRow {
                BaseCardViewShape(clickable = false){
                    WeightView(0.0)
                }
            }
        }
    }
}