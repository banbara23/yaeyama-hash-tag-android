package ikemura.com.yaeyama_hash_tag_android.front.tag.child


import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.databinding.ObservableBoolean
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import ikemura.com.yaeyama_hash_tag_android.KEY_DATA
import ikemura.com.yaeyama_hash_tag_android.R
import ikemura.com.yaeyama_hash_tag_android.Tag
import ikemura.com.yaeyama_hash_tag_android.databinding.FragmentTwitterBinding


class TwitterFragment : BaseWebFragment() {
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
        binding.root.setOnKeyListener { view, keyCode, keyEvent ->
            (keyCode == KeyEvent.KEYCODE_BACK && keyEvent.action == KeyEvent.ACTION_UP).apply {
                if (binding.webView.canGoBack()) {
                    binding.webView.goBack()
                }
            }

            view.isFocusableInTouchMode = true
            view.requestFocus()
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
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

    override fun onBackPressed():Boolean {
        //UninitializedPropertyAccessExceptionで落ちる対応
//        if (!::binding.isInitialized) return false

//        val action = binding.webView.canGoBack()
//
//        if (binding.webView.canGoBack()) {
//            binding.webView.goBack()
//            Log.d(TAG, "back")
//        }

//        if (binding.webView.canGoBack())

        Log.d(TAG,"Twitter onBackPressed")
        return true
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
