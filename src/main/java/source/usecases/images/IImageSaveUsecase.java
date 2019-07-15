package source.usecases.images;

import source.domain.entity.Images;

import javax.transaction.Transactional;

@Transactional
public interface IImageCreateUsecase {
    public Images create(Images images);
}
