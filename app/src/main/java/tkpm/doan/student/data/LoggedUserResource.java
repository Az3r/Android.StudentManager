package tkpm.doan.student.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import tkpm.doan.student.data.components.enums.UserTypes;
import tkpm.doan.student.data.components.retrofit.RetrofitService;
import tkpm.doan.student.data.models.Comment;
import tkpm.doan.student.data.models.PersonalInfo;

public class LoggedUserResource {

    @NonNull
    private RetrofitService retrofit;

    private MutableLiveData<String> userId = new MutableLiveData<>();

    private MutableLiveData<UserTypes> userType = new MutableLiveData<>();

    private MutableLiveData<PersonalInfo> personalInfo = new MutableLiveData<>();

    private MutableLiveData<List<Comment>> comments = new MutableLiveData<>();

    @Inject
    public LoggedUserResource() {
    }
    public LiveData<String> getUserId() {
        return userId;
    }

    public LiveData<UserTypes> getUserType() {
        return userType;
    }

    public LiveData<PersonalInfo> getPersonalInfo() {
        return personalInfo;
    }

    public LiveData<List<Comment>> getComments() {
        return comments;
    }
}
