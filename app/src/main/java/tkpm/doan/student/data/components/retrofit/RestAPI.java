package tkpm.doan.student.data.components.retrofit;

import com.google.gson.internal.$Gson$Types;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import tkpm.doan.student.data.models.ClassName;
import tkpm.doan.student.data.models.FeedBack;
import tkpm.doan.student.data.models.Grade;
import tkpm.doan.student.data.models.Notification;
import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.RequestLogIn;
import tkpm.doan.student.data.models.RequestNotify;
import tkpm.doan.student.data.models.RequestStudent;
import tkpm.doan.student.data.models.RequestTeacher;
import tkpm.doan.student.data.models.ResponLogIn;
import tkpm.doan.student.data.models.Score;
import tkpm.doan.student.data.models.ScoreRequest;
import tkpm.doan.student.data.models.Session;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.data.models.Subject;
import tkpm.doan.student.data.models.Teacher;

public interface RestAPI {

    @POST("user/login")
    Call<ResponLogIn> LogIn(@Body RequestLogIn requestLogIn);

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

    @GET("manager/allclass")
    Call<List<ClassName>> getAllClass(@Header("Authorization") String Authorizationer, @Query("year") int year);

    @GET("manager/allsubject")
    Call<List<Subject>> getAllSubject(@Header("Authorization") String Authorizationer);

    @GET("manager/listsubject")
    Call<List<Subject>> getAllSubjectByTeacher(@Header("Authorization") String Authorizationer);

    @GET("manager/allnoti")
    Call<List<Notification>> getAllNotify(@Header("Authorization") String Authorizationer);

    @GET("manager/allteacher")
    Call<List<Teacher>> getAllTeacher(@Header("Authorization") String Authorizationer);

    @GET("manager/allstudent")
    Call<List<Student>> getAllStudent(@Header("Authorization") String Authorizationer, @Query("year") int year);

    @GET("teacher/listscore/{id}")
    Call<List<Student>> getStudentClass(@Header("Authorization") String Authorization, @Path("id") String id,@Query("class") String classId, @Query("sem") int semester, @Query("year") int year);

    @POST("teacher/updatemultiscore")
    Call<ResponseBody> UpdatetCore(@Header("Authorization") String Authorization, @Body List<ScoreRequest> scoreRequest);

    @POST("teacher/addmultiscore")
    Call<ResponseBody> PostCore(@Header("Authorization") String Authorization, @Body List<ScoreRequest> scoreRequest);

    @POST("teacher/addfeedback")
    Call<ResponseBody> PostFeedback(@Header("Authorization") String Authorization, @Body FeedBack feedBack);

    @POST("manager/addnoti")
    Call<ResponseBody> PostNotify(@Header("Authorization") String Authorization, @Body RequestNotify notify);

    @POST("manager/updatenoti")
    Call<ResponseBody> UpdateNotify(@Header("Authorization") String Authorization, @Body RequestNotify notify);

    @POST("manager/addstudent")
    Call<ResponseBody> PostStudent(@Header("Authorization") String Authorization, @Body RequestStudent student);

    @POST("manager/updatestudent")
    Call<ResponseBody> UpdateStudent(@Header("Authorization") String Authorization, @Body RequestStudent student);

    @POST("manager/addteacher")
    Call<ResponseBody> PostTeacher(@Header("Authorization") String Authorization, @Body RequestTeacher student);

    @POST("manager/updateteacher")
    Call<ResponseBody> UpdateTeacher(@Header("Authorization") String Authorization, @Body RequestTeacher student);

}