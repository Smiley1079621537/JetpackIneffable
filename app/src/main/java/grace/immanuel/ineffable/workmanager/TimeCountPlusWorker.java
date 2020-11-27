package grace.immanuel.ineffable.workmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class TimeCountPlusWorker extends Worker {
    public static final String TAG_PLUS = "PLUS_TAG";
    public static final String ARG_TIME = "TIME";
    public int time = 0;

    public TimeCountPlusWorker(@NonNull Context context,
                               @NonNull WorkerParameters workerParams) {
        super(context, workerParams);

    }

    /**
     * 耗时任务在doWork()方法中执行
     */
    @NonNull
    @Override
    public Result doWork() {
        time += 100;
        Data outputData = new Data.Builder()
                .putInt(ARG_TIME, time).build();
        return Result.success(outputData);
    }
}