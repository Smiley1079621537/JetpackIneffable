package grace.immanuel.ineffable.workmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class TimeCountAddWorker extends Worker {
    public static final String TAG_ADD = "ADD_TAG";
    public static final String ARG_TIME = "TIME";
    public int time = 0;

    public TimeCountAddWorker(@NonNull Context context,
                              @NonNull WorkerParameters workerParams) {
        super(context, workerParams);

    }

    /**
     * 耗时任务在doWork()方法中执行
     */
    @NonNull
    @Override
    public Result doWork() {
        time += 300;
        Data outputData = new Data.Builder()
                .putInt(ARG_TIME, time).build();
        return Result.success(outputData);
    }
}