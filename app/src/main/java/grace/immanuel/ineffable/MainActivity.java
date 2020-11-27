package grace.immanuel.ineffable;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import grace.immanuel.ineffable.databinding.ActivityMainBinding;
import grace.immanuel.ineffable.workmanager.TimeCountAddWorker;
import grace.immanuel.ineffable.workmanager.TimeCountPlusWorker;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupNavController();
        observeWorkRequest();
    }

    private void observeWorkRequest() {
        initWorkRequest();
        observeTimeCountPlusWorker(TimeCountPlusWorker.TAG_PLUS, TimeCountPlusWorker.ARG_TIME);
        observeTimeCountPlusWorker(TimeCountAddWorker.TAG_ADD, TimeCountAddWorker.ARG_TIME);
    }

    private void initWorkRequest() {
        WorkManager.getInstance(this)
                .beginWith(getTimeCountPlusWorkRequest())
                .then(getTimeCountAddRequest())
                .enqueue();
    }

    private void observeTimeCountPlusWorker(String tag, String arg) {
        WorkManager.getInstance(this).getWorkInfosByTagLiveData(tag)
                .observe(this, works -> {
                    //if (works != null && works.size() > 0 && works.get(0).getState() == WorkInfo.State.SUCCEEDED) {
                    //int time = works.get(0).getOutputData()
                    //        .getInt(arg, 0);
                    //ToastUtils.showShort(String.valueOf(time));
                    //}
                });
    }

    @NotNull
    private OneTimeWorkRequest getTimeCountPlusWorkRequest() {
        return new OneTimeWorkRequest.Builder(TimeCountPlusWorker.class)
                .setBackoffCriteria(BackoffPolicy.LINEAR,
                        OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
                        TimeUnit.MILLISECONDS)
                .setConstraints(getConstraints())
                .setInitialDelay(5, TimeUnit.SECONDS)
                .addTag(TimeCountPlusWorker.TAG_PLUS)
                .build();
    }

    @NotNull
    private OneTimeWorkRequest getTimeCountAddRequest() {
        return new OneTimeWorkRequest.Builder(TimeCountAddWorker.class)
                .setBackoffCriteria(BackoffPolicy.LINEAR,
                        OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
                        TimeUnit.MILLISECONDS)
                .setConstraints(getConstraints())
                .setInitialDelay(10, TimeUnit.SECONDS)
                .addTag(TimeCountAddWorker.TAG_ADD)
                .build();
    }

    @NotNull
    private Constraints getConstraints() {
        return new Constraints.Builder()
                .setRequiresCharging(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .build();
    }

    private void setupNavController() {
        navController = Navigation
                .findNavController(this, R.id.fragment_container);
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            //收到切換事件
        });
//        appBarConfiguration = new AppBarConfiguration
//                .Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this,
//                navController, appBarConfiguration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item,
                navController) || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController,
                appBarConfiguration) || super.onSupportNavigateUp();
    }
}