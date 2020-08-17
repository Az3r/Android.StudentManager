package tkpm.doan.student.data.models;

import java.util.Date;

public class PersonalInfo {
    private String PersonalInfoId;
    private String StudentId;
    private String RoleName;
    private String TeacherId;
    private String SubjectName;
    private String SubjectId;
    private boolean IsGraduated;
    private String Address;
    private String LastName;
    private String MiddleName;
    private String FirstName;
    private String Email;
    private String PhoneNumber;
    private boolean IsMale;
    private Date Birthday;
    private String ClassId;
    private int PersonTypeID;
    private int PersonTypeId;
    // Getter Methods

    public String getPersonalInfoId() {
        return PersonalInfoId;
    }

    public void setPersonalInfoId(String personalInfoId) {
        PersonalInfoId = personalInfoId;
    }

    public int getPersonTypeId() {
        return PersonTypeId;
    }

    public void setPersonTypeId(int personTypeId) {
        PersonTypeId = personTypeId;
    }

    public int getPersonTypeID() {
        return PersonTypeID;
    }

    public void setPersonTypeID(int personTypeID) {
        PersonTypeID = personTypeID;
    }

    public String getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(String subjectId) {
        SubjectId = subjectId;
    }

    public String getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(String teacherId) {
        TeacherId = teacherId;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public boolean isGraduated() {
        return IsGraduated;
    }

    public void setGraduated(boolean graduated) {
        IsGraduated = graduated;
    }

    public boolean isMale() {
        return IsMale;
    }

    public void setMale(boolean male) {
        IsMale = male;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public String getStudentId() {
        return StudentId;
    }

    public boolean getIsGraduated() {
        return IsGraduated;
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

    public String getClassId() {
        return ClassId;
    }

    // Setter Methods

    public void setStudentId(String StudentId) {
        this.StudentId = StudentId;
    }

    public void setIsGraduated(boolean IsGraduated) {
        this.IsGraduated = IsGraduated;
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

    public void setClassId(String ClassId) {
        this.ClassId = ClassId;
    }
}