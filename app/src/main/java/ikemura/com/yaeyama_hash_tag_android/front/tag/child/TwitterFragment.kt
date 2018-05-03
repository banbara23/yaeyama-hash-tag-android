package ikemura.com.yaeyama_hash_tag_android.front.top.tag


import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import ikemura.com.yaeyama_hash_tag_android.KEY_DATA
import ikemura.com.yaeyama_hash_tag_android.R
import ikemura.com.yaeyama_hash_tag_android.Tag
import ikemura.com.yaeyama_hash_tag_android.databinding.FragmentTwitterBinding


class TwitterFragment : Fragment() {
    var TAG = TwitterFragment::class.java.simpleName
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
        val code = tag.code
        Log.d(TAG,code)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_twitter, container, false)
        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl("file:///android_asset/index.html")

        binding.webView.settings.javaScriptEnabled = true
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(args: Bundle?) =
                TwitterFragment().apply {
                    args ?: run { Bundle() }
                    arguments = args
                }
    }
}
