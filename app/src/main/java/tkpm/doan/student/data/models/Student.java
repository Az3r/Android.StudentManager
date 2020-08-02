package tkpm.doan.student.data.models;

import java.util.List;

import javax.inject.Inject;

public class Student {
    @Inject
    public Student() {
    }

    private String studentId;
    private String studentName;
    private String address;

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void assign(Student result) {
        this.studentId = result.getStudentId();
    }

    private List<Schedule> schedules;
    private List<Score> scores;
}
