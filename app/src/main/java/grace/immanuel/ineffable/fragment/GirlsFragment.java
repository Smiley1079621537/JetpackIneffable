package grace.immanuel.ineffable.fragment;

import android.view.View;

import java.util.List;
import java.util.Random;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import grace.immanuel.ineffable.R;
import grace.immanuel.ineffable.bean.Girl;
import grace.immanuel.ineffable.databinding.FragmentSecondBinding;
import grace.immanuel.ineffable.listener.EventHandleListener;
import grace.immanuel.ineffable.utils.IneffableUtil;
import grace.immanuel.ineffable.viewmodel.GirlsViewModel;

public class GirlsFragment extends BaseFragment {
    private FragmentSecondBinding binding;
    private List<Girl> mGirls;
    private int currentIndex = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_second;
    }

    @Override
    protected void initView() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            binding = DataBindingUtil.setContentView(getActivity(), getLayoutId());

        }
    }

    @Override
    protected void initData() {
        setUpGirls();
    }

    @Override
    protected void initListener() {
        binding.setClickHandler(new EventHandleListener() {
            @Override
            public void onButtonClicked(View view) {
                if (mGirls == null) {
                    setUpGirls();
                } else {
                    binding.setNetworkImageUrl(getRandomGirl(mGirls));
                }
            }
        });
    }

    private void setUpGirls() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            GirlsViewModel girlsViewModel = new ViewModelProvider(getActivity()).get(GirlsViewModel.class);
            girlsViewModel.girls.observe(getActivity(), new Observer<List<Girl>>() {
                @Override
                public void onChanged(List<Girl> girls) {
                    if (girls != null && girls.size() > 0) {
                        mGirls = girls;
                        binding.setNetworkImageUrl(getRandomGirl(mGirls));
                    } else {
                        binding.setNetworkImageUrl(IneffableUtil.getRandomImageUrl());
                    }
                }
            });
        }
    }

    private String getRandomGirl(List<Girl> mGirls) {
        if (mGirls != null && mGirls.size() > 0) {
            Random random = new Random();
            currentIndex = random.nextInt(mGirls.size());
            List<String> images = mGirls.get(currentIndex).getImages();
            if (images != null && images.size() > 0) {
                return images.get(0);
            }
        }
        return IneffableUtil.getRandomImageUrl();
    }
}
