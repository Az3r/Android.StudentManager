package tkpm.doan.student.ui.student;

import android.app.AlertDialog;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import tkpm.doan.student.data.components.retrofit.OnResult;
import tkpm.doan.student.data.models.Score;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.data.repositories.StudentRepository;

public class StudentViewModel extends ViewModel {

    private StudentRepository repository = new StudentRepository();
    private MutableLiveData<Student> studentLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Score>> scoreLiveData = new MutableLiveData<>();

    public StudentViewModel() {
        repository.getScore("1140712", 1, 2016, new OnResult<List<Score>>() {
            @Override
            public void onSuccess(List<Score> result) {
                scoreLiveData.postValue(result);
            }

            @Override
            public void onFailure(Exception error) {
            }
        });
    }

    public LiveData<Student> getStudentLiveData() {
        return studentLiveData;
    }

    public LiveData<List<Score>> getScoreLiveData() {
        return scoreLiveData;
    }
}
