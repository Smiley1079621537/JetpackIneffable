package grace.immanuel.ineffable.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.LogUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import grace.immanuel.ineffable.lifecycle.IneffableObserver;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    protected abstract int getLayoutId();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addLifecycleObserver();
        initView();
        initData();
        initListener();
    }

    private void addLifecycleObserver() {
        if (getActivity() != null) {
            IneffableObserver ineffableListener = new IneffableObserver(
                    getActivity(), states -> LogUtils.dTag(AppUtils.getAppName(), states));
            getLifecycle().addObserver(ineffableListener);
        }
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();
}
