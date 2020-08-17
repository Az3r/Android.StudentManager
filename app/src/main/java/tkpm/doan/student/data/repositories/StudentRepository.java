package tkpm.doan.student.data.repositories;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import tkpm.doan.student.data.components.retrofit.OnRetrofitResult;
import tkpm.doan.student.data.components.retrofit.RetrofitService;
import tkpm.doan.student.data.models.Notification;
import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.Score;
import tkpm.doan.student.data.models.Session;
import tkpm.doan.student.data.models.Student;

public class StudentRepository {

    private static final String TAG = StudentRepository.class.getName();
    @NonNull
    private RetrofitService retrofit;

    @Inject
    public StudentRepository(@NonNull RetrofitService retrofit) {
        this.retrofit = retrofit;
    }

    public LiveData<PersonalInfo> getPersonalInfo(String author, String studentId) {
        final MutableLiveData<PersonalInfo> info = new MutableLiveData<>();
        retrofit.getStudentProfile(author, studentId, new OnRetrofitResult<PersonalInfo>() {
            @Override
            public void onSuccess(PersonalInfo result) {
                info.postValue(result);
            }

            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {

            }
        });
        return info;
    }

    public LiveData<List<Notification>> getNotification(String author, String studentId) {
        final MutableLiveData<List<Notification>> info = new MutableLiveData<>();
        retrofit.getNotification(author, studentId, new OnRetrofitResult<List<Notification>>() {
            @Override
            public void onSuccess(List<Notification> result) {
                info.postValue(result);
            }

            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {

            }

        });
        return info;
    }

    public LiveData<List<Score>> getScores(String author, String studentId, int semester, int year) {
        final MutableLiveData<List<Score>> scores = new MutableLiveData<>();
        retrofit.getScores(author, studentId, semester, year, new OnRetrofitResult<List<Score>>() {
            @Override
            public void onSuccess(List<Score> result) {
                scores.postValue(result);
            }

            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {

            }
        });
        return scores;
    }

    public LiveData<List<Session>> getSchedule(String author, String studentId, int semester, int year) {
        final MutableLiveData<List<Session>> scores = new MutableLiveData<>();
        retrofit.getSchedule(author, studentId, semester, year, new OnRetrofitResult<List<Session>>() {
            @Override
            public void onSuccess(List<Session> result) {
                scores.postValue(result);
            }

            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {

            }
        });
        return scores;
    }
}
