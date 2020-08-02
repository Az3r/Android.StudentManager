package tkpm.doan.student.ui.student;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import tkpm.doan.student.data.models.Student;

public class StudentViewModel extends ViewModel {
    public LiveData<Integer> integerLiveData;

    public LiveData<Student> studentLiveData;
}
