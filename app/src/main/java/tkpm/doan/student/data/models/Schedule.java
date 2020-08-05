package tkpm.doan.student.data.models;

import androidx.annotation.NonNull;

import java.time.DayOfWeek;
import java.util.List;

import javax.inject.Inject;

/**
 * Represent a timetable of a specific day
 */
public class Schedule {

    private final DayOfWeek dateOfWeek;

    @NonNull
    private final List<Lesson> lessons;

    @Inject
    public Schedule(DayOfWeek dateOfWeek, @NonNull List<Lesson> lessons) {
        this.dateOfWeek = dateOfWeek;
        this.lessons = lessons;
    }

    public DayOfWeek getDateOfWeek() {
        return dateOfWeek;
    }

    @NonNull
    public List<Lesson> getLessons() {
        return lessons;
    }

    @Override
    @NonNull
    public String toString() {
        return "Schedule{" +
                "dateOfWeek=" + dateOfWeek +
                ", number of subjects=" + lessons.size() +
                '}';
    }

    /**
     * convert date of week value to its string representation
     */
    public String dateToString() {
        return "Monday";
    }
}
