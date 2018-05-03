package ikemura.com.yaeyama_hash_tag_android.front.top

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ikemura.com.yaeyama_hash_tag_android.R

/**
 * トップ画面のActivity
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, MainFragment())
                .commit()
    }
}
