package tkpm.doan.student.injection;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import tkpm.doan.student.data.models.Grade;
import tkpm.doan.student.data.models.Student;

@InstallIn(ApplicationComponent.class)
@Module
public class LiveDataModule {

    @Provides
    MutableLiveData<List<Grade>> provideGradeLiveData(List<Grade> grades) {
        return new MutableLiveData<>(grades);
    }

    @Provides
    MutableLiveData<List<Student>> provideStudentLiveData(List<Student> students) {
        return new MutableLiveData<>(students);
    }
}
