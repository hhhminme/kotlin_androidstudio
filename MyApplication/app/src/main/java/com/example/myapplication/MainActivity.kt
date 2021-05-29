package com.example.myapplication
import android.app.Activity
import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.os.SystemClock
import android.widget.SeekBar
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "간단 MP3 플레이어"
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),Context.MODE_PRIVATE)

        var mPlayer = MediaPlayer.create(this, R.raw.song1)

        switch1.setOnClickListener {
            if(switch1.isChecked == true){
                mPlayer.start()
                object : Thread(){
                    var timeFormat = SimpleDateFormat("mm:ss")
                    override fun run(){
                        if(mPlayer == null){
                            return
                        }
                        seek1.max = mPlayer.duration
                        while(mPlayer.isPlaying){
                            runOnUiThread {
                                seek1.progress = mPlayer.currentPosition
                                tvTime.text = "진행시간 : ${timeFormat.format(mPlayer.currentPosition)}"
                            }
                            SystemClock.sleep(200)
                        }
                    }
                }.start()
            }
            else{
                mPlayer.pause()
            }
        }
        seek1.setOnSeekBarChangeListener(
                object : SeekBar.OnSeekBarChangeListener{
                    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                        if(p2){
                            seek1.max = mPlayer.duration
                            mPlayer.seekTo(p1)
                        }
                    }

                    override fun onStartTrackingTouch(p0: SeekBar?) {
                    }

                    override fun onStopTrackingTouch(p0: SeekBar?) {

                    }
                }
        )
    }
}




