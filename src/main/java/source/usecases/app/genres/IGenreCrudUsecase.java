package source.usecases.app.genres;

import source.usecases.dto.request.genre.GenreCreateRequestModel;
import source.usecases.dto.request.genre.GenreUpdateRequestModel;
import source.usecases.dto.response.genre.GenreAssistResponseViewModels;
import source.usecases.dto.response.genre.GenreResponseViewModel;
import source.usecases.dto.response.genre.GenreResponseViewModels;
import source.usecases.dto.response.genre.TotalPricePerGenreViewModels;

/**
 * ジャンルの DB 操作を行うユースケースです.
 */
public interface IGenreCrudUsecase {
    /**
     * プルダウンに表示するための key value のリストを取得します.
     *
     * @param userId ユーザID
     * @return ブルダウン表記のための DTO
     */
    public GenreAssistResponseViewModels acceptKeyValues(Long userId);

    /**
     * 新規作成を行います.
     *
     * @param userId ユーザID
     * @param requestData 画面からの入力値
     * @return 画面描画するための DTO
     */
    public GenreResponseViewModel create(Long userId, GenreCreateRequestModel requestData);

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
    public GenreResponseViewModels search(Long userId);

    /**
     * 更新を行います.
     *
     * @param userId ユーザID
     * @param id primary key
     * @param requestData 画面からの入力値
     * @return 画面描画するための DTO
     */
    public GenreResponseViewModel update(Long userId, Long id, GenreUpdateRequestModel requestData);

    /**
     * ジャンルごとの合計金額を取得します.
     *
     * @param userId ユーザID
     * @return 画面描画するための DTO
     */
    public TotalPricePerGenreViewModels acceptTotalPricePerGenre(Long userId);
}
