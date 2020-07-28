package tkpm.doan.student.injection;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@InstallIn(ActivityComponent.class)
@Module
public class SubjectModule {
    @Provides
    String provideString() {
        return "Subject's name";
    }
}
