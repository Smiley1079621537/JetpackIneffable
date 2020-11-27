package grace.immanuel.ineffable.service;

import androidx.lifecycle.LifecycleService;
import grace.immanuel.ineffable.lifecycle.IneffableServerObserver;

public class IneffableService extends LifecycleService {

    public IneffableService() {
        IneffableServerObserver serverObserver = new IneffableServerObserver();
        getLifecycle().addObserver(serverObserver);
    }
}
