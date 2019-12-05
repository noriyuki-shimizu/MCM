package source.usecases.app.clothes.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.usecases.dto.input.clothes.ClothesUpdateInputData;
import source.domain.entity.Clothes;
import source.domain.repository.db.ClothesRepository;
import source.usecases.app.clothes.IClothesUpdateUsecase;

@Component
public class ClothesUpdateInteractor implements IClothesUpdateUsecase {

    @Autowired
    private ClothesRepository repository;

    @Override
    public Clothes update(Long userId, ClothesUpdateInputData inputData) {
        return this.repository.save(inputData.toEntity(userId));
    }
}
