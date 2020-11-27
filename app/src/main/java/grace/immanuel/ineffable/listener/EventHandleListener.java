package grace.immanuel.ineffable.listener;

import android.view.View;

import com.blankj.utilcode.util.ToastUtils;

public class EventHandleListener {

    public EventHandleListener() {
    }

    public void onButtonClicked(View view) {
        ToastUtils.showShort("I am clicked!");
    }
}