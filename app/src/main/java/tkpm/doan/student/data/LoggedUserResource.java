package tkpm.doan.student.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import tkpm.doan.student.data.components.enums.UserTypes;
import tkpm.doan.student.data.components.retrofit.OnRetrofitResult;
import tkpm.doan.student.data.components.retrofit.RetrofitService;
import tkpm.doan.student.data.models.Comment;
import tkpm.doan.student.data.models.Grade;
import tkpm.doan.student.data.models.PersonalInfo;

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
            public void onFailure(PersonalInfo result) {

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
            public void onFailure(PersonalInfo result) {

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
