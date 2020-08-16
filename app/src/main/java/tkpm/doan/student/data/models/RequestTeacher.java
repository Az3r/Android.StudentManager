package tkpm.doan.student.data.models;

import java.util.Date;

public class RequestTeacher {
    private String TeacherId;
    private String Address;
    private String LastName;
    private String MiddleName;
    private String FirstName;
    private String Email;
    private String PhoneNumber;
    private int IsMale;
    private Date Birthday;
    private float SubjectId;


    // Getter Methods

    public String getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(String teacherId) {
        TeacherId = teacherId;
    }

    public String getAddress() {
        return Address;
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

    public String getEmail() {
        return Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public int getIsMale() {
        return IsMale;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public float getSubjectId() {
        return SubjectId;
    }

    // Setter Methods

    public void setAddress(String Address) {
        this.Address = Address;
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

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setIsMale(int IsMale) {
        this.IsMale = IsMale;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    public void setSubjectId(float SubjectId) {
        this.SubjectId = SubjectId;
    }
}