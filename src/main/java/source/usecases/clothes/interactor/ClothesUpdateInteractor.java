package source.usecases.clothes.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import source.domain.dto.input.clothes.ClothesUpdateInputData;
import source.domain.entity.Clothes;
import source.domain.repository.db.ClothesRepository;
import source.usecases.clothes.IClothesUpdateUsecase;

public class ClothesUpdateInteractor implements IClothesUpdateUsecase {

    @Autowired
    private ClothesRepository repository;

    @Override
    public Clothes update(Long userId, ClothesUpdateInputData inputData) {
        return this.repository.save(inputData.toEntity(userId));
    }
}
