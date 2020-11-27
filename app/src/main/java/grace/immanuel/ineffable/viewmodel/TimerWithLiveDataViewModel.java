package grace.immanuel.ineffable.viewmodel;

import java.util.Timer;
import java.util.TimerTask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TimerWithLiveDataViewModel extends ViewModel {
    private Timer timer;
    private MutableLiveData<Integer> currentSecond;

    public MutableLiveData<Integer> getCurrentSecond() {
        if (currentSecond == null) {
            currentSecond = new MutableLiveData<>();
            currentSecond.setValue(0);
        }
        return currentSecond;
    }

    public void startTiming() {
        if (timer == null) {
            timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    Integer value = getCurrentSecond().getValue();
                    if (value != null)
                        getCurrentSecond().postValue(value + 1);
                }
            };
            timer.schedule(timerTask, 1000, 1000);
        }
    }

}
