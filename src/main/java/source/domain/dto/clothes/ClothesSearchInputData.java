package source.domain.dto.clothes;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

/**
 * 服の検索フォームのデータ.
 */
@Builder
@Getter
public class ClothesSearchInputData {

    /** ブランドID */
    private Integer brandId;

    /** ジャンルID */
    private Integer genreId;

    /** 店ID */
    private Integer shopId;

    /** 〜円以上 */
    private Integer morePrice;

    /** 〜円以下 */
    private Integer lessPrice;

    /** 購入日 */
    private Date buyDate;

    /** 削除フラグ */
    private boolean deleteFlag;

}
