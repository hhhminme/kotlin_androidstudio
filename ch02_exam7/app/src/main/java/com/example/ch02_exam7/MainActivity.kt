package com.example.ch02_exam7

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var Button1 : Button //글자 나타내기
    lateinit var Button2 : Button //홈페이지 열기
    lateinit var EditText1 : EditText
    lateinit var RG : RadioGroup
    lateinit var Img : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EditText1 = findViewById<EditText>(R.id.editTxt1)
        Button1 = findViewById(R.id.strbtn1)
        Button1.setOnClickListener {
            Toast.makeText(applicationContext,EditText1.text,Toast.LENGTH_SHORT).show()
        }
        //홈페이지 열기
        Button2.findViewById<Button>(R.id.strBtn2)
        Button2.setOnClickListener {
            var tempTxt = EditText1.text.toString()
            if(!tempTxt.startsWith("http://")){
                tempTxt = "http://" + tempTxt
            }
            var mIntent = Intent(Intent.ACTION_VIEW,Uri.parse(tempTxt))
            startActivity(mIntent)
        }
        //라디오 버튼
        Img = findViewById(R.id.image)
        RG = findViewById(R.id.rg)
        RG.setOnCheckedChangeListener{
            RG, checkedId -> when(checkedId){
            R.id.rg_btn1 -> Img.setImageResource(R.drawable.oreo)
            R.id.rg_btn2 -> Img.setImageResource(R.drawable.pie)
            }
        }
    }
}