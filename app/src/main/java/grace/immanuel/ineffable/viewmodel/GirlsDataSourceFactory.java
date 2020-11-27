package grace.immanuel.ineffable.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import grace.immanuel.ineffable.bean.Girl;

public class GirlsDataSourceFactory
        extends DataSource.Factory<Integer, Girl> {
    private MutableLiveData<GirlsDataSource> liveData = new MutableLiveData<>();

    @NonNull
    @Override
    public DataSource<Integer, Girl> create() {
        GirlsDataSource dataSource = new GirlsDataSource();
        liveData.postValue(dataSource);
        return dataSource;
    }
}