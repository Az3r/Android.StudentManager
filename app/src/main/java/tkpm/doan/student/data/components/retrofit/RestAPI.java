package tkpm.doan.student.data.components.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
<<<<<<< HEAD
=======
import retrofit2.http.HEAD;
import retrofit2.http.Header;
>>>>>>> 5446796305a19ef18f1a44b9a300219ce52f80ab
import retrofit2.http.Path;
import retrofit2.http.Query;
import tkpm.doan.student.data.models.Notification;
import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.Score;
<<<<<<< HEAD
=======
import tkpm.doan.student.data.models.Session;
import tkpm.doan.student.data.models.Student;
>>>>>>> 5446796305a19ef18f1a44b9a300219ce52f80ab

public interface RestAPI {
    @GET("student/single/{id}")
    Call<PersonalInfo> getStudent(@Header("Authorization") String Authorization, @Path("id") String id);

    @GET("student/noti/{id}")
    Call<List<Notification>> getNotification(@Header("Authorization") String Authorization,@Path("id") String id);

    @GET("student/score/{id}")
    Call<List<Score>> getScore(@Header("Authorization") String Authorization,@Path("id") String id, @Query("sem") int semester, @Query("year") int year);
    @GET("student/schedule/{id}")
    Call<List<Session>> getSchedule(@Header("Authorization") String Authorization, @Path("id") String id, @Query("sem") int semester, @Query("year") int year);


}