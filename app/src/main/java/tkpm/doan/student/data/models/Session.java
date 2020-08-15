package tkpm.doan.student.data.models;
public class Session implements Comparable<Session> {
    private float SessionId;
    private String BeginTime;
    private String EndTime;
    private String SubjectName;
    private String ClassId;
    private String RoomName;
    private float DayOfWeek;
    private float Semester;
    private float AcademicYear;
    private int period;

    // Getter Methods
    public float getSemester() {
        return Semester;
    }

    public void setSemester(float semester) {
        Semester = semester;
    }

    public float getAcademicYear() {
        return AcademicYear;
    }

    public void setAcademicYear(float academicYear) {
        AcademicYear = academicYear;
    }
    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public float getSessionId() {
        return SessionId;
    }

    public String getBeginTime() {
        return BeginTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public String getClassId() {
        return ClassId;
    }

    public String getRoomName() {
        return RoomName;
    }

    public float getDayOfWeek() {
        return DayOfWeek;
    }

    // Setter Methods

    public void setSessionId(float SessionId) {
        this.SessionId = SessionId;
    }
    public void setBeginTime(String BeginTime) {
        this.BeginTime = BeginTime;
    }
    public void setEndTime(String EndTime) {
        this.EndTime = EndTime;
    }
    public void setSubjectName(String SubjectName) {
        this.SubjectName = SubjectName;
    }
    public void setClassId(String ClassId) {
        this.ClassId = ClassId;
    }
    public void setRoomName(String RoomName) {
        this.RoomName = RoomName;
    }
    public void setDayOfWeek(float DayOfWeek) {
        this.DayOfWeek = DayOfWeek;
    }
    @Override
    public int compareTo(Session session) {
        return Float.compare(this.DayOfWeek,session.DayOfWeek);
    }
}