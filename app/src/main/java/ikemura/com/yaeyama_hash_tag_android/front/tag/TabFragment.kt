package ikemura.com.yaeyama_hash_tag_android.front.tag

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ikemura.com.yaeyama_hash_tag_android.KEY_DATA
import ikemura.com.yaeyama_hash_tag_android.R
import ikemura.com.yaeyama_hash_tag_android.Tag
import ikemura.com.yaeyama_hash_tag_android.databinding.FragmentTabBinding
import ikemura.com.yaeyama_hash_tag_android.front.tag.child.InstagramFragment
import ikemura.com.yaeyama_hash_tag_android.front.tag.child.TwitterFragment

class TabFragment : Fragment() {
    private var TAG = TabFragment::class.java.simpleName
    private lateinit var tag: Tag
    private lateinit var binding: FragmentTabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tag = it.get(KEY_DATA) as Tag
            Log.d(TAG, tag.toString())
            activity!!.title = tag.title
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tab, container, false)

        val adapter = TabPageAdapter(fragmentManager, binding.tab.tabCount, PageEntry(tag))
        binding.viewPager.adapter = adapter
        binding.tab.setupWithViewPager(binding.viewPager)
        //setupWithViewPagerでタイトルが上書きされるため、手動で書き換える
        binding.tab.getTabAt(0)!!.text = "Twitter"
        binding.tab.getTabAt(1)!!.text = "Instagram"
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(args: Bundle?) =
                TabFragment().apply {
                    args ?: run { Bundle() }
                    arguments = args
                }
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
