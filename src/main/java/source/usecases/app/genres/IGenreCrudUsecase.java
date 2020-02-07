package source.usecases.app.genres;

import source.usecases.dto.request.genre.GenreCreateRequestModel;
import source.usecases.dto.request.genre.GenreUpdateRequestModel;
import source.usecases.dto.response.genre.*;

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
    public GenreKeyValueResponseViewModels acceptKeyValues(Long userId);

    /**
     * 選択可能な色の一覧を取得します.
     * 引数の primary key の有無により以下の色の一覧を取得する.
     * 無：登録されている色以外の色一覧を取得
     * 有：登録されている色以外の色一覧 + 主キーに紐づく Genre.color も含めた選択可能な色一覧を取得
     *
     * @param userId ユーザID
     * @param id primary key
     * @return プルダウン + 画面描画のための DTO
     */
    public GenreColorResponseViewModels acceptCanSelectedColors(Long userId, Long id);

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
