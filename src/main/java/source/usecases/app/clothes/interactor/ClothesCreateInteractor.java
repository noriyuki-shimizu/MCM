package source.usecases.app.clothes.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.usecases.dto.request.clothes.ClothesCreateRequestData;
import source.domain.entity.Clothes;
import source.domain.repository.db.ClothesRepository;
import source.usecases.app.clothes.IClothesCreateUsecase;

import javax.transaction.Transactional;

@Component
@Transactional
public class ClothesCreateInteractor implements IClothesCreateUsecase {

    @Autowired
    private ClothesRepository repository;

    @Override
    public Clothes create(Long userId, ClothesCreateRequestData inputData) {
        return this.repository.save(inputData.toEntity(userId));
    }

}
