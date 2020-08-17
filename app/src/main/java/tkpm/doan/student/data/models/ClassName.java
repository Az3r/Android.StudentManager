package tkpm.doan.student.data.models;

public class ClassName
{
    private String ClassId;
    private String ClassName;
    private String RoomId;
    private String RoomName;
    private String PersonalInfoId = null;
    private String LastName = null;
    private String MiddleName = null;
    private String FirstName = null;
    private String SumStudent = null;
    private String AcademicYear = null;


    // Getter Methods

    public String getClassId() {
        return ClassId;
    }

    public String getClassName() {
        return ClassName;
    }

    public String getRoomId() {
        return RoomId;
    }

    public String getRoomName() {
        return RoomName;
    }

    public String getPersonalInfoId() {
        return PersonalInfoId;
    }

    public String getLastName() {
        return LastName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getSumStudent() {
        return SumStudent;
    }

    public String getAcademicYear() {
        return AcademicYear;
    }

    // Setter Methods

    public void setClassId(String ClassId) {
        this.ClassId = ClassId;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public void setRoomId(String RoomId) {
        this.RoomId = RoomId;
    }

    public void setRoomName(String RoomName) {
        this.RoomName = RoomName;
    }

    public void setPersonalInfoId(String PersonalInfoId) {
        this.PersonalInfoId = PersonalInfoId;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setSumStudent(String SumStudent) {
        this.SumStudent = SumStudent;
    }

    public void setAcademicYear(String AcademicYear) {
        this.AcademicYear = AcademicYear;
    }
}