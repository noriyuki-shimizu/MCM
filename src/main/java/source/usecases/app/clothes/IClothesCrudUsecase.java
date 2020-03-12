package source.usecases.app.clothes;

import source.usecases.dto.request.clothes.ClothesCreateRequestModel;
import source.usecases.dto.request.clothes.ClothesUpdateRequestModel;
import source.usecases.dto.response.clothes.ClothesAssistResponseViewModels;
import source.usecases.dto.response.clothes.ClothesResponseViewModel;
import source.usecases.dto.response.clothes.ClothesResponseViewModels;

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
    public ClothesAssistResponseViewModels acceptKeyValues(Long userId);

    /**
     * 新規作成を行います.
     *
     * @param userId ユーザID
     * @param inputData 画面からの入力値
     * @return 画面描画するための DTO
     */
    public ClothesResponseViewModel create(Long userId, ClothesCreateRequestModel inputData);

    /**
     * 論理削除を行います.
     *
     * @param id primary key
     */
    public void delete(Long id);

    /**
     * 復元を行います.
     *
     * @param id primary key
     */
    public void restoration(Long id);

    /**
     * 検索を行います.
     *
     * @param userId ユーザID
     * @return 画面描画するための DTO List
     */
    public ClothesResponseViewModels search(Long userId);

    /**
     * 1件検索を行います.
     *
     * @param id primary key
     * @return 画面描画するための DTO
     */
    public ClothesResponseViewModel searchById(Long id);

    /**
     * 更新を行います.
     *
     * @param userId ユーザID
     * @param id primary key
     * @param inputData 画面からの入力値
     */
    public void update(Long userId, Long id, ClothesUpdateRequestModel inputData);
}
