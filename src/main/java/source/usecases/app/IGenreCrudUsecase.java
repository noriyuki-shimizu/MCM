package source.usecases.app;

import source.controller.genres.assist.response.GenreColorResponseViewModels;
import source.controller.genres.assist.response.GenreKeyValueResponseViewModels;
import source.controller.genres.crud.request.GenreCreateRequestModel;
import source.controller.genres.crud.request.GenreUpdateRequestModel;
import source.controller.genres.crud.response.GenreResponseViewModel;
import source.controller.genres.crud.response.GenreResponseViewModels;
import source.controller.genres.crud.response.TotalPricePerGenreViewModels;

import java.util.Optional;

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
    GenreKeyValueResponseViewModels acceptKeyValues(final Long userId);

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
    GenreColorResponseViewModels acceptCanSelectedColors(final Long userId, final Optional<Long> id);

    /**
     * 新規作成を行います.
     *
     * @param userId ユーザID
     * @param requestData 画面からの入力値
     * @return 画面描画するための DTO
     */
    GenreResponseViewModel create(final Long userId, final GenreCreateRequestModel requestData);

    /**
     * 物理削除を行います.
     *
     * @param id primary key
     */
    void delete(final Long id);

    /**
     * 検索を行います.
     *
     * @param userId ユーザID
     * @return 画面描画するための DTO List
     */
    GenreResponseViewModels search(final Long userId);

    /**
     * 1件検索を行います.
     *
     * @param id primary key
     * @return 画面描画するための DTO
     */
    GenreResponseViewModel searchById(final Long id);

    /**
     * 更新を行います.
     *
     * @param userId ユーザID
     * @param id primary key
     * @param requestData 画面からの入力値
     */
    void update(final Long userId, final Long id, final GenreUpdateRequestModel requestData);

    /**
     * ジャンルごとの合計金額を取得します.
     *
     * @param userId ユーザID
     * @return 画面描画するための DTO
     */
    TotalPricePerGenreViewModels acceptTotalPricePerGenre(final Long userId);
}
