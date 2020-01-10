package source.usecases.dto.request.clothes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import source.usecases.dto.request.RequestBase;

import java.util.Date;

/**
 * 服の検索フォームのデータ.
 */
@Builder
@Getter
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
@NoArgsConstructor
public class ClothesSearchRequestData extends RequestBase {

    /** ブランドID */
    private Long brandId;

    /** ジャンルID */
    private Long genreId;

    /** 店ID */
    private Long shopId;

    /** 〜円以上 */
    private Integer morePrice;

    /** 〜円以下 */
    private Integer lessPrice;

    /** 購入日 */
    private Date buyDate;

    /** 削除フラグ */
    private Boolean isDeleted;

}
