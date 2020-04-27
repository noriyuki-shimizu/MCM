package source.usecases.app;

/**
 * Clean に関するユースケースです.
 */
public interface ICleanUsecase {

    /**
     * 論理削除で削除となっているデータを物理削除します.
     */
    void cleanTables();
}
