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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
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
                    Surface(color = LightPink) {

                        val listOfCategories = remember {
                            SampleData.categories
                        }

                        LaunchCategory(categories = listOfCategories)
                    }
                }
            }
        }
    }

    @Composable
    fun CategoryItem(content: String, imageId: Int?){
        Card(modifier = Modifier
            .padding(10.dp)
            .clickable(enabled = true, onClick = {

            })){

            Box(Modifier.background(color = TransparentWhite)) {
                ImageHint(imageId)

                Text(text = content,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp))
            }
        }
    }

    @Composable
    fun ImageHint(id: Int?) {

        val photoId = id ?: R.drawable.ic_baseline_local_grocery_store_24

        Image(
            painter = painterResource(id = photoId),
            contentDescription = "Category photo",
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
        )
    }
    
    @Composable
    fun LaunchCategory(categories: MutableList<Category>){
        LazyRow(modifier = Modifier.padding(10.dp)){
            items(categories){
                category: Category ->
                CategoryItem(content = category.name, imageId = category.picId)
            }
        }
    }

    @Preview
    @Composable
    fun PreviewCategoryItem(){
        Surface {
            CategoryItem("Weissbrot", R.drawable.sliced_bread)
        }
    }
    
}