package source.presenter.genre;

import org.springframework.stereotype.Component;
import source.domain.entity.db.Genres;
import source.controller.genres.crud.response.GenreResponseModel;
import source.controller.genres.crud.response.GenreResponseViewModel;
import source.domain.presenter.genre.IGenreMappingPresenter;

@Component
public class GenreMappingPresenter implements IGenreMappingPresenter {
    @Override
    public GenreResponseViewModel mapping(Genres genre) {
        GenreResponseModel model = GenreResponseModel.of(
                genre.getId(),
                genre.getName(),
                genre.getColor()
        );
        return GenreResponseViewModel.of(model);
    }
}
