package tkpm.doan.student.data.repositories;

import androidx.annotation.NonNull;
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
import tkpm.doan.student.data.models.RequestNotify;
import tkpm.doan.student.data.models.RequestStudent;
import tkpm.doan.student.data.models.RequestTeacher;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.data.models.Subject;

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
            public void onFailure(ResponseBody result) {
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
            public void onFailure(ResponseBody result) {
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
            public void onFailure(ResponseBody result) {
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
            public void onFailure(ResponseBody result) {
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
            public void onFailure(ResponseBody result) {
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
            public void onFailure(List<ClassName> result) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
    public LiveData<List<RequestStudent>> getAllStudent(String author, int  year) {
        final MutableLiveData<List<RequestStudent>> schedules = new MutableLiveData<>();
        retrofit.getAllStudent(author, year, new OnRetrofitResult<List<RequestStudent>>() {
            @Override
            public void onSuccess(List<RequestStudent> result) {
                schedules.postValue(result);
            }
            @Override
            public void onFailure(List<RequestStudent> result) {
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
            public void onFailure(List<Notification> result) {
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
            public void onFailure(List<Subject> result) {
                schedules.postValue(null);
            }
        });
        return schedules;
    }
}