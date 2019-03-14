package com.example.tryviewpager2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tryviewpager2.databinding.PagerItemTextBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.databinding.BindableItem
import kotlinx.android.synthetic.main.activity_pager_horizontal.*

class GroupiePagerActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager_horizontal)

        viewPager.adapter = GroupAdapter<ViewHolder>().apply {
            add(Section().apply {
                setHeader(TextItem("header"))
                setFooter(TextItem("footer"))
                add(TextItem("page1"))
                add(TextItem("page2"))
                add(TextItem("page3"))
                add(TextItem("page4"))
                add(TextItem("page5"))
            })
        }
    }

    private class TextItem(
        private val text: String
    ) : BindableItem<PagerItemTextBinding>() {
        override fun getLayout() = R.layout.pager_item_text

        override fun bind(viewBinding: PagerItemTextBinding, position: Int) {
            viewBinding.text = text
        }
    }
}