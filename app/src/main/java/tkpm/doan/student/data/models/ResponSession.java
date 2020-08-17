package tkpm.doan.student.data.models;

import androidx.annotation.Nullable;

public class ResponSession implements Comparable<ResponSession>{
    private int SessionId;
    private int SubjectId;
    private String ClassId;
    private String TeacherId;
    private int DayOfWeek;
    private int Semester;
    private int AcademicYear;
    private String SubjectName;
    private int period;
    private String LastName;
    private String MiddleName;
    private String FirstName;

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

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


    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(obj instanceof ResponSession)) {
            return false;
        }
        // typecast o to Complex so that we can compare data members
        ResponSession value = (ResponSession) obj;
        if(this.getSessionId()==value.getSessionId()&&this.getTeacherId().equals(value.getTeacherId())&&
        this.getDayOfWeek()==value.getDayOfWeek()&&this.getAcademicYear()==value.getAcademicYear()&&
                this.getSemester()==value.getSemester())
        {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(ResponSession session) {
        return Integer.compare(this.DayOfWeek,session.DayOfWeek);
    }
}
