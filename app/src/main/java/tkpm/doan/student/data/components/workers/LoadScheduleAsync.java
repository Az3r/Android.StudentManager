package tkpm.doan.student.data.components.workers;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import tkpm.doan.student.data.models.Schedule;

public class LoadScheduleAsync extends FutureTask<Schedule> {
    public LoadScheduleAsync(Callable<Schedule> callable) {
        super(callable);
    }
}
