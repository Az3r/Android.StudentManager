package tkpm.doan.student.data.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
    private String ClassId;
    private String StudentId;
    private String LastName;
    private String MiddleName;
    private String FirstName;
    private Date Birthday;
    private String Address;
    private boolean IsMale;
    private String PhoneNumber;
    List< Float > Test15 = new ArrayList < Float > ();
    List < Float > Test45 = new ArrayList < Float > ();

    public boolean isMale() {
        return IsMale;
    }

    public void setMale(boolean male) {
        IsMale = male;
    }

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

    private float TestFinal;
    private float Final;
    private float Semester;
    private float AcademicYear;


    // Getter Methods

    public String getClassId() {
        return ClassId;
    }

    public String getStudentId() {
        return StudentId;
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

    public Date getBirthday() {
        return Birthday;
    }

    public String getAddress() {
        return Address;
    }

    public boolean getIsMale() {
        return IsMale;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public float getTestFinal() {
        return TestFinal;
    }

    public float getFinal() {
        return Final;
    }

    public float getSemester() {
        return Semester;
    }

    public float getAcademicYear() {
        return AcademicYear;
    }

    // Setter Methods

    public void setClassId(String ClassId) {
        this.ClassId = ClassId;
    }

    public void setStudentId(String StudentId) {
        this.StudentId = StudentId;
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

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setIsMale(boolean IsMale) {
        this.IsMale = IsMale;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setTestFinal(float TestFinal) {
        this.TestFinal = TestFinal;
    }

    public void setFinal(float Final) {
        this.Final = Final;
    }

    public void setSemester(float Semester) {
        this.Semester = Semester;
    }

    public void setAcademicYear(float AcademicYear) {
        this.AcademicYear = AcademicYear;
    }
}