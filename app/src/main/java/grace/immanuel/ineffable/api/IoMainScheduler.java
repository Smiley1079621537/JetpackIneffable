package grace.immanuel.ineffable.api;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Lemuel created on 2018/7/6
 */
public class IoMainScheduler<T> implements FlowableTransformer<T, T> {
    @Override
    public Publisher<T> apply(Flowable<T> upstream) {
        return upstream.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
