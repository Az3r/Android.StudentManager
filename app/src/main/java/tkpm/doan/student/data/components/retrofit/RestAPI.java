package tkpm.doan.student.data.components.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import tkpm.doan.student.data.models.Student;

public interface RestAPI {

    @GET("/api/student/single/{id}")
    Call<Student> getStudent(@Path("id") String id);
}
