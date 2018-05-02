package ikemura.com.yaeyama_hash_tag_android.front.top.tag

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TabPageAdapter(
        fm: FragmentManager?,
        private var tabCount: Int,
        var pageEntry: TabActivityFragment.PageEntry
) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return pageEntry.create(position)
    }

    override fun getCount(): Int {
        return tabCount
    }

}