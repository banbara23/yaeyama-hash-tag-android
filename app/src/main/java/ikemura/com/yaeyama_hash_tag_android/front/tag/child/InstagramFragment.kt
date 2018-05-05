package ikemura.com.yaeyama_hash_tag_android.front.tag.child


import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.databinding.ObservableBoolean
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import ikemura.com.yaeyama_hash_tag_android.KEY_DATA
import ikemura.com.yaeyama_hash_tag_android.R
import ikemura.com.yaeyama_hash_tag_android.Tag
import ikemura.com.yaeyama_hash_tag_android.databinding.FragmentInstagramBinding


class InstagramFragment : Fragment() {
    var TAG = InstagramFragment::class.java.simpleName
    private lateinit var tag: Tag
    private lateinit var binding: FragmentInstagramBinding
    val canGoBack: ObservableBoolean = ObservableBoolean()
    val canGoForward: ObservableBoolean = ObservableBoolean()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tag = it.get(KEY_DATA) as Tag
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instagram, container, false)
        binding.webView.settings.loadWithOverviewMode = true
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl(tag.instaUrl)
        binding.webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                canGoBack.set(view.canGoBack())
                canGoForward.set(view.canGoForward())
            }
        }
        binding.fragment = this

        binding.canBack = canGoBack
        binding.canForward = canGoForward

        return binding.root
    }

    fun onClickLeft() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
            Log.d(TAG, "back")
        }
    }

    fun onClickRight() {
        if (binding.webView.canGoForward()) {
            binding.webView.goForward()
            Log.d(TAG, "forward")
        }
    }

    fun onClickUpdate() {
        binding.webView.reload()
    }

    companion object {

        @JvmStatic
        fun newInstance(args: Bundle?) =
                InstagramFragment().apply {
                    args ?: run { Bundle() }
                    arguments = args
                }
    }
}
