package tkpm.doan.student.data.models;

import androidx.annotation.NonNull;

import javax.inject.Inject;

public class Lesson {
    private int index;
    private int startTime;
    private int endTime;
    private Subject subject;

    @Inject
    public Lesson(int index, int startTime, int endTime, Subject subject) {
        this.index = index;
        this.startTime = startTime;
        this.endTime = endTime;
        this.subject = subject;
    }

    @NonNull
    @Override
    public String toString() {
        return "Period{" +
                "index=" + index +
                ", subject=" + subject +
                '}';
    }

    public int getIndex() {
        return index;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public Subject getSubject() {
        return subject;
    }
}
