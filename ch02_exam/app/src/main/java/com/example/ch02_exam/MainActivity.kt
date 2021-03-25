package com.example.ch02_exam

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var Button1 : Button
    lateinit var Button2 : Button
    lateinit var Button3 : Button
    lateinit var Button4 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Button1.findViewById<Button>(R.id.btn1)
        Button1.setOnClickListener {
            var mIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))
            startActivity(mIntent)
        }
        Button2.findViewById<Button>(R.id.btn2)
        Button2.setOnClickListener {
            var mIntent = Intent(Intent.ACTION_VIEW,Uri.parse("tel:/911"))
            startActivity(mIntent)
        }
        Button3.findViewById<Button>(R.id.btn3)
        Button3.setOnClickListener {
            Toast.makeText(applicationContext,"버튼이 눌렸어요",Toast.LENGTH_SHORT).show()
        }
        Button4.findViewById<Button>(R.id.btn4)
        Button4.setOnClickListener {
            var mIntent = Intent(Intent.ACTION_VIEW,Uri.parse("content://media/internal/images/media"))
            startActivity(mIntent)
        }
    }
}
