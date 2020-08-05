package tkpm.doan.student.data.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import tkpm.doan.student.data.components.retrofit.RetrofitService;
import tkpm.doan.student.data.models.Grade;
import tkpm.doan.student.data.models.Student;

public class TeacherRepository {

    @NonNull
    private final RetrofitService retrofit;

    @Inject
    public MutableLiveData<List<Grade>> grades;

    @Inject
    public MutableLiveData<List<Student>> students;

    @Inject
    public TeacherRepository(@NonNull RetrofitService retrofit) {
        this.retrofit = retrofit;
    }

    public LiveData<List<Grade>> getTeachingGrades(String teacherId, int year) {
        // TODO implement this method
        return grades;
    }

    public LiveData<List<Student>> getStudents(String gradeId, int i) {
        // TODO implement this method
        return students;
    }
}
