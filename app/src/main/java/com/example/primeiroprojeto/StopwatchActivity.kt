package com.example.primeiroprojeto

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StopwatchActivity : AppCompatActivity() {

    private var segundos : Int = 0
    private var running : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch)
        Log.i(TAG,"$CHAMADA onCreate")
        runTimer()
    }

    fun onClickStart(view : View){
        running = true
    }

    fun onClickStop(view : View){
        running = false
    }

    fun onClickReset(view : View){
        running = false
        segundos = 0
    }


    fun runTimer(){
        val tvTimer : TextView = findViewById(R.id.tvStopwatch)

        Handler(Looper.getMainLooper()).postDelayed(object : Runnable {
            override fun run() {
                var horas: Int = segundos / 3600
                var minutos: Int = (segundos % 3600) / 60
                var secs: Int = segundos % 60
                var timer: String = String.format("%d:%02d:%02d", horas, minutos, secs)
                tvTimer.text = timer
                if (running) {
                    segundos++
                }
                Handler(Looper.getMainLooper()).postDelayed(this, 1000)
                return
            }
        }, 500)


            }

    companion object {
        private const val TAG = "tagInfo"
        private const val CHAMADA = "StopwatchActivity ::"
    }
}