package ikemura.com.yaeyama_hash_tag_android.front.top

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.newrelic.agent.android.NewRelic
import ikemura.com.yaeyama_hash_tag_android.BuildConfig
import ikemura.com.yaeyama_hash_tag_android.R

/**
 * トップ画面のActivity
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // デバッグ中はNew Relicを無効にする
        if (BuildConfig.DEBUG) {
            // initialize New Relic
            NewRelic.withApplicationToken(
                    "AA9ef2258058501fe6deb0ce5a36b392c63b6e09ab"
            ).start(this.getApplication())
        }

        supportActionBar?.apply {
            hide()
        }
        // initialize Fragment
        setContentView(R.layout.main_activity)
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, MainFragment())
                .commit()
    }
}
