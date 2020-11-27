package grace.immanuel.ineffable.lifecycle;

import com.blankj.utilcode.util.LogUtils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class IneffableServerObserver implements LifecycleObserver {

    private final String TAG = this.getClass().getName();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void startServer() {
        LogUtils.dTag(TAG, "startServer");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void stopServer() {
        LogUtils.dTag(TAG, "stopServer");
    }
}
