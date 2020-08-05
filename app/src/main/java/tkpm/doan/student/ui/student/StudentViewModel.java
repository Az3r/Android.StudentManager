package tkpm.doan.student.ui.student;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Objects;

import tkpm.doan.student.data.models.Notification;
import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.Schedule;
import tkpm.doan.student.data.models.Score;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.data.repositories.StudentRepository;
import tkpm.doan.student.ui.components.constants.Keys;

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
        return repository.getPersonalInfo("1140713");
    }

    public LiveData<List<Score>> getScores() {
        // TODO remove hard-coded params
        return repository.getScores(this.studentId, 1, 2016);
    }
    public LiveData<List<Notification>> getNotification() {
        // TODO remove hard-coded params
        return repository.getNotification("1140713");
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
