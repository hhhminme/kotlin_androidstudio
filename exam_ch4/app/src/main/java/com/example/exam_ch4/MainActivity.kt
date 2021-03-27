package com.example.exam_ch4

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.core.graphics.rotationMatrix

class MainActivity : AppCompatActivity() {
    lateinit var btn1 : Button
    lateinit var btn2 : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1 = findViewById<Button>(R.id.Btn1)
        btn2 = findViewById<ImageButton>(R.id.Btn2)
        var rotate : Float = 0.0f
        btn1.setOnClickListener {
            rotate += 10.0f
            btn2.rotation = rotate
        }
        btn2.setOnClickListener {
            rotate -= 10.0f
            btn2.rotation = rotate
        }
    }
}


