package tkpm.doan.student.data.components.retrofit;


import android.util.Log;

import androidx.annotation.Nullable;

import okhttp3.ResponseBody;

public abstract class OnRetrofitResult<T> {
    private static final String TAG = OnRetrofitResult.class.getName();

    /**
     * occurs when successfully receive data from server (http code 2xx)
     */
    public abstract void onSuccess(T result);

    /**
     * occurs when server response with failure http codes (4xx, 5xx)
     *
     * @param errorBody: contains an error message about why the request is failure
     */
    void onFailure(int code, @Nullable ResponseBody errorBody) {
        String error;
        try {
            error = errorBody.string();
        } catch (Exception e) {
            error = "Unknow error";
        }
        Log.e(TAG, "Server responsed with failure http status code (4xx, 5xx)");
        Log.e(TAG, String.format("%d: %s", code, error));
    }

    /**
     * occurs when retrofit is unable to make request to server
     */
    void onError(Throwable t) {
        Log.e(TAG, "An error occurred when retrofit made a request to server");
        String error = t.getMessage() != null ? t.getMessage() : "Unknow error";
        Log.e(TAG, "Cause: " + error);
    }
}
