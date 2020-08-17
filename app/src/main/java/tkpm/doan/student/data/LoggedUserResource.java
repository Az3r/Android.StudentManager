package tkpm.doan.student.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import tkpm.doan.student.data.components.enums.UserTypes;
import tkpm.doan.student.data.components.retrofit.OnRetrofitResult;
import tkpm.doan.student.data.components.retrofit.RetrofitService;
import tkpm.doan.student.data.models.Comment;
import tkpm.doan.student.data.models.Grade;
import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.RequestLogIn;
import tkpm.doan.student.data.models.RequestPassword;
import tkpm.doan.student.data.models.RequestTeacher;
import tkpm.doan.student.data.models.ResponLogIn;

public class LoggedUserResource {

    @NonNull
    private RetrofitService retrofit;

    private MutableLiveData<String> userId = new MutableLiveData<>();

    private MutableLiveData<UserTypes> userType = new MutableLiveData<>();

    private MutableLiveData<PersonalInfo> personalInfo = new MutableLiveData<>();

    private MutableLiveData<List<Comment>> comments = new MutableLiveData<>();

    private MutableLiveData<Boolean> homeTeacher = new MutableLiveData<>(true);

    @Inject
    public LoggedUserResource(@NonNull RetrofitService retrofit) {
        this.retrofit = retrofit;
    }
    public LiveData<String> getUserId() {
        return userId;
    }
    public LiveData<ResponLogIn> PostLogIn(RequestLogIn requestLogIn) {
        final MutableLiveData<ResponLogIn> schedules = new MutableLiveData<>();
        retrofit.PostLogIn(requestLogIn, new OnRetrofitResult<ResponLogIn>() {
            @Override
            public void onSuccess(ResponLogIn result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<ResponLogIn> UpdatePassword(String token,RequestPassword requestLogIn) {
        final MutableLiveData<ResponLogIn> schedules = new MutableLiveData<>();
        retrofit.UpdatePassword(token,requestLogIn, new OnRetrofitResult<ResponLogIn>() {
            @Override
            public void onSuccess(ResponLogIn result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<UserTypes> getUserType() {
        return userType;
    }
    public LiveData<PersonalInfo> getStudentInfo(String author, String studentID) {
        final MutableLiveData<PersonalInfo> schedules = new MutableLiveData<>();
        retrofit.getStudentProfile(author, studentID, new OnRetrofitResult<PersonalInfo>() {
            @Override
            public void onSuccess(PersonalInfo result) {
                schedules.postValue(result);
            }

            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {

            }
        });
        return schedules;
    }
    public LiveData<PersonalInfo> getTeacherInfo(String author, String studentID) {
        final MutableLiveData<PersonalInfo> schedules = new MutableLiveData<>();
        retrofit.getTeacherProfile(author, studentID, new OnRetrofitResult<PersonalInfo>() {
            @Override
            public void onSuccess(PersonalInfo result) {
                schedules.postValue(result);
            }

            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {

            }
        });
        return schedules;
    }
    public LiveData<List<Comment>> getComments() {
        return comments;
    }
    public LiveData<Boolean> isHomeTeacher() {
        return homeTeacher;
    }
}
