package tkpm.doan.student.data.components.retrofit;


import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import okhttp3.ResponseBody;
import tkpm.doan.student.ui.MainActivity;
import tkpm.doan.student.ui.launch.LoggedUserViewModel;
import tkpm.doan.student.ui.manager.ManagerViewModel;

public abstract class OnRetrofitResult<T> {
    private static final String TAG = OnRetrofitResult.class.getName();
    /**
     * occurs when successfully receive data from server (http code 2xx)
     */
    public abstract void onSuccess(T result);
    public abstract void onFailure(int code, @Nullable ResponseBody errorBody);


}
