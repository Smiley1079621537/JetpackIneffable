package grace.immanuel.ineffable;

import android.app.Application;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;

import androidx.lifecycle.ProcessLifecycleOwner;
import grace.immanuel.ineffable.lifecycle.ApplicationObserver;

public class IneffableApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new ApplicationObserver());
        LogUtils.getConfig().setLogSwitch(false);
    }
}
