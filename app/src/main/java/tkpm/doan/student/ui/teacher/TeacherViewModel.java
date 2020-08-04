package tkpm.doan.student.ui.teacher;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.util.List;

import tkpm.doan.student.data.models.Grade;
import tkpm.doan.student.data.repositories.TeacherRepository;

public class TeacherViewModel extends ViewModel {

    private final SavedStateHandle state;
    private final TeacherRepository repositroy;

    @ViewModelInject
    public TeacherViewModel(TeacherRepository repository, @Assisted SavedStateHandle savedStateHandle) {
        this.repositroy = repository;
        this.state = savedStateHandle; 
    }


    public LiveData<List<Grade>> getTeachingGrades(String teacherId, int year) {
        return repositroy.getTeachingGrades(teacherId, year);
    }
}
