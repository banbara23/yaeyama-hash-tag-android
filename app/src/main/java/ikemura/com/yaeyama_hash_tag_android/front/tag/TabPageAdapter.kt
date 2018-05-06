package ikemura.com.yaeyama_hash_tag_android.front.tag

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import ikemura.com.yaeyama_hash_tag_android.front.tag.child.BaseWebFragment

class TabPageAdapter(
        fm: FragmentManager?,
        private var tabCount: Int,
        var pageEntry: TabFragment.PageEntry
) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): BaseWebFragment {
        return pageEntry.create(position)
    }

    override fun getCount(): Int {
        return tabCount
    }

}