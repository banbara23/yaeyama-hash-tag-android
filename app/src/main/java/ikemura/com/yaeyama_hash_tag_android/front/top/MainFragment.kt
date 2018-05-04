package ikemura.com.yaeyama_hash_tag_android.front.top

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ikemura.com.yaeyama_hash_tag_android.KEY_DATA
import ikemura.com.yaeyama_hash_tag_android.R
import ikemura.com.yaeyama_hash_tag_android.Tag
import ikemura.com.yaeyama_hash_tag_android.databinding.MainFragmentBinding
import ikemura.com.yaeyama_hash_tag_android.front.tag.TabActivity

/**
 * トップメニュー画面のFragment
 */
class MainFragment : Fragment() {
    lateinit var binding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.fragment = this
        return binding.root
    }

    fun navigateToTabActivity(tag: Tag) {
        println(tag.code)
        val bundle = Bundle()
        bundle.putSerializable(KEY_DATA, tag)
        startActivity(Intent(activity, TabActivity::class.java).putExtras(bundle))
    }

}
