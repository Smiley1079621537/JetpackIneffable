package grace.immanuel.ineffable.lifecycle;

import android.content.Context;
import android.content.Intent;

import org.jetbrains.annotations.NotNull;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import grace.immanuel.ineffable.service.IneffableService;

/**
 * 使用LifeCycle解耦頁面與組件
 */
public class IneffableObserver implements LifecycleObserver {

    private Context context;
    private OnIneffableChangeListener ineffableChangeListener;

    public IneffableObserver(@NotNull Context context, @NotNull OnIneffableChangeListener listener) {
        this.context = context;
        ineffableChangeListener = listener;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onIneffableStart() {
        ineffableChangeListener.ineffableChange("onIneffableStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onIneffableResume() {
        ineffableChangeListener.ineffableChange("onIneffableResume");

        Intent intent = new Intent(context, IneffableService.class);
        context.startService(intent);

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onIneffablePause() {
        ineffableChangeListener.ineffableChange("onIneffablePause");

        Intent intent = new Intent(context, IneffableService.class);
        context.stopService(intent);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onIneffableDestroy() {
        ineffableChangeListener.ineffableChange("onIneffableDestroy");
        releaseResource();
    }

    private void releaseResource() {
        context = null;
        ineffableChangeListener = null;
    }

    public interface OnIneffableChangeListener {
        void ineffableChange(String states);
    }
}
