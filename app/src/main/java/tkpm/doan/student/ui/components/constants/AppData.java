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
    public  String STUDENT_ID = "1140713";
    public  String SubjectId = "1";
    public  int sem =1;
    public  int year=2020;
    public  boolean IS_TEACHER = true;
    public  String SELECTED_GRADE = "selectedGrade";
    public  String TEACHER_ID = "0000001";
    public  String userName="";
    public  String token ="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJQZXJzb25hbEluZm9JZCI6IjExNDA3MTMiLCJpYXQiOjE1OTY2NDAzMjZ9.9AfpzodHycw3c_b46A3RmyuvyYAMb18orlY1p-BM3Zw";
    public  String BUNDLE_BOTTOM_NAV_VISIBLE = "bottomNavVisible";
    private AppData() {

    }
    public static AppData getInstance() {
        return instance;
    }


}
