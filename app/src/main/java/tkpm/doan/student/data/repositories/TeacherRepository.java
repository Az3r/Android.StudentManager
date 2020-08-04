package tkpm.doan.student.data.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import tkpm.doan.student.data.components.retrofit.RetrofitService;
import tkpm.doan.student.data.models.Grade;

public class TeacherRepository {

    @NonNull
    private final RetrofitService retrofit;

    @Inject
    public MutableLiveData<List<Grade>> grades;

    @Inject
    public TeacherRepository(@NonNull RetrofitService retrofit) {
        this.retrofit = retrofit;
    }

    public LiveData<List<Grade>> getTeachingGrades(String teacherId, int year) {
        // TODO implement this method
        return grades;
    }
}
