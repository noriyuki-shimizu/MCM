package source.controller.genres.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import source.controller.genres.GenresController;
import source.usecases.app.IGenreCrudUsecase;
import source.controller.genres.crud.request.GenreCreateRequestModel;
import source.controller.genres.crud.request.GenreUpdateRequestModel;
import source.controller.genres.crud.response.GenreResponseViewModel;
import source.controller.genres.crud.response.GenreResponseViewModels;
import source.controller.genres.crud.response.TotalPricePerGenreViewModels;

@Slf4j(topic = "source.controller.genres.crud")
@RestController
@RequiredArgsConstructor
public class GenreCrudController extends GenresController {
    @Autowired
    private IGenreCrudUsecase usecase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GenreResponseViewModel handleCreate(
            @PathVariable("userId") Long userId,
            @RequestBody GenreCreateRequestModel requestData
    ) throws JsonProcessingException {
        log.info("create -> user: {}, data: {}", userId, MAPPER.writeValueAsString(requestData));
        return usecase.create(userId, requestData);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("userId") Long userId, @PathVariable("id") Long id) {
        log.info("delete -> user: {}, id: {}", userId, id);
        usecase.delete(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GenreResponseViewModels handleSearch(@PathVariable("userId") Long userId) {
        return usecase.search(userId);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GenreResponseViewModel handleSearchById(@PathVariable("id") Long id) {
        return usecase.searchById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody GenreUpdateRequestModel requestData
    ) throws JsonProcessingException {
        log.info("update -> user: {}, data: {}", userId, MAPPER.writeValueAsString(requestData));
        usecase.update(userId, id, requestData);
    }

    @GetMapping("/clothes/total-price")
    @ResponseStatus(HttpStatus.OK)
    public TotalPricePerGenreViewModels handleTotalPricePerGenre(@PathVariable("userId") Long userId) {
        return usecase.acceptTotalPricePerGenre(userId);
    }
}
