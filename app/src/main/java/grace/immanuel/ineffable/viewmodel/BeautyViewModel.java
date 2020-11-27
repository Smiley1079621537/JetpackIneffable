package grace.immanuel.ineffable.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import grace.immanuel.ineffable.bean.Girl;

public class BeautyViewModel extends ViewModel {
    public LiveData<PagedList<Girl>> beauties;

    public BeautyViewModel() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(BeautyDataSource.PER_PAGE)
                .setPrefetchDistance(BeautyDataSource.PER_PAGE * 4)
                .setInitialLoadSizeHint(BeautyDataSource.PER_PAGE)
                .setMaxSize(65536 * BeautyDataSource.PER_PAGE)
                .build();

        beauties = new LivePagedListBuilder<>(
                new BeautyDataSourceFactory(), config).build();
    }
}