package grace.immanuel.ineffable.adapter;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.annotation.NonNull;
import grace.immanuel.ineffable.R;
import grace.immanuel.ineffable.bean.Beauty;

public class ImageAdapter extends BaseQuickAdapter<Beauty, BaseViewHolder> implements LoadMoreModule {

    public static final int SPAN_COUNT = 3;
    public static final int SIZE_PICTURE = 200;

    public ImageAdapter(List<Beauty> data) {
        super(R.layout.item_image, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Beauty beauty) {
        baseViewHolder.setText(R.id.nickName, beauty.getName());
        loadUrl(baseViewHolder.getView(R.id.image), beauty.getImage());
    }

    private void loadUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .asBitmap().load(url)
                .into(new SimpleTarget<Bitmap>() {
                    public void onResourceReady(
                            @NotNull Bitmap bitmap,
                            Transition<? super Bitmap> transition) {
                        setImageBitmap(bitmap, imageView);
                    }
                });
    }

    private void setImageBitmap(@NonNull Bitmap bitmap, ImageView imageView) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = (int) (((float) bitmap.getHeight())
                / bitmap.getWidth() * ScreenUtils.getScreenWidth() / SPAN_COUNT);
        layoutParams.width = ScreenUtils.getScreenWidth() / SPAN_COUNT;
        imageView.setLayoutParams(layoutParams);
        imageView.setImageBitmap(bitmap);
    }
}