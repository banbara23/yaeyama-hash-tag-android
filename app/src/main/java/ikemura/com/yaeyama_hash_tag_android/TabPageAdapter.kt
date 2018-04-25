package ikemura.com.yaeyama_hash_tag_android

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TabPageAdapter(fm: FragmentManager?, private var tabCount: Int) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> TwitterFragment.newInstance("", "")
            1 -> InstagramFragment.newInstance("", "")
            else -> TwitterFragment.newInstance("", "")
        }
    }

    override fun getCount(): Int {
        return tabCount
    }

}