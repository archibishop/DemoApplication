package com.example.demo.a3demo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class BookDetailActivity : AppCompatActivity() {
    private  lateinit var destination: TextView
    private  lateinit var pickUpText: TextView
    private  lateinit var NOOfPeople: TextView
    private  lateinit var dateText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        destination = findViewById(R.id.value1)
        pickUpText = findViewById(R.id.value2)
        NOOfPeople = findViewById(R.id.value3)
        dateText = findViewById(R.id.date)

        var intent = intent
        var des = intent.getStringExtra("destination")
        var pickUp= intent.getStringExtra("pickUpPoint")
        var noPeople = intent.getStringExtra("noOfPeople")
        var date = intent.getStringExtra("date")

//        Toast.makeText(this, "$des :: $pickUp :: $noPeople", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "You have successfuly booked a trip", Toast.LENGTH_LONG).show()

        destination.text = des
        pickUpText.text = pickUp
        NOOfPeople.text = noPeople
        dateText.text = date
    }

    override fun onBackPressed() {
        super.onBackPressed()
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
