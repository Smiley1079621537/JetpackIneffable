package grace.immanuel.ineffable.fragment;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.ImageUtils;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import grace.immanuel.ineffable.R;
import grace.immanuel.ineffable.databinding.FragmentMainBinding;

public class MainFragment extends BaseFragment {

    private static final String CHANNEL_ID = "1";

    private FragmentMainBinding binding;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            binding = DataBindingUtil.setContentView(getActivity(), getLayoutId());
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

        binding.btnGirlList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity() != null) {
                    sendNotification(getContext());
                }
            }
        });

        binding.tvApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity() != null) {
                    navigateToSecondFragment(getView());
                }
            }
        });
    }

    private void navigateToSecondFragment(View view) {
        Bundle bundle = new MainFragmentArgs.Builder()
                .setUserName("Lemuel")
                .setAge(18)
                .build().toBundle();
        Navigation.findNavController(view)
                .navigate(R.id.action_mainFragment_to_secondFragment, bundle);
    }

    private void sendNotification(Context context) {
        createNotificationChannel(context);
        NotificationCompat.Builder builder = getBuilder(context);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        int notificationId = 1;
        notificationManager.notify(notificationId, builder.build());
    }

    private void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importanceDefault = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID, "ChannelName", importanceDefault
            );
            channel.setDescription("description");
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private NotificationCompat.Builder getBuilder(Context context) {
        return new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setLargeIcon(ImageUtils.getBitmap(R.drawable.ineffable))
                .setContentTitle("Girls")
                .setContentText("全然美丽。")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(getPendingIntent())
                .setAutoCancel(true);
    }

    private PendingIntent getPendingIntent() {
        if (getView() != null) {
            Bundle bundle = new Bundle();
            bundle.putString("params", "ParamsFromNotification_HelloLemuel");
            return Navigation
                    .findNavController(getView())
                    .createDeepLink()
                    .setGraph(R.navigation.nav_graph)
                    .setDestination(R.id.deepLinkFragment)
                    .setArguments(bundle)
                    .createPendingIntent();
        }
        return null;
    }
}
