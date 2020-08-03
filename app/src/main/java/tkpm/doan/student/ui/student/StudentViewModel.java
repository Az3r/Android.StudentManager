package tkpm.doan.student.ui.student;

import androidx.annotation.NonNull;
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

    private LiveData<PersonalInfo> personalInfo;
    private LiveData<List<Score>> scores;

    @ViewModelInject
    public StudentViewModel(@NonNull StudentRepository repository, SavedStateHandle savedStateHandle) {
        this.repository = repository;
        this.studentId = Objects.requireNonNull(savedStateHandle.get(Keys.STUDENT_ID));
    }

    public LiveData<PersonalInfo> getPersonalInfo() {
        if (personalInfo == null) {
            personalInfo = repository.getPersonalInfo(this.studentId);
        }
        return personalInfo;
    }

    public LiveData<List<Score>> getScores() {
        // TODO remove hard-coded params
        if (scores == null) {
            scores = repository.getScores(this.studentId, 2016, 1);
        }
        return scores;
    }
}
