package top.aidan.ioc;

import okhttp3.OkHttpClient;

/**
 * Created by Aidan on 2021/8/15 15:41
 *
 * @GitHub github.com/huaxin0304
 * @Blog aidanblog.top
 */
public class OkHttpStaticFactory {
    private static OkHttpClient okHttpClient;
    public static OkHttpClient getInstance() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder().build();
        }
        return okHttpClient;
    }
}
