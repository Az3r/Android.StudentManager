package tkpm.doan.student.ui.manager;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class ManagerViewModel extends ViewModel {

    private SavedStateHandle savedStateHandle;

    @ViewModelInject
    public ManagerViewModel(@Assisted SavedStateHandle savedStateHandle) {

    }
}
