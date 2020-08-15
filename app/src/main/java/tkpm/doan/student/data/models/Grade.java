package tkpm.doan.student.data.models;

import javax.inject.Inject;

public class Grade {

    public String getClassId() {
        return ClassId;
    }

    public void setClassId(String classId) {
        ClassId = classId;
    }

    public int getSumStudent() {
        return SumStudent;
    }

    public void setSumStudent(int sumStudent) {
        SumStudent = sumStudent;
    }

    public String getHomeroomTeacherName() {
        return HomeroomTeacherName;
    }

    public void setHomeroomTeacherName(String homeroomTeacherName) {
        HomeroomTeacherName = homeroomTeacherName;
    }

    private String ClassId;
    private int SumStudent;
    private String HomeroomTeacherName;



    public Grade() {

    }
}
