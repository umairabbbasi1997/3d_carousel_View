package com.example.carouseldemo.demo.carouselviewdemo

import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.carouseldemo.R
import com.gtomato.android.ui.transformer.FlatMerryGoRoundTransformer
import com.gtomato.android.ui.widget.CarouselView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // referencing the image view from the item.xml file
        val carousel = findViewById<CarouselView>(R.id.carousel)





        var imagesArrayList :ArrayList<Int> =ArrayList<Int>()
        imagesArrayList.add(R.drawable.brv)
        imagesArrayList.add(R.drawable.hrv)
        imagesArrayList.add(R.drawable.civic)
        imagesArrayList.add(R.drawable.hybrid)
/*
        imagesArrayList.add(R.drawable.brv)
        imagesArrayList.add(R.drawable.hrv)
        imagesArrayList.add(R.drawable.civic)
        imagesArrayList.add(R.drawable.hybrid)
*/




        var flatMerryGoRoundTransformer = FlatMerryGoRoundTransformer()
     /*   flatMerryGoRoundTransformer.farScale = 1.0
        */
        flatMerryGoRoundTransformer.farAlpha =.8
        flatMerryGoRoundTransformer.viewPerspective = .1
        flatMerryGoRoundTransformer.numPies = imagesArrayList.size

        carousel.transformer = flatMerryGoRoundTransformer
        carousel.adapter = MyDataAdapter(applicationContext,imagesArrayList)

        carousel.gravity = Gravity.CENTER
        carousel.isInfinite = true
        carousel.setEnableFling(false);
        carousel.setClipChildren(true);
        carousel.clipToPadding = false




        (carousel.adapter as MyDataAdapter).notifyDataSetChanged();



    }
}