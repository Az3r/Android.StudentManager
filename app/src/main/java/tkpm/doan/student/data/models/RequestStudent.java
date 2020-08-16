package tkpm.doan.student.data.models;

import java.util.Date;
public class RequestStudent {
    private String StudentId;
    private int IsGraduated;
    private String Address;
    private String LastName;
    private String MiddleName;
    private String FirstName;
    private String Email;
    private String PhoneNumber;
    private int IsMale;
    private Date Birthday;
    private String ClassId;

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public int isGraduated() {
        return IsGraduated;
    }

    public void setGraduated(int graduated) {
        IsGraduated = graduated;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int isMale() {
        return IsMale;
    }

    public void setMale(int male) {
        IsMale = male;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public String getClassId() {
        return ClassId;
    }

    public void setClassId(String classId) {
        ClassId = classId;
    }
}
