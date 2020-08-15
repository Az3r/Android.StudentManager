package tkpm.doan.student.data.components.retrofit;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import tkpm.doan.student.data.models.Grade;
import tkpm.doan.student.data.models.Notification;
import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.Score;
import tkpm.doan.student.data.models.ScoreRequest;
import tkpm.doan.student.data.models.Session;
import tkpm.doan.student.data.models.Student;

public interface RestAPI {
    @GET("student/single/{id}")
    Call<PersonalInfo> getStudent(@Header("Authorization") String Authorization, @Path("id") String id);
    @GET("teacher/single/{id}")
    Call<PersonalInfo> getTeacher(@Header("Authorization") String Authorization, @Path("id") String id);
    @GET("student/noti/{id}")
    Call<List<Notification>> getNotification(@Header("Authorization") String Authorization,@Path("id") String id);
    @GET("student/score/{id}")
    Call<List<Score>> getScore(@Header("Authorization") String Authorization,@Path("id") String id, @Query("sem") int semester, @Query("year") int year);
    @GET("student/schedule/{id}")
    Call<List<Session>> getSchedule(@Header("Authorization") String Authorization, @Path("id") String id, @Query("sem") int semester, @Query("year") int year);
    @GET("teacher/schedule/{id}")
    Call<List<Session>> getScheduleTeacher(@Header("Authorization") String Authorization, @Path("id") String id, @Query("sem") int semester, @Query("year") int year);
    @GET("teacher/listclass/{id}")
    Call<List<Grade>> getGradeTeacher(@Header("Authorization") String Authorization, @Path("id") String id, @Query("sem") int semester, @Query("year") int year);
    @GET("teacher/listscore/{id}")
    Call<List<Student>> getStudentClass(@Header("Authorization") String Authorization, @Path("id") String id,@Query("class") String classId, @Query("sem") int semester, @Query("year") int year);
    @POST("teacher/addmultiscore")
    Call<ResponseBody> PostCore(@Header("Authorization") String Authorization, @Body List<ScoreRequest> scoreRequest);
}