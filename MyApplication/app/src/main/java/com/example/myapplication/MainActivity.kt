package com.example.myapplication
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var soundIntent: Intent
    //mp3 파일을 저장할
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_CALL_LOG), Context.MODE_PRIVATE)
        title = "연습문제11-6"
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setIcon(R.drawable.battery_icon)

        soundIntent = Intent(this, MusicService::class.java)

        btnStart.setOnClickListener {
            startService(soundIntent)
            android.util.Log.i("서비스 테스트 ","startService()")
            Toast.makeText(this, "startService()", Toast.LENGTH_SHORT).show()
        }
        btnStop.setOnClickListener {
            stopService(soundIntent)
            android.util.Log.i("서비스 테스트","stopService()")
            Toast.makeText(this, "stopService()", Toast.LENGTH_SHORT).show()
        }
    }
}


