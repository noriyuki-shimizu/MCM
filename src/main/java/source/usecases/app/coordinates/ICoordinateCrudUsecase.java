package source.usecases.app.coordinates;

import source.usecases.dto.request.coordinates.CoordinateCreateRequestModel;
import source.usecases.dto.request.coordinates.CoordinateUpdateRequestModel;
import source.usecases.dto.response.coordinates.CoordinateResponseViewModel;
import source.usecases.dto.response.coordinates.CoordinateResponseViewModels;

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
    public CoordinateResponseViewModel create(Long userId, CoordinateCreateRequestModel requestData);

    /**
     * 物理削除を行います.
     *
     * @param id primary key
     */
    public void delete(Long id);

    /**
     * 検索を行います.
     *
     * @param userId ユーザID
     * @return 画面描画するための DTO List
     */
    public CoordinateResponseViewModels search(Long userId);

    /**
     * 1件検索を行います.
     *
     * @param id primary key
     * @return 画面描画するための DTO
     */
    public CoordinateResponseViewModel searchById(Long id);

    /**
     * 更新を行います.
     *
     * @param userId ユーザID
     * @param id primary key
     * @param requestData 画面からの入力値
     */
    public void update(Long userId, Long id, CoordinateUpdateRequestModel requestData);
}
