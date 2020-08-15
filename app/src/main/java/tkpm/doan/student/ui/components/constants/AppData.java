package tkpm.doan.student.ui.components.constants;

import android.accounts.Account;

import java.util.List;

import tkpm.doan.student.data.models.PersonalInfo;
import tkpm.doan.student.data.models.Student;

public class AppData {
    private static AppData instance = new AppData();
    public Account account;
    public List<Student> studentList;
    public PersonalInfo personalInfo;

    private AppData() {

    }
    public static AppData getInstance() {
        return instance;
    }


}
