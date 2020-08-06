package tkpm.doan.student.ui.student;

import androidx.annotation.NonNull;
import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.util.List;

import tkpm.doan.student.data.models.Notification;
import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.Schedule;
import tkpm.doan.student.data.models.Score;
<<<<<<< HEAD
=======
import tkpm.doan.student.data.models.Session;
>>>>>>> 5446796305a19ef18f1a44b9a300219ce52f80ab
import tkpm.doan.student.data.repositories.StudentRepository;

public class StudentViewModel extends ViewModel {

    @NonNull
    private StudentRepository repository;

    private String studentId;

    private MutableLiveData<Schedule> selectedSchedule = new MutableLiveData<>();
    private MutableLiveData<Notification> selectedNotify = new MutableLiveData<>();

    @ViewModelInject
    public StudentViewModel(@NonNull StudentRepository repository, @Assisted SavedStateHandle savedStateHandle) {
        this.repository = repository;
    }

    public LiveData<PersonalInfo> getPersonalInfo() {
        return repository.getPersonalInfo(Keys.token,Keys.STUDENT_ID);
    }

    public LiveData<List<Score>> getScores() {
        // TODO remove hard-coded params
        return repository.getScores(Keys.token,Keys.STUDENT_ID, 1, 2020);
    }
    public LiveData<List<Session>> getSchedule() {
        // TODO remove hard-coded params
        return repository.getSchedule(Keys.token,Keys.STUDENT_ID, 1, 2020);
    }
    public LiveData<List<Notification>> getNotification() {
        // TODO remove hard-coded params
        return repository.getNotification(Keys.token,Keys.STUDENT_ID);
    }


    public LiveData<Schedule> getSelectedSchedule() {
        return selectedSchedule;
    }

    public void setSelectedSchedule(Schedule item) {
        selectedSchedule.postValue(item);
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setSelectedNotify(Notification item) {
        selectedNotify.postValue(item);
    }
    public LiveData<Notification> getSelectedNotify() {
        return selectedNotify;
    }
}
