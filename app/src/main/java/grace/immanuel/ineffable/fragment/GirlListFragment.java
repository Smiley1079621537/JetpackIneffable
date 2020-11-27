package grace.immanuel.ineffable.fragment;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import grace.immanuel.ineffable.R;
import grace.immanuel.ineffable.adapter.ImagePagingAdapter;
import grace.immanuel.ineffable.bean.Girl;
import grace.immanuel.ineffable.databinding.FragmentDeepLinkBinding;
import grace.immanuel.ineffable.viewmodel.BeautyViewModel;

public class GirlListFragment extends BaseFragment {
    private ImagePagingAdapter imageAdapter;
    private FragmentDeepLinkBinding binding;
    private BeautyViewModel beautyViewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_deep_link;
    }

    @Override
    protected void initView() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            binding = DataBindingUtil.setContentView(getActivity(), getLayoutId());
            setUpAdapter();
        }
    }

    private void setUpAdapter() {
        if (getActivity() != null) {
            LinearLayoutManager linearLayoutManager =
                    new LinearLayoutManager(getActivity());
            binding.recyclerView.setLayoutManager(linearLayoutManager);
            imageAdapter = new ImagePagingAdapter(getActivity());
            beautyViewModel = new ViewModelProvider(getActivity())
                    .get(BeautyViewModel.class);
            beautyViewModel.beauties.observe(getActivity(), beauties -> {
                if (getActivity() != null) {
                    imageAdapter.submitList(beauties);
                }
            });
            binding.recyclerView.setAdapter(imageAdapter);
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (getActivity() != null && !getActivity().isFinishing()) {
                    imageAdapter.submitList(null);
                    beautyViewModel.beauties.observe(getActivity(), new Observer<PagedList<Girl>>() {
                        @Override
                        public void onChanged(PagedList<Girl> girls) {
                            binding.swipeRefreshLayout.setRefreshing(false);
                            imageAdapter.submitList(girls);
                        }
                    });
                }
            }
        });
    }
}
