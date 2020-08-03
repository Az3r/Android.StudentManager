package tkpm.doan.student.data.models;

import java.util.List;

import javax.inject.Inject;

public class Student {
    @Inject
    public Student() {
    }

    private PersonalInfo personalInfo;
    private List<Schedule> schedules;
    private List<Score> scores;
    private List<Notification> notifications;
}
