package ikemura.com.yaeyama_hash_tag_android


import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import ikemura.com.yaeyama_hash_tag_android.databinding.FragmentTwitterBinding


class InstagramFragment : Fragment() {
    var TAG = InstagramFragment::class.java.simpleName
    private lateinit var tag: Tag
    private lateinit var binding: FragmentTwitterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tag = it.get(KEY_DATA) as Tag
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_twitter, container, false)
        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://www.instagram.com/explore/tags/%E5%85%AB%E9%87%8D%E5%B1%B1/?hl=ja")

        return binding.root
    }


    companion object {

        @JvmStatic
        fun newInstance(args: Bundle?) =
                InstagramFragment().apply {
                    args ?:run { Bundle() }
                    arguments = args
                }
    }
}
