package grace.immanuel.ineffable.viewmodel;

import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import grace.immanuel.ineffable.api.AdoreSubscriber;
import grace.immanuel.ineffable.api.ApiManager;
import grace.immanuel.ineffable.api.IoMainScheduler;
import grace.immanuel.ineffable.bean.BeautyListResponse;
import grace.immanuel.ineffable.bean.Girl;

@SuppressWarnings("ALL")
public class BeautyDataSource extends PageKeyedDataSource<Integer, Girl> {

    public static final int PER_PAGE = 10;
    private static final int FIRST_PAGE = 1;

    @Override
    public void loadInitial(@NonNull LoadInitialParams params,
                            @NonNull LoadInitialCallback callback) {
        ApiManager.getBeautyService()
                .getGirls(FIRST_PAGE, PER_PAGE)
                .compose(new IoMainScheduler<>())
                .subscribe(new AdoreSubscriber<BeautyListResponse>() {
                    @Override
                    public void onNext(BeautyListResponse beautyListResponse) {
                        if (beautyListResponse != null) {
                            List<Girl> data = beautyListResponse.getData();
                            Collections.shuffle(data);
                            callback.onResult(data, null, beautyListResponse.getPage() + 1);
                        }
                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams params, @NonNull LoadCallback callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams params, @NonNull LoadCallback callback) {
        ApiManager.getBeautyService()
                .getGirls((int) params.key, PER_PAGE)
                .compose(new IoMainScheduler<>())
                .subscribe(new AdoreSubscriber<BeautyListResponse>() {
                    @Override
                    public void onNext(BeautyListResponse beautyListResponse) {
                        if (beautyListResponse != null) {
                            List<Girl> data = beautyListResponse.getData();
                            callback.onResult(data, (int) params.key ==
                                    beautyListResponse.getPage_count() ?
                                    null : beautyListResponse.getPage() + 1);
                        }
                    }
                });
    }
}