package source.domain.dto.clothes;

import lombok.Builder;

import java.util.Date;

/**
 * 服の検索結果に対するデータ
 */
@Builder
public class ClothesSearchOutputData {

    /** id */
    private Long id;

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
