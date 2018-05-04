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
import ikemura.com.yaeyama_hash_tag_android.databinding.FragmentTwitterBinding


class TwitterFragment : Fragment() {
    private var TAG = TwitterFragment::class.java.simpleName
    private lateinit var tag: Tag

    private lateinit var binding: FragmentTwitterBinding

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_twitter, container, false)
        binding.fragment = this

        binding.canBack = canGoBack
        binding.canForward = canGoForward

        val code = tag.code
        Log.d(TAG, code)

        // WebView設定
        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl("file:///android_asset/$code.html")
            settings.loadWithOverviewMode = true
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView, url: String) {
                    super.onPageFinished(view, url)
                    canGoBack.set(view.canGoBack())
                    canGoForward.set(view.canGoForward())
                }
            }
        }

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
                TwitterFragment().apply {
                    args ?: run { Bundle() }
                    arguments = args
                }
    }
}
