package tkpm.doan.student.data.models;

import androidx.annotation.NonNull;

import javax.inject.Inject;

public class Subject {

    private int SubjectId;
    private String SubjectName;

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
