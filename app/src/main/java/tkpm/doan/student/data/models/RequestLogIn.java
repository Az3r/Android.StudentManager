package tkpm.doan.student.data.models;

public class RequestLogIn {
    private String PersonalInfoId;
    private String Password;

    public String getPersonalInfoId() {
        return PersonalInfoId;
    }

    public void setPersonalInfoId(String personalInfoId) {
        PersonalInfoId = personalInfoId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
