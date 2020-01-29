package source.usecases.app.clothes.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.domain.entity.Clothes;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.specification.ClothesSpecification;
import source.presenter.clothes.IClothesAssistsMappingPresenter;
import source.usecases.app.clothes.IClothesAssistUsecase;
import source.usecases.dto.response.clothes.ClothesAssistResponseViewModels;

import java.util.List;

@Component
public class ClothesAssistInteractor implements IClothesAssistUsecase {
    @Autowired
    private ClothesRepository repository;

    @Autowired
    private IClothesAssistsMappingPresenter presenter;

    @Override
    public ClothesAssistResponseViewModels assist(Long userId) {
        List<Clothes> clothes = this.repository.findAll(
                Specifications.where(
                        ClothesSpecification.userIdEqual(userId)
                )
        );
        return this.presenter.mapping(clothes);
    }
}
