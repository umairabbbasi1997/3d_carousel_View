package com.example.carouseldemo.demo.carouselviewdemo

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.carouseldemo.R
import com.example.carouseldemo.demo.carouselviewdemo.SnapOnScrollListener.Companion.NOTIFY_ON_SCROLL
import com.gtomato.android.ui.transformer.FlatMerryGoRoundTransformer
import com.gtomato.android.ui.widget.CarouselView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myAdapter :MyDataAdapter
        // referencing the image view from the item.xml file
        val carousel = findViewById<CarouselView>(R.id.carousel)
        var currentPosition: Int = 0

        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(carousel)



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
        myAdapter = MyDataAdapter(applicationContext,imagesArrayList)
        carousel.adapter = myAdapter


        /*carousel.setOnScrollListener(object : CarouselView.OnScrollListener() {
            override fun onScrolled(carouselView: CarouselView?, dx: Int, dy: Int) {
                super.onScrolled(carouselView, dx, dy)
                if (carouselView != null) {
                    currentPosition = carouselView.currentPosition
                    Toast.makeText(this@MainActivity, "Position $currentPosition", Toast.LENGTH_LONG).show()
                }
            }
        })*/

        carousel.adapter

        carousel.gravity = Gravity.CENTER
        carousel.isInfinite = true
        carousel.setEnableFling(false)
        carousel.setClipChildren(true)
        carousel.clipToPadding = false

        carousel.addOnScrollListener(SnapOnScrollListener(snapHelper, NOTIFY_ON_SCROLL) { position ->
            Toast.makeText(this@MainActivity, "Position $position", Toast.LENGTH_LONG).show()
        })


        (carousel.adapter as MyDataAdapter).notifyDataSetChanged()


    }
}