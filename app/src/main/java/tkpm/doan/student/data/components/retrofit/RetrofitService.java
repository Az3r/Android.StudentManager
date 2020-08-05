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
import tkpm.doan.student.data.models.Notification;
import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.Score;
import tkpm.doan.student.data.models.Session;
import tkpm.doan.student.data.models.Student;

/**
 * manage all operations to RESTful server
 */
public class RetrofitService {
    @NonNull
    private RestAPI api;

    @Inject
    public RetrofitService(@NonNull Retrofit retrofit) {
        api = retrofit.create(RestAPI.class);
    }

    public void getScores(String author,String studentId, int semester, int year, @NonNull OnRetrofitResult<List<Score>> callback) {
        api.getScore(author,studentId, semester, year).enqueue(new RetrofitListener<>(callback));
    }
    public void getSchedule(String author,String studentId, int semester, int year, @NonNull OnRetrofitResult<List<Session>> callback) {
        api.getSchedule(author,studentId, semester, year).enqueue(new RetrofitListener<>(callback));
    }
    public void getNotification(String author,String studentId, @NonNull OnRetrofitResult<List<Notification>> callback) {
        api.getNotification(author,studentId).enqueue(new RetrofitListener<>(callback));
    }

    public void getStudentProfile(String author,String studentId, @NonNull OnRetrofitResult<PersonalInfo> callback) {
        api.getStudent(author,studentId).enqueue(new RetrofitListener<>(callback));
    }

}
