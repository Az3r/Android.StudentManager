package tkpm.doan.student.data.models;

import androidx.annotation.NonNull;

import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

public class Schedule {

    private final DayOfWeek dateOfWeek;
    private final ArrayList<Subject> subjects = new ArrayList<>();

    @Inject
    public Schedule(DayOfWeek dateOfWeek, @NonNull Collection<Subject> subjects) {
        this.dateOfWeek = dateOfWeek;
        this.subjects.addAll(subjects);
    }

    public DayOfWeek getDateOfWeek() {
        return dateOfWeek;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    @Override
    @NonNull
    public String toString() {
        return "Schedule{" +
                "dateOfWeek=" + dateOfWeek +
                ", number of subjects=" + subjects.size() +
                '}';
    }

    /**
     * convert date of week value to its string representation
     */
    public String dateToString() {
        return "Monday";
    }
}
