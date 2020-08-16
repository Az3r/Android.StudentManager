package tkpm.doan.student.ui.manager;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.util.List;

import okhttp3.ResponseBody;
import tkpm.doan.student.data.models.ClassName;
import tkpm.doan.student.data.models.FeedBack;
import tkpm.doan.student.data.models.Notification;
import tkpm.doan.student.data.models.RequestNotify;
import tkpm.doan.student.data.models.RequestStudent;
import tkpm.doan.student.data.models.RequestTeacher;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.data.models.Subject;
import tkpm.doan.student.data.models.TeacherSchedule;
import tkpm.doan.student.data.repositories.ManageRepository;
import tkpm.doan.student.data.repositories.TeacherRepository;
import tkpm.doan.student.ui.components.constants.Keys;

public class ManagerViewModel extends ViewModel {

    private SavedStateHandle savedStateHandle;
    private final ManageRepository repository;
    private MutableLiveData<TeacherSchedule> selectedSchedule = new MutableLiveData<>();
    private MutableLiveData<RequestStudent> selectedStudents = new MutableLiveData<>();
    private MutableLiveData<Notification> selectedNotify = new MutableLiveData<>();

    @ViewModelInject
    public ManagerViewModel(ManageRepository repository, @Assisted SavedStateHandle savedStateHandle) {
        this.repository = repository;
        this.savedStateHandle = savedStateHandle;
    }
    public LiveData<ResponseBody> PostNotify(RequestNotify requestNotify) {
        // TODO remove hard-coded params
        return repository.PostNotify(Keys.token,requestNotify);
    }
    public LiveData<ResponseBody> UpdateNotify(RequestNotify requestNotify) {
        // TODO remove hard-coded params
        return repository.UpdateNotify(Keys.token,requestNotify);
    }
    public LiveData<ResponseBody> PostStudent(RequestStudent requestNotify) {
        // TODO remove hard-coded params
        return repository.PostStudent(Keys.token,requestNotify);
    }
    public LiveData<ResponseBody> UpdateStudent(RequestStudent requestNotify) {
        // TODO remove hard-coded params
        return repository.PostStudent(Keys.token,requestNotify);
    }
    public LiveData<ResponseBody> PostTeacher(RequestTeacher requestNotify) {
        // TODO remove hard-coded params
        return repository.PostTeacher(Keys.token,requestNotify);
    }
    public LiveData<List<ClassName>> GetAllClass(int year) {
        // TODO remove hard-coded params
        return repository.GetAllClass(Keys.token,year);
    }
    public LiveData<List<Subject>> GetAllSubject(int year) {
        // TODO remove hard-coded params
        return repository.GetAllSubject(Keys.token);
    }
    public LiveData<List<RequestStudent>> getAllStudent(int year) {
        // TODO remove hard-coded params
        return repository.getAllStudent(Keys.token,year);
    }
    public LiveData<List<Notification>> getAllNotify() {
        // TODO remove hard-coded params
        return repository.getAllNotify(Keys.token);
    }

    public void setSelectedNotify(Notification item) {
        selectedNotify.postValue(item);
    }
    public LiveData<Notification> getSelectedNotify() {
        return selectedNotify;
    }
    public void setSelectedStudent(RequestStudent item) {
        selectedStudents.postValue(item);
    }
    public LiveData<RequestStudent> getSelectedStudent() {
        return selectedStudents;
    }
}
