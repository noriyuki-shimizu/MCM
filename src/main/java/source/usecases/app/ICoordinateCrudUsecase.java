package source.usecases.app;

import source.controller.coordinates.curd.request.CoordinateCreateRequestModel;
import source.controller.coordinates.curd.request.CoordinateUpdateRequestModel;
import source.controller.coordinates.curd.response.CoordinateResponseViewModel;
import source.controller.coordinates.curd.response.CoordinateResponseViewModels;

/**
 * コーディネートの DB 操作を行うユースケースです.
 */
public interface ICoordinateCrudUsecase {
    /**
     * 新規作成を行います.
     *
     * @param userId ユーザID
     * @param requestData 画面の入力値
     * @return 画面描画するための DTO
     */
    CoordinateResponseViewModel create(Long userId, CoordinateCreateRequestModel requestData);

    /**
     * 物理削除を行います.
     *
     * @param id primary key
     */
    void delete(Long id);

    /**
     * 検索を行います.
     *
     * @param userId ユーザID
     * @return 画面描画するための DTO List
     */
    CoordinateResponseViewModels search(Long userId);

    /**
     * 1件検索を行います.
     *
     * @param id primary key
     * @return 画面描画するための DTO
     */
    CoordinateResponseViewModel searchById(Long id);

    /**
     * 更新を行います.
     *
     * @param userId ユーザID
     * @param id primary key
     * @param requestData 画面からの入力値
     */
    void update(Long userId, Long id, CoordinateUpdateRequestModel requestData);
}
