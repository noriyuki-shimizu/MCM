package source.usecases.clothes.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Clothes;
import source.domain.repository.db.ClothesRepository;
import source.usecases.clothes.IClothesBulkInputUsecase;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class ClothesBulkInputInteractor implements IClothesBulkInputUsecase {

    @Autowired
    private ClothesRepository repository;

    public void bulkInput(List<Clothes> clothesList) {
    }
}
