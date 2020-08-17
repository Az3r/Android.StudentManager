package tkpm.doan.student.data.repositories;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import tkpm.doan.student.data.components.retrofit.OnRetrofitResult;
import tkpm.doan.student.data.components.retrofit.RetrofitService;
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

public class ManageRepository {

    private static final String TAG = ManageRepository.class.getName();
    @NonNull
    private RetrofitService retrofit;
    @Inject
    public ManageRepository(@NonNull RetrofitService retrofit) {
        this.retrofit = retrofit;
    }

    public LiveData<ResponseBody> PostNotify(String author, RequestNotify requestNotify) {
        final MutableLiveData<ResponseBody> schedules = new MutableLiveData<>();
        retrofit.PostNotify(author, requestNotify, new OnRetrofitResult<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<List<PersonalInfo>> GetAllStudentClass(String author, String classID, int sem, int year) {
        final MutableLiveData<List<PersonalInfo>> schedules = new MutableLiveData<>();
        retrofit.getAllStudentClass(author, classID,sem,year, new OnRetrofitResult<List<PersonalInfo>>() {
            @Override
            public void onSuccess(List<PersonalInfo> result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }

    public LiveData<List<ResponSession>> GetScheduleClass(String author, String classID, int sem, int year) {
        final MutableLiveData<List<ResponSession>> schedules = new MutableLiveData<>();
        retrofit.getScheduleClass(author, classID,sem,year, new OnRetrofitResult<List<ResponSession>>() {
            @Override
            public void onSuccess(List<ResponSession> result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<List<ResponSession>> getAllSchedule(String author, int sem, int year) {
        final MutableLiveData<List<ResponSession>> schedules = new MutableLiveData<>();
        retrofit.getAllSchedule(author,sem,year, new OnRetrofitResult<List<ResponSession>>() {
            @Override
            public void onSuccess(List<ResponSession> result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<List<Room>> GetSRoom(String author) {
        final MutableLiveData<List<Room>> schedules = new MutableLiveData<>();
        retrofit.GetRoom(author, new OnRetrofitResult<List<Room>>() {
            @Override
            public void onSuccess(List<Room> result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<ResponseBody> UpdateNotify(String author, RequestNotify requestNotify) {
        final MutableLiveData<ResponseBody> schedules = new MutableLiveData<>();
        retrofit.UpdateNotify(author, requestNotify, new OnRetrofitResult<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<ResponseBody> PostStudent(String author, RequestStudent requestNotify) {
        final MutableLiveData<ResponseBody> schedules = new MutableLiveData<>();
        retrofit.PostStudent(author, requestNotify, new OnRetrofitResult<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<ResponseBody> PostSchedule(String author, RequestSession requestNotify) {
        final MutableLiveData<ResponseBody> schedules = new MutableLiveData<>();
        retrofit.PostSchedule(author, requestNotify, new OnRetrofitResult<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<ResponseBody> UpdateSchedule(String author, RequestSession requestNotify) {
        final MutableLiveData<ResponseBody> schedules = new MutableLiveData<>();
        retrofit.UpdateSchedule(author, requestNotify, new OnRetrofitResult<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<ResponseBody> PostClass(String author, RequestClass requestNotify) {
        final MutableLiveData<ResponseBody> schedules = new MutableLiveData<>();
        retrofit.PostClass(author, requestNotify, new OnRetrofitResult<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<ResponseBody> UpdateStudent(String author, RequestStudent requestNotify) {
        final MutableLiveData<ResponseBody> schedules = new MutableLiveData<>();
        retrofit.UpdateStudent(author, requestNotify, new OnRetrofitResult<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<ResponseBody> PostTeacher(String author, RequestTeacher requestNotify) {
        final MutableLiveData<ResponseBody> schedules = new MutableLiveData<>();
        retrofit.PostTeacher(author, requestNotify, new OnRetrofitResult<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<ResponseBody> UpdateTeacher(String author, RequestTeacher requestNotify) {
        final MutableLiveData<ResponseBody> schedules = new MutableLiveData<>();
        retrofit.UpdateTeacher(author, requestNotify, new OnRetrofitResult<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<List<ClassName>> GetAllClass(String author, int  year) {
        final MutableLiveData<List<ClassName>> schedules = new MutableLiveData<>();
        retrofit.getAllClass(author, year, new OnRetrofitResult<List<ClassName>>() {
            @Override
            public void onSuccess(List<ClassName> result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<List<Student>> getAllStudent(String author, int  year) {
        final MutableLiveData<List<Student>> schedules = new MutableLiveData<>();
        retrofit.getAllStudent(author, year, new OnRetrofitResult<List<Student>>() {
            @Override
            public void onSuccess(List<Student> result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<List<Notification>> getAllNotify(String author) {
        final MutableLiveData<List<Notification>> schedules = new MutableLiveData<>();
        retrofit.getAllNotify(author, new OnRetrofitResult<List<Notification>>() {
            @Override
            public void onSuccess(List<Notification> result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<List<Teacher>> GetAllTeacher(String author) {
        final MutableLiveData<List<Teacher>> schedules = new MutableLiveData<>();
        retrofit.GetAllTeacher(author, new OnRetrofitResult<List<Teacher>>() {
            @Override
            public void onSuccess(List<Teacher> result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<List<Subject>> GetAllSubject(String author) {
        final MutableLiveData<List<Subject>> schedules = new MutableLiveData<>();
        retrofit.getAllSubject(author, new OnRetrofitResult<List<Subject>>() {
            @Override
            public void onSuccess(List<Subject> result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<List<Subject>> GetAllSubjectByTeacher(String author) {
        final MutableLiveData<List<Subject>> schedules = new MutableLiveData<>();
        retrofit.GetAllSubjectByTeacher(author, new OnRetrofitResult<List<Subject>>() {
            @Override
            public void onSuccess(List<Subject> result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(int code, @Nullable ResponseBody errorBody) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
}