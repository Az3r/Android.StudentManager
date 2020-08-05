package tkpm.doan.student.ui.student;

import androidx.annotation.NonNull;
import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.util.List;

import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.Schedule;
import tkpm.doan.student.data.models.Score;
import tkpm.doan.student.data.repositories.StudentRepository;

public class StudentViewModel extends ViewModel {

    @NonNull
    private StudentRepository repository;

    private String studentId;

    private MutableLiveData<Schedule> selectedSchedule = new MutableLiveData<>();

    @ViewModelInject
    public StudentViewModel(@NonNull StudentRepository repository, @Assisted SavedStateHandle savedStateHandle) {
        this.repository = repository;
    }

    public LiveData<PersonalInfo> getPersonalInfo() {
        return repository.getPersonalInfo(studentId);
    }

    public LiveData<List<Score>> getScores() {
        // TODO remove hard-coded params
        return repository.getScores(this.studentId, 1, 2016);
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


}
