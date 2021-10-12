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
import com.example.comptest.ui.BaseCardViewShape
import com.example.comptest.ui.InfoView
import com.example.comptest.ui.PricePerKGView
import com.example.comptest.ui.WeightView
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
                        Row(horizontalArrangement = Arrangement.SpaceBetween){
                            FlowRow {
                                BaseCardViewShape(clickable = false) {
                                    WeightView(value = 0.0)
                                }

                                BaseCardViewShape(clickable = false) {
                                    PricePerKGView(0.0)
                                }
                            }

                            FlowRow{
                                BaseCardViewShape(clickable = false) {
                                    InfoView("Pick a category below")
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
            Row {
                WeightView(12.50)
            }
        }
    }
}