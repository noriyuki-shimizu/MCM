package source.controller.shops.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import source.controller.shops.ShopsController;
import source.usecases.app.shops.IShopCrudUsecase;
import source.controller.shops.crud.request.ShopCreateRequestModel;
import source.controller.shops.crud.request.ShopUpdateRequestModel;
import source.controller.shops.crud.response.ShopResponseViewModel;
import source.controller.shops.crud.response.ShopResponseViewModels;

@Slf4j(topic = "source.controller.shops.crud")
@RestController
@RequiredArgsConstructor
public class ShopCrudController extends ShopsController {
    @Autowired
    private IShopCrudUsecase usecase;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ShopResponseViewModel handleCreate(
            @PathVariable("userId") Long userId,
            @RequestBody ShopCreateRequestModel requestData
    ) throws JsonProcessingException {
        log.info("create -> user: {}, data: {}", userId, MAPPER.writeValueAsString(requestData));
        return this.usecase.create(userId, requestData);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("userId") Long userId, @PathVariable("id") Long id) {
        log.info("delete -> user: {}, id: {}", userId, id);
        this.usecase.delete(id);
    }

    @PutMapping(value = "/{id}/restoration")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleRestoration(@PathVariable("userId") Long userId, @PathVariable("id") Long id) {
        log.info("restoration -> user: {}, id: {}", userId, id);
        this.usecase.restoration(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ShopResponseViewModels handleSearch(@PathVariable("userId") Long userId) {
        return this.usecase.search(userId);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShopResponseViewModel handleSearchById(@PathVariable("id") Long id) {
        return this.usecase.searchById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(
            @PathVariable("userId") Long userId,
            @PathVariable("id") Long id,
            @RequestBody ShopUpdateRequestModel requestData
    ) throws JsonProcessingException {
        log.info("update -> user: {}, data: {}", userId, MAPPER.writeValueAsString(requestData));
        this.usecase.update(userId, id, requestData);
    }
}
