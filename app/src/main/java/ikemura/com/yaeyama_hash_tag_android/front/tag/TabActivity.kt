package ikemura.com.yaeyama_hash_tag_android.front.tag

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import ikemura.com.yaeyama_hash_tag_android.R


class TabActivity : AppCompatActivity() {
    lateinit var fragment: TabFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Vector Drawable
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        setContentView(R.layout.tab_activity)
        supportActionBar?.apply { setDisplayHomeAsUpEnabled(true) }

        fragment = TabFragment.newInstance(intent.extras)

        //Fragment
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.tab_container, fragment)
                .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    override fun onBackPressed() {
//        fragment.onBackPressed()
        super.onBackPressed()
    }
}
