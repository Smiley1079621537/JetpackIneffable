package grace.immanuel.ineffable.binding;

import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.databinding.BindingAdapter;

public class ImageViewBindingAdapter {

    @BindingAdapter(value = {"image", "defaultImageResource"}, requireAll = false)
    public static void setImage(ImageView imageView,
                                String imageUrl, int imageResource) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
        } else {
            imageView.setBackgroundResource(imageResource);
        }
    }
} 