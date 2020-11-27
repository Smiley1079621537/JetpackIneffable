package grace.immanuel.ineffable.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Girl {
    /**
     * images : ["http://gank.io/images/f4f6d68bf30147e1bdd4ddbc6ad7c2a2"]
     * publishedAt : 2020-05-25 08:00:00
     * author : 鸢媛
     * stars : 1
     * title : 第96期
     * type : Girl
     * url : http://gank.io/images/f4f6d68bf30147e1bdd4ddbc6ad7c2a2
     * createdAt : 2020-05-25 08:00:00
     * likeCounts : 4
     * _id : 5e959250808d6d2fe6b56eda
     * category : Girl
     * views : 10091
     * desc : 与其安慰自己平凡可贵，
     * 不如拼尽全力活得漂亮。 ​ ​​​​
     */
    @SerializedName("images")
    private List<String> images;
    @SerializedName("publishedAt")
    private String publishedAt;
    @SerializedName("author")
    private String author;
    @SerializedName("stars")
    private int stars;
    @SerializedName("title")
    private String title;
    @SerializedName("type")
    private String type;
    @SerializedName("url")
    private String url;
    @SerializedName("createdAt")
    private String createdAt;
    @SerializedName("likeCounts")
    private int likeCounts;
    @SerializedName("_id")
    private String _id;
    @SerializedName("category")
    private String category;
    @SerializedName("views")
    private int views;
    @SerializedName("desc")
    private String desc;

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setLikeCounts(int likeCounts) {
        this.likeCounts = likeCounts;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getImages() {
        return images;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getAuthor() {
        return author;
    }

    public int getStars() {
        return stars;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public int getLikeCounts() {
        return likeCounts;
    }

    public String get_id() {
        return _id;
    }

    public String getCategory() {
        return category;
    }

    public int getViews() {
        return views;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "DataEntity{" +
                "images=" + images +
                ", publishedAt='" + publishedAt + '\'' +
                ", author='" + author + '\'' +
                ", stars=" + stars +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", likeCounts=" + likeCounts +
                ", _id='" + _id + '\'' +
                ", category='" + category + '\'' +
                ", views=" + views +
                ", desc='" + desc + '\'' +
                '}';
    }
}