package com.example.dummy

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        var params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        )
        var params_1 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        )
        var params_2 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        )
        var params_3 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        )
        var params_4 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        )
        var params_5 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        )
        var params_6 = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        )

        var baseLayout = LinearLayout(this)
        baseLayout.orientation = LinearLayout.VERTICAL
        setContentView(baseLayout,params)

        var layout_1 = LinearLayout(this)
        layout_1.orientation = LinearLayout.HORIZONTAL
        params_1.weight = 1f
        baseLayout.addView(layout_1,params_1)

        var layout_3 = LinearLayout(this)
        layout_3.setBackgroundColor(Color.RED)
        params_3.weight = 1f
        layout_1.addView(layout_3,params_3)

        var layout_4 = LinearLayout(this)
        params_4.weight = 1f
        layout_4.orientation = LinearLayout.VERTICAL
        layout_1.addView(layout_4,params_4)

        var layout_5 = LinearLayout(this)
        layout_5.setBackgroundColor(Color.YELLOW)
        params_5.weight = 1f
        layout_4.addView(layout_5,params_5)

        var layout_6 = LinearLayout(this)
        layout_6.setBackgroundColor(Color.BLACK)
        params_6.weight = 1f
        layout_4.addView(layout_6,params_6)

        var layout_2 = LinearLayout(this)
        layout_2.setBackgroundColor(Color.BLUE)
        params_2.weight = 1f
        baseLayout.addView(layout_2,params_2)
    }
}