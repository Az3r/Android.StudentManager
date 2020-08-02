package tkpm.doan.student.data.components.retrofit;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import tkpm.doan.student.data.models.Student;

/**
 * manage all operations to RESTful server
 */
public class RetrofitService {
    private RestAPI api;

    public RetrofitService(String baseurl, Converter.Factory factory) {
        throwIfNull(baseurl, "baseurl must not be null");
        throwIfNull(factory, "factory must not be null");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(factory)
                .build();
        api = retrofit.create(RestAPI.class);
    }

    public void getStudent(String id, OnResult<Student> callback) {
        api.getStudent(id).enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if (response.isSuccessful()) callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                callback.onFailure(new Exception(t));
            }
        });
    }

    private static void throwIfNull(Object object, String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
    }

    private static void throwIfNull(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
    }
}
