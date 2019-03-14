package com.example.tryviewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tryviewpager2.databinding.PagerItemTextBinding
import kotlinx.android.synthetic.main.activity_pager_horizontal.*

class FragmentPagerActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager_horizontal)

        viewPager.adapter = object : FragmentStateAdapter(supportFragmentManager) {
            override fun getItem(position: Int) = PageFragment.newInstance("page$position")
            override fun getItemCount() = 5
        }
    }

    class PageFragment : Fragment() {
        companion object {
            private const val ARG_TEXT: String = "ARG_TEXT"

            fun newInstance(text: String) = PageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TEXT, text)
                }
            }
        }

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            DataBindingUtil.inflate<PagerItemTextBinding>(inflater, R.layout.pager_item_text, container, false)
                .apply {
                    text = arguments?.getString(ARG_TEXT)
                }.root
    }
}