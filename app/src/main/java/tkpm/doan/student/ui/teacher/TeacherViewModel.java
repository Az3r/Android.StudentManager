package tkpm.doan.student.ui.teacher;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.util.List;

import tkpm.doan.student.data.models.Grade;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.data.repositories.TeacherRepository;
import tkpm.doan.student.ui.components.constants.Keys;

public class TeacherViewModel extends ViewModel {

    private final SavedStateHandle state;
    private final TeacherRepository repositroy;

    @ViewModelInject
    public TeacherViewModel(TeacherRepository repository, @Assisted SavedStateHandle savedStateHandle) {
        this.repositroy = repository;
        this.state = savedStateHandle; 
    }

    public LiveData<List<Grade>> getTeachingGrades() {
        // TODO remove hard-coded params
        return repositroy.getTeachingGrades("12345", 2020);
    }

    public LiveData<List<Student>> getStudents(String gradeId) {
        return repositroy.getStudents(gradeId, 2020);
    }

    public LiveData<String> getSelectedGrade() {
        return state.getLiveData(Keys.BUNDLE_SELECTED_GRADE);
    }
    public void setSelectedGrade(String gradeId) {
        state.set(Keys.BUNDLE_SELECTED_GRADE, gradeId);
    }
}
