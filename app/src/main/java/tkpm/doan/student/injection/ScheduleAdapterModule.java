package tkpm.doan.student.injection;

import android.content.Context;

import java.util.Arrays;
import java.util.Collection;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ActivityContext;
import dagger.hilt.android.qualifiers.ApplicationContext;
import tkpm.doan.student.data.models.Schedule;

@InstallIn(ActivityComponent.class)
@Module
public class ScheduleAdapterModule {

    @Provides
    Context provideContext(@ActivityContext Context context) {
        return context;
    }

    @Provides
    Collection<Schedule> provideSchedules(Schedule schedule) {
        return Arrays.asList(schedule, schedule, schedule, schedule, schedule, schedule, schedule);
    }

}
