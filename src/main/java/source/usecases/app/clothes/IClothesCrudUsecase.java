package source.usecases.app.clothes;

import source.controller.clothes.curd.request.ClothesCreateRequestModel;
import source.controller.clothes.curd.request.ClothesUpdateRequestModel;
import source.controller.clothes.assist.response.ClothesAssistResponseViewModels;
import source.controller.clothes.curd.response.ClothesResponseViewModel;
import source.controller.clothes.curd.response.ClothesResponseViewModels;

/**
 * 服の DB 操作を行うユースケースです.
 */
public interface IClothesCrudUsecase {
    /**
     * プルダウンに表示するための key value のリストを取得します.
     *
     * @param userId ユーザID
     * @return ブルダウン表記のための DTO
     */
    ClothesAssistResponseViewModels acceptKeyValues(Long userId);

    /**
     * 新規作成を行います.
     *
     * @param userId ユーザID
     * @param inputData 画面からの入力値
     * @return 画面描画するための DTO
     */
    ClothesResponseViewModel create(Long userId, ClothesCreateRequestModel inputData);

    /**
     * 論理削除を行います.
     *
     * @param id primary key
     */
    void delete(Long id);

    /**
     * 復元を行います.
     *
     * @param id primary key
     */
    void restoration(Long id);

    /**
     * 検索を行います.
     *
     * @param userId ユーザID
     * @return 画面描画するための DTO List
     */
    ClothesResponseViewModels search(Long userId);

    /**
     * 1件検索を行います.
     *
     * @param id primary key
     * @return 画面描画するための DTO
     */
    ClothesResponseViewModel searchById(Long id);

    /**
     * ユーザごとの合計金額を取得します.
     *
     * @param userId ユーザID
     * @return 合計金額
     */
    long getTotalPriceByUserId(Long userId);

    /**
     * 更新を行います.
     *
     * @param userId ユーザID
     * @param id primary key
     * @param inputData 画面からの入力値
     */
    void update(Long userId, Long id, ClothesUpdateRequestModel inputData);
}
