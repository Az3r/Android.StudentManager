package tkpm.doan.student.data.models;

import androidx.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

public class Subject {
    private int SubjectId;
    private String SubjectName;
    private List<Teacher> Teachers;

    public List<Teacher> getTeachers() {
        return Teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        Teachers = teachers;
    }

    public int getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(int subjectId) {
        SubjectId = subjectId;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }
}
