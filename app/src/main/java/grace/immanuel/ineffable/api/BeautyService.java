package grace.immanuel.ineffable.api;

import grace.immanuel.ineffable.bean.BeautyListResponse;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BeautyService {

    @GET(ApiManager.BASE_URL + "category/Girl/type/Girl/page/{page}/count/{count}")
    Flowable<BeautyListResponse> getGirls(@Path("page") int page, @Path("count") int count);
} 