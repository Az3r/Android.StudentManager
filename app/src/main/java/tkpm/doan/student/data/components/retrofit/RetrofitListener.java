package tkpm.doan.student.data.components.retrofit;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class RetrofitListener<T> implements Callback<T> {
    @NonNull
    private OnRetrofitResult<T> callback;

    public RetrofitListener(@NonNull OnRetrofitResult<T> callback) {
        this.callback = callback;
    }

    @Override
    @EverythingIsNonNull
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) callback.onSuccess(response.body());
        else callback.onFailure(response.code(), response.errorBody());
    }

    @Override
    @EverythingIsNonNull
    public void onFailure(Call<T> call, Throwable t) {
        callback.onError(t);
    }
}
