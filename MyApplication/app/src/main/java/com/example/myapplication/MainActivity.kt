package com.example.myapplication


import android.app.Application
import android.media.Image
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var text1 : TextView
    lateinit var text2 : TextView
    lateinit var ChkAgree : Switch
    lateinit var rGroup1 : RadioGroup
    lateinit var rdoOreo : RadioButton
    lateinit var rdoPie : RadioButton
    lateinit var rdoQ : RadioButton
    lateinit var btnFinish : Button
    lateinit var btnFirst : Button
    lateinit var imgAndroid : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "좋아하는 안드로이드 버전"

        text1 = findViewById(R.id.Text1)
        ChkAgree = findViewById(R.id.ChkSwitch)

        text2 = findViewById(R.id.text2)
        rGroup1 = findViewById(R.id.Rgroup1)
        rdoOreo = findViewById(R.id.RdoOred)
        rdoPie = findViewById((R.id.RdoPie))
        rdoQ = findViewById(R.id.RdoQ)
        btnFinish = findViewById(R.id.BtnFinish)
        btnFirst = findViewById(R.id.BtnFirst)
        imgAndroid = findViewById(R.id.ImgAndroid)

        ChkAgree.setOnCheckedChangeListener { compoundButton, b ->
            if(ChkAgree.isChecked == true){
                text2.visibility = android.view.View.VISIBLE
                rGroup1.visibility = android.view.View.VISIBLE
                btnFinish.visibility = android.view.View.VISIBLE
                btnFirst.visibility = android.view.View.VISIBLE
                imgAndroid.visibility = android.view.View.VISIBLE
            }else{
                text2.visibility = android.view.View.INVISIBLE
                rGroup1.visibility = android.view.View.INVISIBLE
                btnFinish.visibility = android.view.View.INVISIBLE
                btnFirst.visibility = android.view.View.INVISIBLE
                imgAndroid.visibility = android.view.View.INVISIBLE
            }
        }
        rGroup1.setOnCheckedChangeListener { rGroup1, checkedId ->
            when (checkedId) {
                R.id.RdoPie -> imgAndroid.setImageResource(R.drawable.pie)
                R.id.RdoOred -> imgAndroid.setImageResource(R.drawable.oreo)
                R.id.RdoQ -> imgAndroid.setImageResource(R.drawable.q)
            }

        }
        btnFinish.setOnClickListener {
            finish()
        }
        btnFirst.setOnClickListener {
            ChkAgree.isChecked = false
        }
    }
}