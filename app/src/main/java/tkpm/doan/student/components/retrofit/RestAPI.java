package tkpm.doan.student.components.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import tkpm.doan.student.data.models.Schedule;

public interface RestAPI {
    Object getStudentDetail();

}
