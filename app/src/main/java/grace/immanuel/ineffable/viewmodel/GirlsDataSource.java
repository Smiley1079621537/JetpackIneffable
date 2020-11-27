package grace.immanuel.ineffable.viewmodel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import grace.immanuel.ineffable.api.AdoreSubscriber;
import grace.immanuel.ineffable.api.ApiManager;
import grace.immanuel.ineffable.api.IoMainScheduler;
import grace.immanuel.ineffable.bean.BeautyListResponse;
import grace.immanuel.ineffable.bean.Girl;
import io.reactivex.Flowable;

@SuppressWarnings("ALL")
public class GirlsDataSource extends PageKeyedDataSource<Integer, Girl> {

    public static final int PER_PAGE = 50;
    private static final int FIRST_PAGE = 1;

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback callback) {

        Flowable<BeautyListResponse> girls1 = ApiManager.getBeautyService()
                .getGirls(FIRST_PAGE, PER_PAGE);
        Flowable<BeautyListResponse> girls2 = ApiManager.getBeautyService()
                .getGirls(FIRST_PAGE + 1, PER_PAGE);

        List<Girl> girls = new ArrayList<>();

        Flowable.mergeArray(girls1, girls2)
                .compose(new IoMainScheduler<>())
                .subscribe(new AdoreSubscriber<BeautyListResponse>() {
                    @Override
                    public void onNext(BeautyListResponse beautyListResponse) {
                        if (beautyListResponse != null) {
                            List<Girl> data = beautyListResponse.getData();
                            girls.addAll(data);
                            if (beautyListResponse.getPage() == 2) {
                                callback.onResult(girls, null,
                                        FIRST_PAGE == beautyListResponse.getPage_count() ?
                                                null : null);
                            }
                        }
                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams params, @NonNull LoadCallback callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams params, @NonNull LoadCallback callback) {

    }
}