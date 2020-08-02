package tkpm.doan.student.data.repositories;

import java.util.List;

import retrofit2.converter.gson.GsonConverterFactory;
import tkpm.doan.student.data.components.retrofit.OnResult;
import tkpm.doan.student.data.components.retrofit.RetrofitService;
import tkpm.doan.student.data.models.Score;
import tkpm.doan.student.data.models.Student;

public class StudentRepository {
    private RetrofitService retrofit = new RetrofitService();

    public StudentRepository() {
    }

    public StudentRepository(RetrofitService retrofit) {
        this.retrofit = retrofit;
    }

    public void getStudent(String id, OnResult<Student> callback) {
        retrofit.getStudentProfile(id, callback);
    }

    public void getScore(String id, int semester, int year, OnResult<List<Score>> callback) {
        retrofit.getScore(id, semester, year, callback);
    }
}
