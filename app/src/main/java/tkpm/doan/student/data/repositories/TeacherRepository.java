package tkpm.doan.student.data.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import tkpm.doan.student.data.components.retrofit.RetrofitService;
import tkpm.doan.student.data.models.Grade;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.data.models.TeacherSchedule;

public class TeacherRepository {

    @NonNull
    private final RetrofitService retrofit;

    @Inject
    public MutableLiveData<List<Grade>> grades;

    @Inject
    public MutableLiveData<List<Student>> students;

    @Inject
    public MutableLiveData<List<TeacherSchedule>> schedule;

    @Inject
    public TeacherRepository(@NonNull RetrofitService retrofit) {
        this.retrofit = retrofit;
    }

    public LiveData<List<Grade>> getTeachingGrades(@NonNull String teacherId, int year) {
        // TODO implement this method
        return grades;
    }

    public LiveData<List<Student>> getStudents(@NonNull String gradeId, int i) {
        // TODO implement this method
        return students;
    }

    public LiveData<List<TeacherSchedule>> getSchedule(@NonNull String teacherId, int i, int i1) {
        // TODO implement this method
        return schedule;
    }
}
