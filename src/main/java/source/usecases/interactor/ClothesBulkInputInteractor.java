package source.usecases.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.MClothes;
import source.domain.repository.MClothesRepository;
import source.usecases.IClothesBulkInputUsecase;

import java.util.List;

@Component
public class ClothesBulkInputInteractor implements IClothesBulkInputUsecase {

    @Autowired
    private MClothesRepository repository;

    public void bulkInput(List<MClothes> mClothesList) {
    }
}
