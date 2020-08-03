package tkpm.doan.student.data.repositories;

import android.app.Person;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import tkpm.doan.student.data.components.retrofit.OnRetrofitResult;
import tkpm.doan.student.data.components.retrofit.RetrofitService;
import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.Score;
import tkpm.doan.student.data.models.Student;

public class StudentRepository {

    @NonNull
    private RetrofitService retrofit;

    @Inject
    public StudentRepository(@NonNull RetrofitService retrofit) {
        this.retrofit = retrofit;
    }

    public LiveData<PersonalInfo> getPersonalInfo(String studentId) {
        final MutableLiveData<PersonalInfo> info = new MutableLiveData<>();
        retrofit.getStudentProfile(studentId, new OnRetrofitResult<PersonalInfo>() {
            @Override
            public void onSuccess(PersonalInfo result) {
                info.postValue(result);
            }
        });
        return info;
    }

    public LiveData<List<Score>> getScores(String studentId, int year, int semester) {
        final MutableLiveData<List<Score>> scores = new MutableLiveData<>();
        retrofit.getScores(studentId, year, semester, new OnRetrofitResult<List<Score>>() {
            @Override
            public void onSuccess(List<Score> result) {
                scores.postValue(result);
            }
        });
        return scores;
    }
}
