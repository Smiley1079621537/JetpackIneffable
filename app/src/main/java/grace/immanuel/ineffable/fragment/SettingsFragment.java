package grace.immanuel.ineffable.fragment;

import android.view.Menu;
import android.view.MenuInflater;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import grace.immanuel.ineffable.R;
import grace.immanuel.ineffable.databinding.FragmentSettingsBinding;
import grace.immanuel.ineffable.listener.EventHandleListener;

public class SettingsFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_settings;
    }

    @Override
    protected void initView() {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        FragmentSettingsBinding binding = DataBindingUtil
                .setContentView(getActivity(), getLayoutId());
        binding.setEventHandler(new EventHandleListener());
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();//清楚menu
        super.onCreateOptionsMenu(menu, inflater);
    }
}
