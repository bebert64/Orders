package com.bydb.orders

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val placeOrderButton: Button = findViewById(R.id.place_order_button)
        placeOrderButton.setOnClickListener {
            val intent = Intent(this@MainActivity, PlaceOrder::class.java)
            startActivity(intent)
        }
    }
}