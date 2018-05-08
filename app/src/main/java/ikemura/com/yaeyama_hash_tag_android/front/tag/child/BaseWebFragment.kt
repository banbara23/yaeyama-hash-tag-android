package ikemura.com.yaeyama_hash_tag_android.front.tag.child

import android.support.v4.app.Fragment

abstract class BaseWebFragment : Fragment() {
    open fun onBackPressed(): Boolean {
        return true
    }
}