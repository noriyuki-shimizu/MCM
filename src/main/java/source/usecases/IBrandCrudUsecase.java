package source.usecases;

import source.controller.brands.crud.request.BrandCreateRequestModel;
import source.controller.brands.crud.request.BrandUpdateRequestModel;
import source.controller.brands.assist.response.BrandAssistResponseViewModels;
import source.controller.brands.crud.response.BrandResponseViewModel;
import source.controller.brands.crud.response.BrandResponseViewModels;

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
    BrandAssistResponseViewModels acceptKeyValues(final Long userId);

    /**
     * 新規作成を行います.
     *
     * @param userId ユーザID
     * @param inputData 画面からの入力値
     * @return 画面描画するための DTO
     */
    BrandResponseViewModel create(final Long userId, final BrandCreateRequestModel inputData);

    /**
     * 論理削除を行います.
     *
     * @param id primary key
     */
    void delete(final Long userId, final Long id);

    /**
     * 復元を行います.
     *
     * @param id primary key
     */
    void restoration(final Long userId, final Long id);

    /**
     * 検索を行います.
     *
     * @param userId ユーザID
     * @return 画面描画するための DTO List
     */
    BrandResponseViewModels search(final Long userId);

    /**
     * 1件検索を行います.
     *
     * @param id primary key
     * @return 画面描画するための DTO
     */
    BrandResponseViewModel searchById(final Long id);

    /**
     * 更新を行います.
     *
     * @param userId ユーザID
     * @param id primary key
     * @param inputData 画面からの入力値
     */
    void update(final Long userId, final Long id, final BrandUpdateRequestModel inputData
    );
}
