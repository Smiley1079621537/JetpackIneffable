package grace.immanuel.ineffable.api;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Lemuel created on 2018/7/6
 */
public abstract class AdoreSubscriber<T> implements Subscriber<T> {

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T t) {
    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}
