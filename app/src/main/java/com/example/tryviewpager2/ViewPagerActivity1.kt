package com.example.tryviewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tryviewpager2.databinding.PagerItemTextBinding
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_pager_horizontal.*

class ViewPagerActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager_horizontal)

        viewPager.adapter = object : RecyclerView.Adapter<ViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                return ViewHolder(
                    LayoutInflater.from(this@ViewPagerActivity1).inflate(
                        R.layout.pager_item_text,
                        parent,
                        false
                    )
                )
            }

            override fun getItemCount() = 5

            override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                val binding = DataBindingUtil.bind<PagerItemTextBinding>(holder.root)?.apply {
                    text = "page$position"
                }
            }
        }
    }
}