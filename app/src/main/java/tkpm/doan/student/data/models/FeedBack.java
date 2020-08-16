package tkpm.doan.student.data.models;

public class FeedBack {
    private String StudentId;
    private String Feedback;
    private float Semester;
    private float AcademicYear;


    // Getter Methods

    public String getStudentId() {
        return StudentId;
    }

    public String getFeedback() {
        return Feedback;
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

    public void setFeedback(String Feedback) {
        this.Feedback = Feedback;
    }

    public void setSemester(float Semester) {
        this.Semester = Semester;
    }

    public void setAcademicYear(float AcademicYear) {
        this.AcademicYear = AcademicYear;
    }
}
