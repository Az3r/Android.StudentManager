package tkpm.doan.student.ui.teacher;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.security.Key;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Response;
import tkpm.doan.student.data.models.FeedBack;
import tkpm.doan.student.data.models.Grade;
import tkpm.doan.student.data.models.Schedule;
import tkpm.doan.student.data.models.ScoreRequest;
import tkpm.doan.student.data.models.Session;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.data.models.TeacherSchedule;
import tkpm.doan.student.data.repositories.TeacherRepository;
import tkpm.doan.student.ui.components.constants.AppData;
import tkpm.doan.student.ui.components.constants.Keys;

public class TeacherViewModel extends ViewModel {

    private final SavedStateHandle state;
    private final TeacherRepository repository;
    private MutableLiveData<TeacherSchedule> selectedSchedule = new MutableLiveData<>();
    private MutableLiveData<List<Student>> selectedStudents = new MutableLiveData<>();

    @ViewModelInject
    public TeacherViewModel(TeacherRepository repository, @Assisted SavedStateHandle savedStateHandle) {
        this.repository = repository;
        this.state = savedStateHandle;
    }

    public LiveData<List<Grade>> getTeachingGrades() {
        // TODO remove hard-coded params
        return repository.getTeachingGrades(AppData.getInstance().token,AppData.getInstance().TEACHER_ID,  AppData.getInstance().sem,AppData.getInstance().year);
    }

    public LiveData<List<Student>> getStudents(String gradeId) {
        // TODO remove hard-coded params
        return repository.getStudents(AppData.getInstance().token, AppData.getInstance().TEACHER_ID,gradeId, AppData.getInstance().sem,AppData.getInstance().year);
    }
    public LiveData<List<Session>> getSchedule() {
        // TODO remove hard-coded params
        return repository.getSchedule(AppData.getInstance().token,AppData.getInstance().TEACHER_ID, AppData.getInstance().sem, AppData.getInstance().year);
    }
    public LiveData<ResponseBody> postScore(List<ScoreRequest> scoreRequest) {
        // TODO remove hard-coded params
        return repository.PostScore(AppData.getInstance().token,scoreRequest);
    }
    public LiveData<ResponseBody> UpdateScore(List<ScoreRequest> scoreRequest) {
        // TODO remove hard-coded params
        return repository.UpdateScore(AppData.getInstance().token,scoreRequest);
    }
    public LiveData<ResponseBody> PostFeedback(FeedBack feedBack) {
        // TODO remove hard-coded params
        return repository.PostFeedback(AppData.getInstance().token,feedBack);
    }

    public LiveData<String> getSelectedGrade() {
        return state.getLiveData(AppData.getInstance().SELECTED_GRADE);
    }

    public LiveData<String> getTeacherId() {
        return state.getLiveData(AppData.getInstance().TEACHER_ID);
    }

    public void setSelectedGrade(String gradeId) {
        state.set(AppData.getInstance().SELECTED_GRADE, gradeId);
    }

    public void setTeacherId(String teacherId) {
        state.set(AppData.getInstance().TEACHER_ID, teacherId);
    }
    public LiveData<List<Student>> getSelectedStudents() {
        return selectedStudents;
    }

    public void setSelectedStudents(List<Student> students) {
        selectedStudents.postValue(students);
    }
    public LiveData<TeacherSchedule> getSelectedSchedule() {
        return selectedSchedule;
    }

    public void setSelectedSchedule(TeacherSchedule item) {
        selectedSchedule.postValue(item);
    }



}
