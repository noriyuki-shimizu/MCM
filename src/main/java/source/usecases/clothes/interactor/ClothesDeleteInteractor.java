package source.usecases.clothes.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Clothes;
import source.domain.repository.db.ClothesRepository;
import source.usecases.clothes.IClothesDeleteUsecase;

import javax.transaction.Transactional;

@Component
@Transactional
public class ClothesDeleteInteractor implements IClothesDeleteUsecase {

    @Autowired
    private ClothesRepository repository;

    @Override
    public Clothes delete(Long id) {
        return this.repository.deleteById(id);
    }
}
