package source.usecases.app.clothes.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Clothes;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.specification.ClothesSpecification;
import source.presenter.clothes.IClothesListMappingPresenter;
import source.usecases.app.clothes.IClothesSearchUsecase;
import source.usecases.dto.response.clothes.ClothesResponseViewModels;

import java.util.List;

@Component
public class ClothesSearchInteractor implements IClothesSearchUsecase {

    @Autowired
    private ClothesRepository repository;

    @Autowired
    private IClothesListMappingPresenter presenter;

    public ClothesResponseViewModels search(Long userId) {
        List<Clothes> clothes = this.repository.findAll(
                Specifications
                        .where(ClothesSpecification.userIdEqual(userId))
        );
        return this.presenter.mapping(clothes);
    }
}
