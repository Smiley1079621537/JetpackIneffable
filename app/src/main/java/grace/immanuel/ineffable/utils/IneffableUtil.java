package grace.immanuel.ineffable.utils;

import java.util.ArrayList;
import java.util.List;

import grace.immanuel.ineffable.bean.Beauty;

public class IneffableUtil {

    public static String getRatingString(int rating) {
        switch (rating) {
            case 0:
                return "零星";
            case 1:
                return "一星";
            case 2:
                return "二星";
            case 3:
                return "三星";
            case 4:
                return "四星";
            case 5:
                return "五星";
        }
        return "";
    }

    public static List<String> getNickNames() {
        List<String> nickNames = new ArrayList<>();
        nickNames.add("Esther\n(以斯帖)");
        nickNames.add("Abigail\n(亚比该)");
        nickNames.add("Deborah\n(底波拉)");
        nickNames.add("哈拿\n(Hannah)");
        nickNames.add("夏娃\n(Eve)");
        nickNames.add("以利沙伯\n(Elisabeth)");
        nickNames.add("多加\n(Dorcas)");
        nickNames.add("友尼基\n(Eunice)");
        nickNames.add("吕底亚\n(Lydia)");
        return nickNames;
    }

    public static List<String> getPictureAddress() {
        List<String> imageUrls = new ArrayList<>();
        imageUrls.add("https://hbimg.huabanimg.com/9ae8d24c7118206850bac493042063ec58213f9e2dc07-VY12eE_fw658/format/webp");
        imageUrls.add("https://hbimg.huabanimg.com/f77b8965506420d6d63984645e5aaeb2f408553622648-VEBFkR_fw658/format/webp");
        imageUrls.add("https://hbimg.huabanimg.com/554c26fd682108dc530e377abc637c27f4d378b918ed1-uoAH8K_fw658/format/webp");
        imageUrls.add("https://hbimg.huabanimg.com/2a03a94380f1dd3856b0f70bbc5bf3209bd264e8560ed-p8N6yZ_fw658/format/webp");
        imageUrls.add("https://hbimg.huabanimg.com/829bb67928309027892ee16b33e84c75cdefd86e88fba-fZkROt_fw658/format/webp");
        imageUrls.add("https://hbimg.huabanimg.com/d8621039f5b9c0abfc1edca977ba9991b4bb66fd32e59-rygbjl_fw658/format/webp");
        imageUrls.add("https://hbimg.huabanimg.com/07d90094b5efd325e452341abb6006c828918d0d19a7ac-Ubzt84_fw658/format/webp");
        imageUrls.add("https://hbimg.huabanimg.com/66cde24012e7159dc166b503aef5793a9399136b3f305-CpVceH_fw658/format/webp");
        imageUrls.add("https://hbimg.huabanimg.com/f2039b86be27c0745c630b8d21f77b2aa5f04fd6222d2-AcuN0j_fw658/format/webp");
        return imageUrls;
    }

    public static List<Beauty> getBeauties() {
        List<Beauty> beauties = new ArrayList<>();
        for (int i = 0; i < getPictureAddress().size(); i++) {
            Beauty beauty = new Beauty(getRandomNickName(), getRandomImageUrl());
            beauties.add(beauty);
        }
        return beauties;
    }

    public static String getRandomImageUrl() {
        return getPictureAddress().get((int) (Math.random() * getPictureAddress().size()));
    }

    public static String getRandomNickName() {
        return getNickNames().get((int) (Math.random() * getNickNames().size()));
    }
} 