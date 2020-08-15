package tkpm.doan.student.data.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import tkpm.doan.student.data.components.retrofit.OnRetrofitResult;
import tkpm.doan.student.data.components.retrofit.RetrofitService;
import tkpm.doan.student.data.models.Grade;
import tkpm.doan.student.data.models.Session;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.data.models.TeacherSchedule;

public class TeacherRepository {

    @NonNull
    private final RetrofitService retrofit;
    public MutableLiveData<List<Grade>> grades;
    public MutableLiveData<List<Student>> students;
    public MutableLiveData<List<TeacherSchedule>> schedule;
    @Inject
    public TeacherRepository(@NonNull RetrofitService retrofit) {
        this.retrofit = retrofit;
    }

    public LiveData<List<Grade>> getTeachingGrades(String author,@NonNull String teacherId, int semester,int year) {
        final MutableLiveData<List<Grade>> schedules = new MutableLiveData<>();
        retrofit.getGradeTeacher(author, teacherId, semester, year, new OnRetrofitResult<List<Grade>>() {
            @Override
            public void onSuccess(List<Grade> result) {
                schedules.postValue(result);
            }
        });
        return schedules;
    }

    public LiveData<List<Student>> getStudents(String author,String teacherId,String classID,int semester, int year) {
        final MutableLiveData<List<Student>> schedules = new MutableLiveData<>();
        retrofit.getStudentClass(author, teacherId,classID, semester, year, new OnRetrofitResult<List<Student>>() {
            @Override
            public void onSuccess(List<Student> result) {
                schedules.postValue(result);
            }
        });
        return schedules;
    }
    public LiveData<List<Session>> getSchedule(String author,@NonNull String teacherId, int semester, int year) {
        final MutableLiveData<List<Session>> schedules = new MutableLiveData<>();
        retrofit.getScheduleTeacher(author, teacherId, semester, year, new OnRetrofitResult<List<Session>>() {
            @Override
            public void onSuccess(List<Session> result) {
                schedules.postValue(result);
            }
        });
        return schedules;
    }
}
