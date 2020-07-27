package tkpm.doan.student.components.retrofit;

import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tkpm.doan.student.data.models.Student;

/** manage all operations to RESTful server */
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

    public void getCurrentScheduleOf(Student student, OnResult callback) {

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
