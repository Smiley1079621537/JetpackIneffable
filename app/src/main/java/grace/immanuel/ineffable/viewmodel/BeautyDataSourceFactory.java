package grace.immanuel.ineffable.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import grace.immanuel.ineffable.bean.Girl;

public class BeautyDataSourceFactory
        extends DataSource.Factory<Integer, Girl> {
    private MutableLiveData<BeautyDataSource> liveData = new MutableLiveData<>();

    @NonNull
    @Override
    public DataSource<Integer, Girl> create() {
        BeautyDataSource dataSource = new BeautyDataSource();
        liveData.postValue(dataSource);
        return dataSource;
    }
}