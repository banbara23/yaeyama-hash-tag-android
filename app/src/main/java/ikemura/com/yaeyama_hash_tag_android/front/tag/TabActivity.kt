package ikemura.com.yaeyama_hash_tag_android.front.tag

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ikemura.com.yaeyama_hash_tag_android.R
import kotlinx.android.synthetic.main.tab_activity.*

class TabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tab_activity)
        setSupportActionBar(toolbar)
    }
}
