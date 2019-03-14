package com.example.tryviewpager2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // view
        buttonView1.setOnClickListener {
            startActivity(Intent(this, ViewPagerActivity1::class.java))
        }


        // fragment
        buttonFragment1.setOnClickListener {
            startActivity(Intent(this, FragmentPagerActivity1::class.java))
        }


        // groupie
        buttonGroupie1.setOnClickListener {
            startActivity(Intent(this, GroupiePagerActivity1::class.java))
        }

        buttonGroupie2.setOnClickListener {
            startActivity(Intent(this, GroupiePagerActivity2::class.java))
        }

        buttonGroupie3.setOnClickListener {
            startActivity(Intent(this, GroupiePagerActivity3::class.java))
        }

        buttonGroupie4.setOnClickListener {
            startActivity(Intent(this, GroupiePagerActivity4::class.java))
        }
    }
}
