package ikemura.com.yaeyama_hash_tag_android

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ikemura.com.yaeyama_hash_tag_android.databinding.FragmentTabBinding

class TabActivityFragment : Fragment() {

    lateinit var binding: FragmentTabBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab, container, false)

        val adapter = TabPageAdapter(fragmentManager, binding.tab.tabCount, PageEntry(Tag.Yaeyama))
        binding.viewPager.adapter = adapter
        binding.tab.setupWithViewPager(binding.viewPager)
        //setupWithViewPagerでタイトルが上書きされるため、手動で書き換える
        binding.tab.getTabAt(0)!!.text = "Twitter"
        binding.tab.getTabAt(1)!!.text = "Instagram"
        return binding.root
    }

    class PageEntry(val tag: Tag) {

        var fragment: TwitterFragment? = null

        fun create(position: Int): Fragment {
            return fragment.let {
                val bundle = Bundle()
                bundle.putSerializable(KEY_DATA, tag)
                when (position) {
                    0 -> TwitterFragment.newInstance(bundle)
                    else -> InstagramFragment.newInstance(bundle)
                }
            }
        }
    }
}
