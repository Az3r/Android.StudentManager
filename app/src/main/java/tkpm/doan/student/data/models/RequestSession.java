package tkpm.doan.student.data.models;

public class RequestSession {
    private int SessionId;
    private int SubjectId;
    private String ClassId;
    private String TeacherId;
    private int DayOfWeek;
    private int Semester;
    private int AcademicYear;


    public int getSessionId() {
        return SessionId;
    }

    public void setSessionId(int sessionId) {
        SessionId = sessionId;
    }

    public int getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(int subjectId) {
        SubjectId = subjectId;
    }

    public String getClassId() {
        return ClassId;
    }

    public void setClassId(String classId) {
        ClassId = classId;
    }

    public String getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(String teacherId) {
        TeacherId = teacherId;
    }

    public int getDayOfWeek() {
        return DayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        DayOfWeek = dayOfWeek;
    }

    public int getSemester() {
        return Semester;
    }

    public void setSemester(int semester) {
        Semester = semester;
    }

    public int getAcademicYear() {
        return AcademicYear;
    }

    public void setAcademicYear(int academicYear) {
        AcademicYear = academicYear;
    }
}
