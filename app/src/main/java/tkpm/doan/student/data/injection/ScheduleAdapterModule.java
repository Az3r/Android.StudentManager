package tkpm.doan.student.data.injection;

import android.app.Application;
import android.content.Context;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.multibindings.ElementsIntoSet;
import tkpm.doan.student.data.models.Schedule;

@InstallIn(ApplicationComponent.class)
@Module
public class ScheduleAdapterModule {

    @Provides
    Context provideContext(@ApplicationContext Context context) {
        return context;
    }

    @Provides
    Collection<Schedule> provideSchedules() {
        return Collections.emptyList();
    }

}
