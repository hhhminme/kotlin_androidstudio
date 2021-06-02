package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        title = "학번 이름 입력"

        btnResult.setOnClickListener {
            var intent = Intent(applicationContext,MainActivity::class.java)
            intent.putExtra("studentId",studentId.text.toString())
            intent.putExtra("studentNumber",studentNumber.text.toString())
            startActivity(intent)
        }

    }
}
