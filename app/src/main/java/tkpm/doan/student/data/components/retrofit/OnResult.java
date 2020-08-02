package tkpm.doan.student.data.components.retrofit;

public interface OnResult<T> {
    void onSuccess(T result);
    void onFailure(Exception error);
}
