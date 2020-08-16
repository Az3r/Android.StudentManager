package tkpm.doan.student.data.models;

import java.util.ArrayList;
import java.util.List;

public class ScoreRequest {
    private String StudentId;
    private float SubjectId;
    List< Float > Test15 = new ArrayList < Float > ();
    List < Float > Test45 = new ArrayList < Float > ();
    private float TestFinal;
    private float Semester;
    private float AcademicYear;

    // Getter Methods

    public List<Float> getTest15() {
        return Test15;
    }

    public void setTest15(List<Float> test15) {
        Test15 = test15;
    }

    public List<Float> getTest45() {
        return Test45;
    }

    public void setTest45(List<Float> test45) {
        Test45 = test45;
    }

    public String getStudentId() {
        return StudentId;
    }

    public float getSubjectId() {
        return SubjectId;
    }

    public float getTestFinal() {
        return TestFinal;
    }

    public float getSemester() {
        return Semester;
    }

    public float getAcademicYear() {
        return AcademicYear;
    }

    // Setter Methods

    public void setStudentId(String StudentId) {
        this.StudentId = StudentId;
    }

    public void setSubjectId(float SubjectId) {
        this.SubjectId = SubjectId;
    }

    public void setTestFinal(float TestFinal) {
        this.TestFinal = TestFinal;
    }

    public void setSemester(float Semester) {
        this.Semester = Semester;
    }

    public void setAcademicYear(float AcademicYear) {
        this.AcademicYear = AcademicYear;
    }
}