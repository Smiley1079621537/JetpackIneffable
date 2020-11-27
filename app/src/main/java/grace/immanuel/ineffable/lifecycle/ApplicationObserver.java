package grace.immanuel.ineffable.lifecycle;

import com.blankj.utilcode.util.LogUtils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class ApplicationObserver implements LifecycleObserver {

    private final String TAG = this.getClass().getName();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onAppCreate() {
        LogUtils.dTag(TAG, "onAppCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onAppStart() {
        LogUtils.dTag(TAG, "onAppStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onAppResume() {
        LogUtils.dTag(TAG, "onAppResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void onAppPause() {
        LogUtils.dTag(TAG, "onAppPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onAppStop() {
        LogUtils.dTag(TAG, "onAppStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onAppDestroy() {
        LogUtils.dTag(TAG, "onAppDestroy");
    }
}
