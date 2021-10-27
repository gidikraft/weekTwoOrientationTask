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
        Toast.makeText(applicationContext, "onCreate", Toast.LENGTH_SHORT).show()
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
        Toast.makeText(applicationContext, "onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        handleDelay.postDelayed({
            pager.text = "onResume"
        }, 1700)
        Toast.makeText(baseContext, "onResume", Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        pager.text = "onPause"
        Toast.makeText(baseContext, "onPause", Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()
        pager.text = "onRestart"
        Toast.makeText(baseContext, "onRestart", Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        pager.text = "onStop"
        Toast.makeText(baseContext, "onStop", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        pager.text = "onDestroy"
        Toast.makeText(baseContext, "onDestroy", Toast.LENGTH_LONG).show()
    }
}