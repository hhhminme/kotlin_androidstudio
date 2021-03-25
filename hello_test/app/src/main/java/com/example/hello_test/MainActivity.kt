package com.example.hello_test

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var EditText : EditText //입력창
    lateinit var Button1 : Button //글자 나타내기
    lateinit var Button2 : Button //홈페이지 열기
    lateinit var RadioGroup : RadioGroup //라디오 그룹
    lateinit var ImageView : ImageView //이미지
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //글자 나타내기
        EditText.findViewById<EditText>(R.id.editTxt1)
        Button1.findViewById<Button>(R.id.strBtn1)
        Button1.setOnClickListener {
            var Text = EditText.text
            Toast.makeText(applicationContext,Text,Toast.LENGTH_SHORT).show()
        }
        //홈페이지 열기
        Button2.findViewById<Button>(R.id.strBtn2)
        Button2.setOnClickListener {
            var tempTxt = EditText.text.toString()
            if(!tempTxt.startsWith("http://")){
                tempTxt = "http://" + tempTxt
            }
            var mIntent = Intent(Intent.ACTION_VIEW,Uri.parse(tempTxt))
            startActivity(mIntent)
        }
        //라디오 버튼
        RadioGroup.findViewById<RadioGroup>(R.id.rg)
        ImageView.findViewById<ImageView>(R.id.image)
        RadioGroup.setOnCheckedChangeListener{ RadioGroup, checkedId -> when(checkedId){
            R.id.rg_btn1 -> ImageView.setImageResource(R.drawable.pie)
            R.id.rg_btn2 -> ImageView.setImageResource(R.drawable.oreo)
            }
        }
    }
}