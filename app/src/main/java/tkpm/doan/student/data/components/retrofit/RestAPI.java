package tkpm.doan.student.data.components.retrofit;

import android.app.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.Score;
import tkpm.doan.student.data.models.Student;

public interface RestAPI {

    @GET("/api/student/single/{id}")
    Call<PersonalInfo> getStudent(@Path("id") String id);

    @GET("student/score/{id}")
    Call<List<Score>> getScore(@Path("id") String id, @Query("sem") int semester, @Query("year") int year);
}
