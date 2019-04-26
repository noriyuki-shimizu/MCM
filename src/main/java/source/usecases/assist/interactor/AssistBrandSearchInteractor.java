package source.usecases.assist.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.dto.assist.BrandOutputData;
import source.domain.entity.list.MBrandList;
import source.domain.repository.MBrandRepository;
import source.usecases.assist.IAssistBrandSearchUsecase;

import java.util.List;

@Component
public class AssistBrandSearchInteractor implements IAssistBrandSearchUsecase {

    @Autowired
    private MBrandRepository repository;

    @Override
    public List<BrandOutputData> getAssistBrandList() {
        MBrandList mBrandList = MBrandList.of(this.repository.findAll());

        return mBrandList.convertAssistBrandOutputData();
    }

}
