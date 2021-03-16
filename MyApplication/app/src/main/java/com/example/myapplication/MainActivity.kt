package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //버튼 변수 선언
    lateinit var button1 : Button
    lateinit var button2 : Button
    lateinit var button3 : Button
    lateinit var button4 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //변수에 activity_main.xml파일에 버튼을 대입
        button1 = findViewById<Button>(R.id.button1)
        button2 = findViewById<Button>(R.id.button2)
        button3 = findViewById<Button>(R.id.button3)
        button4 = findViewById<Button>(R.id.button4)

        //클릭했을 때 작동하는 람다식 정의
        button1.setOnClickListener {
            var mIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.nate.com"))
            startActivity(mIntent)
        }
        button2.setOnClickListener {
            var mIntent = Intent(Intent.ACTION_VIEW,Uri.parse("tel:/911"))
            startActivity(mIntent)
        }
        button3.setOnClickListener {
            var mIntent = Intent(Intent.ACTION_VIEW,Uri.parse("conent://media/internal/images/media"))
            startActivity(mIntent)
        }
        button4.setOnClickListener {
            finish()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_launcher)
    }
}