package tkpm.doan.student.data.models;

import androidx.annotation.NonNull;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Represent a timetable of a specific day
 */
public class Schedule {

    private final DayOfWeek dateOfWeek;

    private final ArrayList<Lesson> lessons = new ArrayList<>();

    @Inject
    public Schedule(DayOfWeek dateOfWeek, @NonNull Collection<Lesson> lessons) {
        this.dateOfWeek = dateOfWeek;
        this.lessons.addAll(lessons);
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
