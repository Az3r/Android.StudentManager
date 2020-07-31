package tkpm.doan.student.injection;

import java.util.Arrays;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import tkpm.doan.student.data.models.Notification;

@Module
@InstallIn(ApplicationComponent.class)
public class NotificationModule {
    @Provides
    List<Notification> provideNotifications(Notification notification) {
        return Arrays.asList(notification, notification, notification);
    }

    @Provides
    boolean provideBooleans() {
        return false;
    }


}
