package com.example.tryviewpager2

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.tryviewpager2.databinding.PagerItemImageBinding
import com.example.tryviewpager2.databinding.PagerItemTextBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.databinding.BindableItem
import kotlinx.android.synthetic.main.activity_pager_horizontal.*

class GroupiePagerActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager_horizontal)

        viewPager.adapter = GroupAdapter<ViewHolder>().apply {
            spanCount = 3

            add(TextItem("page1"))
            add(ImageItem("https://topmuseum.jp/contents/details/2017/world_press/world_press17.jpg"))
            add(TextItem("page3"))
            add(ImageItem("https://capa.getnavi.jp/wps/wp-content/uploads/2018/11/181126jpower.jpg"))
            add(TextItem("page5"))
            add(ImageItem("https://fotopus.com/pict/event_campiagn/item13/2017/img_473_1488875864.jpg"))
        }

        // ViewPager2はLinearLayoutManager固定なのでspanCount系は使えない
        // よってこの試みは意味なし！
    }

    private class TextItem(
        private val text: String
    ) : BindableItem<PagerItemTextBinding>() {
        override fun getLayout() = R.layout.pager_item_text

        override fun bind(viewBinding: PagerItemTextBinding, position: Int) {
            viewBinding.text = text
        }

        override fun getSpanSize(spanCount: Int, position: Int) = 1
    }

    private inner class ImageItem(
        private val url: String
    ) : BindableItem<PagerItemImageBinding>() {
        override fun getLayout() = R.layout.pager_item_image

        override fun bind(viewBinding: PagerItemImageBinding, position: Int) {
            Glide.with(this@GroupiePagerActivity3)
                .load(Uri.parse(url))
                .into(viewBinding.imageView)
        }

        override fun getSpanSize(spanCount: Int, position: Int) = 2
    }
}