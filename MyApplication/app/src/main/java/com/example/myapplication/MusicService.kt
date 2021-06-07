package com.example.myapplication

import android.content.Intent
import android.media.MediaPlayer
import android.os.Environment
import android.os.IBinder
import android.widget.Toast
import java.io.File

class MusicService : android.app.Service(){
    lateinit var mp: MediaPlayer
    // mp3 파일을 저장할 어레이리스트, 현재 재생 변수, 플레이 넘버 변수
    lateinit var mp3List : ArrayList<String>
    lateinit var currentMP3 : String
    var playNum = 0
    // sdcard 경로 저장 변수
    var mp3Path = Environment.getExternalStorageDirectory().path + "/"

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "onStartCommand", Toast.LENGTH_SHORT).show()
        android.util.Log.i("서비스 테스트","onStartCommand()")

        mp = MediaPlayer()

        //첫번째 음악 재생 및 시작버튼 비활성화
        currentMP3 = mp3List[playNum++]
        mp.setDataSource(mp3Path + currentMP3)
        mp.prepare()
        mp.start()

        mp.setOnCompletionListener( object  : MediaPlayer.OnCompletionListener{
            override fun onCompletion(p0: MediaPlayer?) {
                mp.stop()
                mp.reset()

                if (playNum < mp3List.size){
                    currentMP3 = mp3List[playNum++]
                    mp.setDataSource(mp3Path + currentMP3)
                    mp.prepare()
                    mp.start()
                }
            }
        })


        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        //mp3 파일 목록 생성
        mp3List = ArrayList()

        var listFiles = File(mp3Path).listFiles()
        var fileName : String
        var extName : String

        for(file in listFiles!!){
            fileName = file.name
            extName = fileName.substring(fileName.length - 3)
            if (extName == "mp3")
                mp3List.add(fileName)
        }
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()
        android.util.Log.i("서비스 테스트","onCreate()")
        super.onCreate()
    }

    override fun onDestroy() {
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show()
        android.util.Log.i("서비스 테스트","onDestroy()")
        mp.stop()
        super.onDestroy()
    }
}