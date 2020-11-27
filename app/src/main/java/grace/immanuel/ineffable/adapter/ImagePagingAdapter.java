package grace.immanuel.ineffable.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import grace.immanuel.ineffable.R;
import grace.immanuel.ineffable.bean.Girl;
import grace.immanuel.ineffable.databinding.ItemImageBinding;
import grace.immanuel.ineffable.utils.IneffableUtil;

public class ImagePagingAdapter extends PagedListAdapter<Girl, ImagePagingAdapter.ImagePagingViewHolder> {

    public static final int SPAN_COUNT = 1;
    private Context context;

    private static DiffUtil.ItemCallback<Girl> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Girl>() {
                @Override
                public boolean areItemsTheSame(@NonNull Girl oldItem, @NonNull Girl newItem) {
                    if (oldItem.getImages() != null && oldItem.getImages().size() > 0
                            && newItem.getImages() != null && newItem.getImages().size() > 0) {
                        return oldItem.getImages().get(0).equals(newItem.getImages().get(0));
                    }
                    return false;
                }

                @Override
                public boolean areContentsTheSame(@NonNull Girl oldItem, @NonNull Girl newItem) {
                    if (oldItem.getImages() != null && oldItem.getImages().size() > 0
                            && newItem.getImages() != null && newItem.getImages().size() > 0) {
                        return oldItem.getImages().get(0).equals(newItem.getImages().get(0));
                    }
                    return false;
                }
            };


    public ImagePagingAdapter(@NotNull Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public ImagePagingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemImageBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.item_image, parent, false);
        return new ImagePagingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagePagingViewHolder holder, int position) {
        Girl girl = getItem(position);
        if (girl != null && girl.getImages() != null && girl.getImages().size() > 0) {
            //loadUrl(holder.imageBinding.image, girl.getImages().get(0));
            Glide.with(context).load(girl.getImages().get(0)).into(holder.imageBinding.image);
            holder.imageBinding.nickName.setText(IneffableUtil.getRandomNickName());
        }
    }

    public static class ImagePagingViewHolder extends RecyclerView.ViewHolder {
        private ItemImageBinding imageBinding;

        public ImagePagingViewHolder(@NonNull ItemImageBinding itemView) {
            super(itemView.getRoot());
            imageBinding = itemView;
        }
    }

    private void loadUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .asBitmap().load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(android.R.color.darker_gray)
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