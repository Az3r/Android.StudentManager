package tkpm.doan.student.data.components.retrofit;

import androidx.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
<<<<<<< HEAD
=======
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.internal.EverythingIsNonNull;
import tkpm.doan.student.data.models.Notification;
>>>>>>> a5462e4ec236d5f628249123e65042716df6bed7
import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.Score;

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

    public void getScores(String studentId, int semester, int year, @NonNull OnRetrofitResult<List<Score>> callback) {
        api.getScore(studentId, semester, year).enqueue(new RetrofitListener<>(callback));
    }
    public void getNotification(String studentId, @NonNull OnRetrofitResult<List<Notification>> callback) {
        api.getNotification(studentId).enqueue(new RetrofitListener<>(callback));
    }

    public void getStudentProfile(String studentId, @NonNull OnRetrofitResult<PersonalInfo> callback) {
        api.getStudent(studentId).enqueue(new RetrofitListener<>(callback));
    }

}
