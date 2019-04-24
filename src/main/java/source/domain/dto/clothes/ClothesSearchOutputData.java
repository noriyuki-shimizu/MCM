package source.domain.dto.clothes;

import lombok.Value;

import java.util.Date;

/**
 * 服の検索結果に対するデータ
 */
@Value(staticConstructor = "of")
public class ClothesSearchOutputData {

    /** 画像パス */
    private String imagePath;

    /** ジャンル名称 */
    private String genreName;

    /** ブランド名称 */
    private String brandName;

    /** 店名称 */
    private String shopName;

    /** 金額 */
    private int price;

    /** 購入日 */
    private Date buyDate;

    /** 削除フラグ */
    private boolean deleteFlag;

}
