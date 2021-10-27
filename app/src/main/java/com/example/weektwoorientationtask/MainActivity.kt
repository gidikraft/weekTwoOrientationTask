package com.example.weektwoorientationtask

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var screen: TextView
    private lateinit var pager: TextView
    private lateinit var btn: Button
    private var landCount: Int = 0
    private var portraitCount:Int = 1
    val handleDelay = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        screen = findViewById(R.id.orientation_count)
        pager = findViewById(R.id.lifecycle_viewer)
        btn = findViewById(R.id.SwitchBtn)

        screen.text = "Portrait is $portraitCount"

        btn.setOnClickListener {
            startActivity(Intent(this, addRemoveFragment::class.java))
        }

        handleDelay.postDelayed({
            pager.text = "onCreate"
        }, 1000)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            landCount++
            screen.text = "Landscape is $landCount"
        } else if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            portraitCount++
            screen.text = "Portrait is $portraitCount"
        }
    }

    override fun onStart() {
        super.onStart()
        handleDelay.postDelayed({
            pager.text = "onStart"
        }, 1500)
    }

    override fun onResume() {
        super.onResume()
        handleDelay.postDelayed({
            pager.text = "onResume"
        }, 1700)
    }

    override fun onPause() {
        super.onPause()
        pager.text = "onPause"
    }

    override fun onRestart() {
        super.onRestart()
        pager.text = "onRestart"
    }

    override fun onStop() {
        super.onStop()
        pager.text = "onStop"
    }

    override fun onDestroy() {
        super.onDestroy()
        pager.text = "onDestroy"
    }
}