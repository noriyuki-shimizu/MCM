package source.usecases.app.assist.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.usecases.dto.output.assist.BrandOutputData;
import source.domain.entity.Brands;
import source.domain.repository.db.BrandsRepository;
import source.presenter.assist.IAssistBrandSearchPresenter;
import source.usecases.app.assist.IAssistBrandSearchUsecase;

import java.util.List;

@Component
public class AssistBrandSearchInteractor implements IAssistBrandSearchUsecase {

    @Autowired
    private BrandsRepository repository;

    @Autowired
    private IAssistBrandSearchPresenter presenter;

    @Override
    public List<BrandOutputData> getAssistBrandList() {
        List<Brands> brandsList = this.repository.findAll();

        return this.presenter.handle(brandsList);
    }

}
