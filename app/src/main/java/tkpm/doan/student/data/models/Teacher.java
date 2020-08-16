package tkpm.doan.student.data.models;

import java.util.Date;

public class Teacher {
    private String TeacherId;
    private String RoleName;
    private float SubjectId;
    private String SubjectName;
    private String Address;
    private String LastName;
    private String MiddleName;
    private String FirstName;
    private String Email;
    private String PhoneNumber;
    private boolean IsMale;
    private Date Birthday;


    // Getter Methods

    public String getTeacherId() {
        return TeacherId;
    }

    public String getRoleName() {
        return RoleName;
    }

    public float getSubjectId() {
        return SubjectId;
    }

    public String getSubjectName() {
        return SubjectName;
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

    public boolean getIsMale() {
        return IsMale;
    }

    public Date getBirthday() {
        return Birthday;
    }

    // Setter Methods

    public void setTeacherId(String TeacherId) {
        this.TeacherId = TeacherId;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }

    public void setSubjectId(float SubjectId) {
        this.SubjectId = SubjectId;
    }

    public void setSubjectName(String SubjectName) {
        this.SubjectName = SubjectName;
    }

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

    public void setIsMale(boolean IsMale) {
        this.IsMale = IsMale;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }
}