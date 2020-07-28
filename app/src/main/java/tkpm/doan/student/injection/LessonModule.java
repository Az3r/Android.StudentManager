package tkpm.doan.student.injection;

import java.util.Arrays;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import tkpm.doan.student.data.models.Lesson;

@Module
@InstallIn(ActivityComponent.class)
public class LessonModule {

    @Provides
    static int provideInteger() {
        return 1;
    }

    @Provides
    static List<Lesson> provideLessons(Lesson lesson) {
        return Arrays.asList(lesson, lesson, lesson, lesson, lesson);
    }
}
