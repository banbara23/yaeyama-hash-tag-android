package ikemura.com.yaeyama_hash_tag_android

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ikemura.com.yaeyama_hash_tag_android.databinding.FragmentTabBinding

/**
 * A placeholder fragment containing a simple view.
 */
class TabActivityFragment : Fragment() {

    lateinit var binding: FragmentTabBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab, container, false)
        val adapter = TabPageAdapter(fragmentManager, binding.tab.tabCount)
        binding.viewPager.adapter = adapter
        binding.tab.setupWithViewPager(binding.viewPager)
        //setupWithViewPagerでタイトルが上書きされるため、手動で書き換える
        binding.tab.getTabAt(0)!!.text = "Twitter"
        binding.tab.getTabAt(1)!!.text = "Instagram"
        return binding.root
    }
}
