package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        title = "결과창"

        var intent = intent
        var voteResult = intent.getIntArrayExtra("VoteCount")
        var imageName = intent.getStringArrayExtra("PosterName")

        var tvId = arrayOf(tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9)
        var ratingId = arrayOf(rbar1,rbar2,rbar3,rbar4,rbar5,rbar6,rbar7,rbar8,rbar9)

        for(i in voteResult!!.indices){
            tvId[i]!!.setText(imageName!![i])
            ratingId[i]!!.rating = voteResult!![i].toFloat()
        }

        btnReturn.setOnClickListener {
            finish()
        }
    }
}
