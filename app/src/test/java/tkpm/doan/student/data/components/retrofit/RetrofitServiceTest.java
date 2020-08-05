package tkpm.doan.student.data.components.retrofit;

import org.junit.Before;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tkpm.doan.student.injection.RetrofitModule;

public class RetrofitServiceTest {

    private RetrofitService service;

    @Before
    public void setup() {
        service = new RetrofitService(new Retrofit.Builder()
                .baseUrl(RetrofitModule.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build());
    }
}