package tkpm.doan.student.ui.manager;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.util.List;

import okhttp3.ResponseBody;
import tkpm.doan.student.data.models.ClassName;
import tkpm.doan.student.data.models.FeedBack;
import tkpm.doan.student.data.models.Notification;
import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.RequestClass;
import tkpm.doan.student.data.models.RequestNotify;
import tkpm.doan.student.data.models.RequestSession;
import tkpm.doan.student.data.models.RequestStudent;
import tkpm.doan.student.data.models.RequestTeacher;
import tkpm.doan.student.data.models.ResponSession;
import tkpm.doan.student.data.models.Room;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.data.models.Subject;
import tkpm.doan.student.data.models.Teacher;
import tkpm.doan.student.data.models.TeacherSchedule;
import tkpm.doan.student.data.repositories.ManageRepository;
import tkpm.doan.student.data.repositories.TeacherRepository;
import tkpm.doan.student.ui.components.constants.AppData;
import tkpm.doan.student.ui.components.constants.Keys;

public class ManagerViewModel extends ViewModel {

    private SavedStateHandle savedStateHandle;
    private final ManageRepository repository;
    private MutableLiveData<TeacherSchedule> selectedSchedule = new MutableLiveData<>();
    private MutableLiveData<Student> selectedStudents = new MutableLiveData<>();
    private MutableLiveData<PersonalInfo> selectedStudentsClass = new MutableLiveData<>();
    private MutableLiveData<Teacher> selectedTeacher = new MutableLiveData<>();
    private MutableLiveData<ClassName> selectedGrade = new MutableLiveData<>();
    private MutableLiveData<Notification> selectedNotify = new MutableLiveData<>();
    private MutableLiveData<Integer> day = new MutableLiveData<>();

    @ViewModelInject
    public ManagerViewModel(ManageRepository repository, @Assisted SavedStateHandle savedStateHandle) {
        this.repository = repository;
        this.savedStateHandle = savedStateHandle;
    }
    public LiveData<ResponseBody> PostNotify(RequestNotify requestNotify) {
        // TODO remove hard-coded params
        return repository.PostNotify(AppData.getInstance().token,requestNotify);
    }
    public LiveData<ResponseBody> UpdateNotify(RequestNotify requestNotify) {
        // TODO remove hard-coded params
        return repository.UpdateNotify(AppData.getInstance().token,requestNotify);
    }
    public LiveData<ResponseBody> PostStudent(RequestStudent requestNotify) {
        // TODO remove hard-coded params
        return repository.PostStudent(AppData.getInstance().token,requestNotify);
    }
    public LiveData<ResponseBody> UpdateStudent(RequestStudent requestNotify) {
        // TODO remove hard-coded params
        return repository.UpdateStudent(AppData.getInstance().token,requestNotify);
    }
    public LiveData<ResponseBody> PostTeacher(RequestTeacher requestNotify) {
        // TODO remove hard-coded params
        return repository.PostTeacher(AppData.getInstance().token,requestNotify);
    }
    public LiveData<ResponseBody> PostClass(RequestClass requestNotify) {
        // TODO remove hard-coded params
        return repository.PostClass(AppData.getInstance().token,requestNotify);
    }
    public LiveData<ResponseBody> UpdateTeacher(RequestTeacher requestNotify) {
        // TODO remove hard-coded params
        return repository.UpdateTeacher(AppData.getInstance().token,requestNotify);
    }
    public LiveData<ResponseBody> PostSchedule(RequestSession requestNotify) {
        // TODO remove hard-coded params
        return repository.PostSchedule(AppData.getInstance().token,requestNotify);
    }
    public LiveData<ResponseBody> UpdateSchedule(RequestSession requestNotify) {
        // TODO remove hard-coded params
        return repository.UpdateSchedule(AppData.getInstance().token,requestNotify);
    }
    public LiveData<List<ClassName>> GetAllClass(int year) {
        // TODO remove hard-coded params
        return repository.GetAllClass(AppData.getInstance().token,year);
    }
    public LiveData<List<PersonalInfo>> GetAllStudentClass(String ClassId, int sem, int year) {
        // TODO remove hard-coded params
        return repository.GetAllStudentClass(AppData.getInstance().token,ClassId,sem,year);
    }
    public LiveData<List<ResponSession>> GetScheduleClass(String ClassId, int sem, int year) {
        // TODO remove hard-coded params
        return repository.GetScheduleClass(AppData.getInstance().token,ClassId,sem,year);
    }
    public LiveData<List<ResponSession>> getAllSchedule( int sem, int year) {
        // TODO remove hard-coded params
        return repository.getAllSchedule(AppData.getInstance().token,sem,year);
    }
    public LiveData<List<Room>> GetSRoom() {
        // TODO remove hard-coded params
        return repository.GetSRoom(AppData.getInstance().token);
    }
    public LiveData<List<Subject>> GetAllSubject(int year) {
        // TODO remove hard-coded params
        return repository.GetAllSubject(AppData.getInstance().token);
    }
    public LiveData<List<Subject>> GetAllSubjectByTeacher() {
        // TODO remove hard-coded params
        return repository.GetAllSubjectByTeacher(AppData.getInstance().token);
    }
    public LiveData<List<Student>> getAllStudent(int year) {
        // TODO remove hard-coded params
        return repository.getAllStudent(AppData.getInstance().token,year);
    }
    public LiveData<List<Notification>> getAllNotify() {
        // TODO remove hard-coded params
        return repository.getAllNotify(AppData.getInstance().token);
    }
    public LiveData<List<Teacher>> GetAllTeacher() {
        // TODO remove hard-coded params
        return repository.GetAllTeacher(AppData.getInstance().token);
    }

    public void setSelectedNotify(Notification item) {
        selectedNotify.postValue(item);
    }

    public LiveData<Notification> getSelectedNotify() {
        return selectedNotify;
    }

    public void setSelectedStudent(Student item) {
        selectedStudents.postValue(item);
    }
    public LiveData<Student> getSelectedStudent() {
        return selectedStudents;
    }
    public void setSelectedStudentClass(PersonalInfo item) {
        selectedStudentsClass.postValue(item);
    }
    public LiveData<PersonalInfo> getSelectedStudentClass() {
        return selectedStudentsClass;
    }

    public void setSelectedTeacher(Teacher item) {
        selectedTeacher.postValue(item);
    }
    public LiveData<Teacher> getSelectedTeacher() {
        return selectedTeacher;
    }
    public void setSelectedGrade(ClassName item) {
        selectedGrade.postValue(item);
    }
    public LiveData<ClassName> getSelectedGrade() {
        return selectedGrade;
    }
    public void setDaySchedule(int item) {
        day.postValue(item);
    }
    public LiveData<Integer> getDaySchedule() {
        return day;
    }
}
