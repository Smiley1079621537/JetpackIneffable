package grace.immanuel.ineffable.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import grace.immanuel.ineffable.bean.Girl;

public class GirlsViewModel extends AndroidViewModel {
    public LiveData<PagedList<Girl>> girls;

    public GirlsViewModel(@NonNull Application application) {
        super(application);
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(BeautyDataSource.PER_PAGE)
                .setPrefetchDistance(BeautyDataSource.PER_PAGE * 4)
                .setInitialLoadSizeHint(BeautyDataSource.PER_PAGE)
                .setMaxSize(65536 * BeautyDataSource.PER_PAGE)
                .build();

        girls = new LivePagedListBuilder<>(
                new GirlsDataSourceFactory(), config).build();
    }
}