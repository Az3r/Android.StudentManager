package tkpm.doan.student.injection;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import tkpm.doan.student.data.models.Schedule;

@Module
@InstallIn(ApplicationComponent.class)
public class ScheduleModule {
    private static DayOfWeek[] dayOfWeeks = DayOfWeek.values();

    @Provides
    static DayOfWeek provideDayOfWeek() {
        Random random = new Random();
        return dayOfWeeks[random.nextInt(dayOfWeeks.length)];
    }

    @Provides
    static List<Schedule> provideSchedules(Schedule schedule) {
        return Arrays.asList(schedule, schedule, schedule, schedule, schedule, schedule, schedule);
    }
}
