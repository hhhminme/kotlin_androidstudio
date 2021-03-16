package com.example.ch02_exam

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var button1 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById<Button>(R.id.btn1)

        button1.setOnClickListener {
            Toast.makeText(applicationContext, "버튼을 눌렀어요",Toast.LENGTH_SHORT).show()
//            파라메터는 메세지가 출력될 컨텍스트, 메세지 내용, 출력할 시간이다.
        }
    }
}