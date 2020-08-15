package tkpm.doan.student.injection;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import tkpm.doan.student.data.models.Comment;
import tkpm.doan.student.data.models.Grade;
import tkpm.doan.student.data.models.Notification;
import tkpm.doan.student.data.models.Schedule;
import tkpm.doan.student.data.models.Score;
import tkpm.doan.student.data.models.Session;
import tkpm.doan.student.data.models.Student;
import tkpm.doan.student.data.models.TeacherSchedule;

@InstallIn(ApplicationComponent.class)
@Module
public class CollectionModule {

    private static DayOfWeek[] dayOfWeeks = DayOfWeek.values();

    @Provides
    static int provideInteger() {
        return 1;
    }

    @Provides
    static boolean provideBooleans() {
        return false;
    }

    @Provides
    String provideString() {
        return "Subject's name";
    }

    @Provides
    static List<Comment> provideComments(Comment comment) {
        return Arrays.asList(comment, comment, comment, comment, comment);
    }
    @Provides
    static List<Session> provideLessons(Session lesson) {
        return Arrays.asList(lesson, lesson, lesson, lesson, lesson);
    }
    @Provides
    static List<Notification> provideNotifications(Notification notification) {
        return Arrays.asList(notification, notification, notification);
    }


    @Provides
    static DayOfWeek provideDayOfWeek() {
        Random random = new Random();
        return dayOfWeeks[random.nextInt(dayOfWeeks.length)];
    }

    @Provides
    static List<Schedule> provideSchedules(Schedule schedule) {
        return Arrays.asList(schedule, schedule, schedule, schedule, schedule, schedule, schedule);
    }

    @Provides
    static List<Score> provideScores(Score score) {
        return Arrays.asList(score, score, score, score);
    }

    @Provides
    static List<Grade> provideGrades(Grade grade) {
        return Arrays.asList(grade, grade, grade, grade, grade, grade);
    }

    @Provides
    static List<Student> provideStudents(Student student) {
        return Arrays.asList(student, student, student, student, student, student, student, student, student, student);
    }

    @Provides
    static List<TeacherSchedule> provideTeacherSchedule(TeacherSchedule teacherSchedule) {
        return Arrays.asList(teacherSchedule, teacherSchedule, teacherSchedule, teacherSchedule, teacherSchedule, teacherSchedule, teacherSchedule);
    }
}
