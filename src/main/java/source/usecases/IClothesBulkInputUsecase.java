package source.usecases;

import source.domain.entity.MClothes;

import java.util.List;

public interface IClothesBulkInputUsecase {

    public void bulkInput(List<MClothes> mClothesList);

}
