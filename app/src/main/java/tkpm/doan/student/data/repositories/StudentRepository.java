package tkpm.doan.student.data.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import tkpm.doan.student.data.components.retrofit.OnRetrofitResult;
import tkpm.doan.student.data.components.retrofit.RetrofitService;
import tkpm.doan.student.data.models.Notification;
import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.Score;

public class StudentRepository {

    private static final String TAG = StudentRepository.class.getName();
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
    public LiveData<List<Notification>> getNotification(String studentId) {
        final MutableLiveData<List<Notification>> info = new MutableLiveData<>();
        retrofit.getNotification(studentId, new OnRetrofitResult<List<Notification>>() {
            @Override
            public void onSuccess(List<Notification> result) {
                info.postValue(result);
            }
        });
        return info;
    }

    public LiveData<List<Score>> getScores(String studentId, int semester, int year) {
        final MutableLiveData<List<Score>> scores = new MutableLiveData<>();
        retrofit.getScores(studentId, semester, year, new OnRetrofitResult<List<Score>>() {
            @Override
            public void onSuccess(List<Score> result) {
                scores.postValue(result);
            }
        });
        return scores;
    }
}
