package source.usecases.app.images;

import source.domain.entity.Images;

public interface IImageSaveUsecase {
    public Images save(Long id, String name);
}
