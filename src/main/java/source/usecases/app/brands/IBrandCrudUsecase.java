package source.usecases.app.brands;

import source.usecases.dto.request.brands.BrandCreateRequestModel;
import source.usecases.dto.request.brands.BrandUpdateRequestModel;
import source.usecases.dto.response.brands.BrandAssistResponseViewModels;
import source.usecases.dto.response.brands.BrandResponseViewModel;
import source.usecases.dto.response.brands.BrandResponseViewModels;

/**
 * ブランドの DB 操作を行うユースケースです.
 */
public interface IBrandCrudUsecase {
    /**
     * プルダウンに表示するための key value のリストを取得します.
     *
     * @param userId ユーザID
     * @return ブルダウン表記のための DTO
     */
    public BrandAssistResponseViewModels acceptKeyValues(Long userId);

    /**
     * 新規作成を行います.
     *
     * @param userId ユーザID
     * @param inputData 画面からの入力値
     * @return 画面描画するための DTO
     */
    public BrandResponseViewModel create(Long userId, BrandCreateRequestModel inputData);

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
    public BrandResponseViewModels search(Long userId);

    /**
     * 1件検索を行います.
     *
     * @param id primary key
     * @return 画面描画するための DTO
     */
    public BrandResponseViewModel searchById(Long id);

    /**
     * 更新を行います.
     *
     * @param userId ユーザID
     * @param id primary key
     * @param inputData 画面からの入力値
     */
    public void update(Long userId, Long id, BrandUpdateRequestModel inputData
    );
}
