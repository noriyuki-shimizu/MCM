package source.usecases.assist.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.dto.assist.BrandOutputData;
import source.domain.entity.MBrand;
import source.domain.repository.db.MBrandRepository;
import source.presenter.assist.IAssistBrandSearchPresenter;
import source.usecases.assist.IAssistBrandSearchUsecase;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class AssistBrandSearchInteractor implements IAssistBrandSearchUsecase {

    @Autowired
    private MBrandRepository repository;

    @Autowired
    private IAssistBrandSearchPresenter presenter;

    @Override
    public List<BrandOutputData> getAssistBrandList() {
        List<MBrand> mBrandList = this.repository.findAll();

        return this.presenter.handle(mBrandList);
    }

}
