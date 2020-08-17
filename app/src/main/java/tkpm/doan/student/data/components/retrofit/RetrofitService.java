package tkpm.doan.student.data.components.retrofit;

import androidx.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import tkpm.doan.student.data.models.ClassName;
import tkpm.doan.student.data.models.FeedBack;
import tkpm.doan.student.data.models.Grade;
import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.RequestClass;
import tkpm.doan.student.data.models.RequestLogIn;
import tkpm.doan.student.data.models.RequestNotify;
import tkpm.doan.student.data.models.RequestPassword;
import tkpm.doan.student.data.models.RequestSession;
import tkpm.doan.student.data.models.RequestStudent;
import tkpm.doan.student.data.models.RequestTeacher;
import tkpm.doan.student.data.models.ResponLogIn;
import tkpm.doan.student.data.models.ResponSession;
import tkpm.doan.student.data.models.Room;
import tkpm.doan.student.data.models.Score;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.internal.EverythingIsNonNull;
import tkpm.doan.student.data.models.Notification;
import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.Score;
import tkpm.doan.student.data.models.ScoreRequest;
import tkpm.doan.student.data.models.Session;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.data.models.Subject;
import tkpm.doan.student.data.models.Teacher;

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
    public void PostLogIn(RequestLogIn requestLogIn, @NonNull OnRetrofitResult<ResponLogIn> callback) {
        api.LogIn(requestLogIn).enqueue(new RetrofitListener<>(callback));
    }
    public void getScores(String author, String studentId, int semester, int year, @NonNull OnRetrofitResult<List<Score>> callback) {
        api.getScore(author, studentId, semester, year).enqueue(new RetrofitListener<>(callback));
    }
    public void GetRoom(String author, @NonNull OnRetrofitResult<List<Room>> callback) {
        api.getRoom(author).enqueue(new RetrofitListener<>(callback));
    }

    public void getSchedule(String author, String studentId, int semester, int year, @NonNull OnRetrofitResult<List<Session>> callback) {
        api.getSchedule(author, studentId, semester, year).enqueue(new RetrofitListener<>(callback));
    }
    public void getScheduleTeacher(String author, String studentId, int semester, int year, @NonNull OnRetrofitResult<List<Session>> callback) {
        api.getScheduleTeacher(author, studentId, semester, year).enqueue(new RetrofitListener<>(callback));
    }
    public void getNotification(String author, String studentId, @NonNull OnRetrofitResult<List<Notification>> callback) {
        api.getNotification(author, studentId).enqueue(new RetrofitListener<>(callback));
    }
    public void getStudentProfile(String author, String studentId, @NonNull OnRetrofitResult<PersonalInfo> callback) {
        api.getStudent(author, studentId).enqueue(new RetrofitListener<>(callback));
    }
    public void getTeacherProfile(String author, String studentId, @NonNull OnRetrofitResult<PersonalInfo> callback) {
        api.getTeacher(author, studentId).enqueue(new RetrofitListener<>(callback));
    }
    public void getGradeTeacher(String author, String teacherID,int sem, int year, @NonNull OnRetrofitResult<List<Grade>> callback) {
        api.getGradeTeacher(author, teacherID,sem,year).enqueue(new RetrofitListener<>(callback));
    }
    public void getStudentClass(String author, String teacherID,String ClassId,int sem, int year, @NonNull OnRetrofitResult<List<Student>> callback) {
        api.getStudentClass(author, teacherID,ClassId,sem,year).enqueue(new RetrofitListener<>(callback));
    }
    public void getAllStudentClass(String author,String ClassId,int sem, int year, @NonNull OnRetrofitResult<List<PersonalInfo>> callback) {
        api.getAllStudentClass(author,ClassId,sem,year).enqueue(new RetrofitListener<>(callback));
    }
    public void getScheduleClass(String author,String ClassId,int sem, int year, @NonNull OnRetrofitResult<List<ResponSession>> callback) {
        api.getScheduleClass(author,ClassId,sem,year).enqueue(new RetrofitListener<>(callback));
    }
    public void getAllSchedule(String author,int sem, int year, @NonNull OnRetrofitResult<List<ResponSession>> callback) {
        api.getAllSchedule(author,sem,year).enqueue(new RetrofitListener<>(callback));
    }
    public void getAllClass(String author, int year, @NonNull OnRetrofitResult<List<ClassName>> callback) {
        api.getAllClass(author,year).enqueue(new RetrofitListener<>(callback));
    }
    public void getAllStudent(String author, int year, @NonNull OnRetrofitResult<List<Student>> callback) {
        api.getAllStudent(author,year).enqueue(new RetrofitListener<>(callback));
    }
    public void getAllSubject(String author, @NonNull OnRetrofitResult<List<Subject>> callback) {
        api.getAllSubject(author).enqueue(new RetrofitListener<>(callback));
    }
    public void GetAllSubjectByTeacher(String author, @NonNull OnRetrofitResult<List<Subject>> callback) {
        api.getAllSubjectByTeacher(author).enqueue(new RetrofitListener<>(callback));
    }
    public void getAllNotify(String author, @NonNull OnRetrofitResult<List<Notification>> callback) {
        api.getAllNotify(author).enqueue(new RetrofitListener<>(callback));
    }
    public void GetAllTeacher(String author, @NonNull OnRetrofitResult<List<Teacher>> callback) {
        api.getAllTeacher(author).enqueue(new RetrofitListener<>(callback));
    }
    public void PostScore(String author, List<ScoreRequest> scoreRequest, @NonNull OnRetrofitResult<ResponseBody> callback) {
        api.PostCore(author, scoreRequest).enqueue(new RetrofitListener<>(callback));
    }
    public void UpdateScore(String author, List<ScoreRequest> scoreRequest, @NonNull OnRetrofitResult<ResponseBody> callback) {
        api.UpdatetCore(author, scoreRequest).enqueue(new RetrofitListener<>(callback));
    }
    public void PostFeedback(String author, FeedBack feedBack, @NonNull OnRetrofitResult<ResponseBody> callback) {
        api.PostFeedback(author, feedBack).enqueue(new RetrofitListener<>(callback));
    }
    public void PostNotify(String author, RequestNotify feedBack, @NonNull OnRetrofitResult<ResponseBody> callback) {
        api.PostNotify(author, feedBack).enqueue(new RetrofitListener<>(callback));
    }
    public void PostSchedule(String author, RequestSession feedBack, @NonNull OnRetrofitResult<ResponseBody> callback) {
        api.PostSchedule(author, feedBack).enqueue(new RetrofitListener<>(callback));
    }
    public void UpdateSchedule(String author, RequestSession feedBack, @NonNull OnRetrofitResult<ResponseBody> callback) {
        api.UpdateSchedule(author, feedBack).enqueue(new RetrofitListener<>(callback));
    }
    public void PostClass(String author, RequestClass feedBack, @NonNull OnRetrofitResult<ResponseBody> callback) {
        api.PostClass(author, feedBack).enqueue(new RetrofitListener<>(callback));
    }
    public void UpdateNotify(String author, RequestNotify feedBack, @NonNull OnRetrofitResult<ResponseBody> callback) {
        api.UpdateNotify(author, feedBack).enqueue(new RetrofitListener<>(callback));
    }
    public void PostStudent(String author, RequestStudent student, @NonNull OnRetrofitResult<ResponseBody> callback) {
        api.PostStudent(author, student).enqueue(new RetrofitListener<>(callback));
    }
    public void UpdateStudent(String author, RequestStudent student, @NonNull OnRetrofitResult<ResponseBody> callback) {
        api.UpdateStudent(author, student).enqueue(new RetrofitListener<>(callback));
    }
    public void PostTeacher(String author, RequestTeacher teacher, @NonNull OnRetrofitResult<ResponseBody> callback) {
        api.PostTeacher(author, teacher).enqueue(new RetrofitListener<>(callback));
    }
    public void UpdateTeacher(String author, RequestTeacher teacher, @NonNull OnRetrofitResult<ResponseBody> callback) {
        api.UpdateTeacher(author, teacher).enqueue(new RetrofitListener<>(callback));
    }
    public void UpdatePassword(String author, RequestPassword teacher, @NonNull OnRetrofitResult<ResponLogIn> callback) {
        api.UpdatePassword(author, teacher).enqueue(new RetrofitListener<>(callback));
    }
}
