package tkpm.doan.student.data.models;

import javax.inject.Inject;

public class Teacher {


    public Byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(Byte[] avatar) {
        this.avatar = avatar;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMidleName() {
        return MidleName;
    }

    public void setMidleName(String midleName) {
        MidleName = midleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    private Byte[] avatar;
    private String FirstName;
    private  String MidleName;
    private String LastName;

    @Inject
    public Teacher() {



    }
}
