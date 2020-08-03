package tkpm.doan.student.ui.student;

import androidx.annotation.NonNull;
import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Objects;

import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.Score;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.data.repositories.StudentRepository;
import tkpm.doan.student.ui.components.constants.Keys;

public class StudentViewModel extends ViewModel {

    @NonNull
    private StudentRepository repository;

    @NonNull
    private String studentId;

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

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
