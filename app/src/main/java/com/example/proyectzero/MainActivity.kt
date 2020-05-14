package com.example.proyectzero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var start = findViewById<Button>(R.id.startButton)
        start.isEnabled = false

        startButton.setOnClickListener()
        {
            var intent:Intent = Intent(this,GameActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun savePressed(view: View) {
        var start = findViewById<Button>(R.id.startButton)
        nameUser.text = editName.text
        start.isEnabled = true

    }

}
