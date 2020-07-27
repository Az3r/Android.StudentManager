package tkpm.doan.student.data.models;

import androidx.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

public class Schedule {

    private final int dateOfWeek;
    private final List<Subject> subjects;

    @Inject
    public Schedule(int dateOfWeek, @NonNull List<Subject> subjects) {
        this.dateOfWeek = dateOfWeek;
        this.subjects = subjects;
    }

    public int getDateOfWeek() {
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
