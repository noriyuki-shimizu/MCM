package source.usecases.app;

import source.controller.shops.crud.request.ShopCreateRequestModel;
import source.controller.shops.crud.request.ShopUpdateRequestModel;
import source.controller.shops.assist.response.ShopAssistResponseViewModels;
import source.controller.shops.crud.response.ShopResponseViewModel;
import source.controller.shops.crud.response.ShopResponseViewModels;

/**
 * お店の DB 操作を行うユースケースです.
 */
public interface IShopCrudUsecase {
    /**
     * プルダウンに表示するための key value のリストを取得します.
     *
     * @param userId ユーザID
     * @return ブルダウン表記のための DTO
     */
    ShopAssistResponseViewModels acceptKeyValues(Long userId);

    /**
     * 新規作成を行います.
     *
     * @param userId ユーザID
     * @param inputData 画面からの入力値
     * @return 画面描画のための DTO
     */
    ShopResponseViewModel create(Long userId, ShopCreateRequestModel inputData);

    /**
     * 削除を行います.
     *
     * @param id primary key
     */
    void delete(Long id);

    /**
     * 検索を行います.
     *
     * @param userId ユーザID
     * @return 画面描画のための DTO List
     */
    ShopResponseViewModels search(Long userId);

    /**
     * 1件検索を行います.
     *
     * @param id primary key
     * @return 画面描画するための DTO
     */
    ShopResponseViewModel searchById(Long id);

    /**
     * 更新を行います.
     *
     * @param userId ユーザID
     * @param id primary key
     * @param inputData 画面からの入力値
     */
    void update(Long userId, Long id, ShopUpdateRequestModel inputData);

    /**
     * 復元を行います.
     *
     * @param id primary key
     */
    void restoration(Long id);
}
