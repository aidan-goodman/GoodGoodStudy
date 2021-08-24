package top.aidan.ioc;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Aidan on 2021/8/15 15:34
 *
 * @GitHub github.com/huaxin0304
 * @Blog aidanblog.top
 */
public class OkHttpTest {
    public static void main(String[] args) {

        // OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        OkHttpClient okHttpClient = ctx.getBean("okHttpClient", OkHttpClient.class);

        Request request = new Request.Builder()
                .get()
                .url("https://touduyu.com/")
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println(response.body().string());
            }
        });
    }
}
