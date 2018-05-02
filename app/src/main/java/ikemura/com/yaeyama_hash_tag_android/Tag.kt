package ikemura.com.yaeyama_hash_tag_android

enum class Tag(val code:String, val title:String,val instaUrl:String) {
    Yaeyama(
            "yaeyama",
            "#八重山",
            "https://www.instagram.com/explore/tags/%E5%85%AB%E9%87%8D%E5%B1%B1/?hl=ja"
            ),
    Taketomi(
            "taketomi",
            "#竹富島",
            "https://www.instagram.com/explore/tags/%E7%AB%B9%E5%AF%8C%E5%B3%B6/?hl=ja"
    ),
    Kohama("kohama",
            "#小浜島",
            "https://www.instagram.com/explore/tags/%E5%B0%8F%E6%B5%9C%E5%B3%B6/?hl=ja"
    ),
}