package tkpm.doan.student.data.components.retrofit;

import android.util.Log;

import androidx.annotation.Nullable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tkpm.doan.student.injection.RetrofitModule;

import static org.junit.Assert.*;

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