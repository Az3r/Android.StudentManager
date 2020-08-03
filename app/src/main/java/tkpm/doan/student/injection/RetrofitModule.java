package tkpm.doan.student.injection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tkpm.doan.student.data.components.retrofit.RestAPI;

@Module
@InstallIn(ApplicationComponent.class)
public class RetrofitModule {
    public static final String BASE_URL = "http://10.0.2.2:3000/api/";

    @Provides
    Converter.Factory provideFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    Retrofit provideRetrofit(Converter.Factory factory) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(factory)
                .build();
    }
}
