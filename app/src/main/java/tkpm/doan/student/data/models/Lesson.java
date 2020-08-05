package tkpm.doan.student.data.models;

import androidx.annotation.NonNull;

import javax.inject.Inject;

public class Lesson {
    private int position;
    private int startTime;
    private int endTime;
    private Subject subject;

    @Inject
    public Lesson(int position, int startTime, int endTime, Subject subject) {
        this.position = position;
        this.startTime = startTime;
        this.endTime = endTime;
        this.subject = subject;
    }

    @NonNull
    @Override
    public String toString() {
        return "Period{" +
                "index=" + position +
                ", subject=" + subject +
                '}';
    }

    public int getPosition() {
        return position;
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
