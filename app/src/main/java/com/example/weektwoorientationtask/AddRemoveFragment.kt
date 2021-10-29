package com.example.weektwoorientationtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AddRemoveFragment : AppCompatActivity() {
    private lateinit var addButton: Button
    private lateinit var removeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_remove_fragment)

        addButton = findViewById(R.id.add_btn)
        removeButton = findViewById(R.id.remove_btn)

        addButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, FragmentStack())
                .addToBackStack(null)
                .commit()
        }

        removeButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
//                .remove(R.id.container, FragmentStack())
        }
    }
}