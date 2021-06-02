package com.example.myapplication
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.media.AsyncPlayer
import android.media.Image
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Environment
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toast1.*
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.nio.charset.Charset
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var fileName : String
    val strSDpath = Environment.getExternalStorageDirectory().absolutePath
    val myDir = File("$strSDpath/myDiary")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
        Context.MODE_PRIVATE)
        title = "영화 선호도 투표"
        var cal = Calendar.getInstance()
        var cYear = cal.get(Calendar.YEAR)
        var cMonth = cal.get(Calendar.YEAR)
        var cDay = cal.get(Calendar.DAY_OF_MONTH)

        myDir.mkdir()

        fileName = (Integer.toString(cYear) + "-"
                +Integer.toString(cMonth + 1) + "-"
                +Integer.toString(cDay) + ".txt")
        var str = readDiary(fileName)
        edtDiary.setText(str)

        datePicker.init(cYear, cMonth, cDay) { view, year, monthOfYear, dayOfMonth ->
            fileName = (Integer.toString(year) + "-"
                    +Integer.toString(monthOfYear + 1) + "-"
                    +Integer.toString(dayOfMonth) + ".txt")
            var str = readDiary(fileName)
            edtDiary.setText(str)
            btnWrite.isEnabled = true
        }

        btnWrite.setOnClickListener {
            var outFs = FileOutputStream("$strSDpath/myDiary/$fileName")
            var str = edtDiary.text.toString()
            outFs.write(str.toByteArray())
            outFs.close()
            Toast.makeText(this, "$fileName 이 저장됨", Toast.LENGTH_SHORT).show()
        }


    }
    fun readDiary(fName : String) : String? {
        var diaryStr : String? = null
        try {
            var inFs = FileInputStream("$strSDpath/myDiary/$fName")
            var text = ByteArray(inFs.available())
            inFs.read(text)
            diaryStr = text.toString(Charsets.UTF_8).trim()
            btnWrite.text = "수정하기"
            inFs.close()
        }catch (e : IOException){
            edtDiary.hint = "일기 없음"
            btnWrite.text = "새로 저장"
        }
        return diaryStr
    }
}




