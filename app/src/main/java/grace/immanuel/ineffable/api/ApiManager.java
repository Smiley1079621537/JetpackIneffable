package grace.immanuel.ineffable.api;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import grace.immanuel.ineffable.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    public static final String BASE_URL = "https://gank.io/api/v2/data/";
    private static Retrofit retrofit;
    private static BeautyService beautyService;

    private static synchronized Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(getClient())
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient getClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NotNull String message) {
                if (BuildConfig.DEBUG)
                    Log.e("liming", message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY));
        return builder.build();
    }

    public static BeautyService getBeautyService() {
        if (beautyService == null) {
            beautyService = getInstance().create(BeautyService.class);
        }
        return beautyService;
    }
}