package tkpm.doan.student.ui.launch;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.security.Key;
import java.util.List;

import javax.annotation.Nonnull;

import tkpm.doan.student.data.LoggedUserResource;
import tkpm.doan.student.data.components.enums.UserTypes;
import tkpm.doan.student.data.models.Comment;
import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.RequestLogIn;
import tkpm.doan.student.data.models.ResponLogIn;
import tkpm.doan.student.ui.components.constants.Keys;

public class LoggedUserViewModel extends ViewModel {

    @Nonnull
    private LoggedUserResource userResource;

    private SavedStateHandle savedStateHandle;

    @ViewModelInject
    public LoggedUserViewModel(@Nonnull LoggedUserResource resource, @Assisted SavedStateHandle savedStateHandle) {
        this.userResource = resource;
        this.savedStateHandle = savedStateHandle;
    }
    public LiveData<UserTypes> getUserType() {
        return userResource.getUserType();
    }

    public LiveData<PersonalInfo> getStudentInfo() {
        return userResource.getStudentInfo(Keys.token, Keys.STUDENT_ID);
    }
    public LiveData<PersonalInfo> getTeacherInfo() {
        return userResource.getTeacherInfo(Keys.token, Keys.TEACHER_ID);
    }
    public LiveData<ResponLogIn> PostLogIn(RequestLogIn requestLogIn)
    {
        return userResource.PostLogIn(requestLogIn);
    }
    public LiveData<List<Comment>> getComments() {
        return userResource.getComments();
    }

    public LiveData<Boolean> isHomeTeacher() {
        return userResource.isHomeTeacher();
    }
}
