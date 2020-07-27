package tkpm.doan.student.data.injection;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;
import dagger.multibindings.ElementsIntoSet;
import dagger.multibindings.IntoSet;
import tkpm.doan.student.MainApplication;
import tkpm.doan.student.data.models.Subject;

@Module @InstallIn(FragmentComponent.class)
public class ScheduleModule {
    private static DayOfWeek[] dayOfWeeks = DayOfWeek.values();

    @Provides
    static DayOfWeek provideDayOfWeek() {
        Random random = new Random();
        return dayOfWeeks[random.nextInt(dayOfWeeks.length)];
    }

    @Provides
    static Collection<Subject> provideSubjects() {
        return Collections.emptyList();
    }

}
