package tkpm.doan.student.data.components.retrofit;

import android.app.Person;
import android.net.sip.SipSession;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.internal.EverythingIsNonNull;
import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.Score;
import tkpm.doan.student.data.models.Student;

/**
 * manage all operations to RESTful server
 */
public class RetrofitService {
    private RestAPI api;

    @Inject
    public RetrofitService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(RestAPI.class);
    }

    public RetrofitService(String baseUrl, Converter.Factory factory) {
        throwIfNull(baseUrl, "baseUrl must not be null");
        throwIfNull(factory, "factory must not be null");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(factory)
                .build();
        api = retrofit.create(RestAPI.class);
    }

    public void getScores(String studentId, int semester, int year, @NonNull OnRetrofitResult<List<Score>> callback) {
        api.getScore(studentId, semester, year).enqueue(new RetrofitListener<>(callback));
    }

    public void getStudentProfile(String studentId, @NonNull OnRetrofitResult<PersonalInfo> callback) {
        api.getStudent(studentId).enqueue(new RetrofitListener<>(callback));
    }

    private static void throwIfNull(Object object, String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
    }
}
