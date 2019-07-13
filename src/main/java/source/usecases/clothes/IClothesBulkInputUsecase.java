package source.usecases;

import source.domain.entity.Clothes;

import java.util.List;

public interface IClothesBulkInputUsecase {

    public void bulkInput(List<Clothes> clothesList);

}
