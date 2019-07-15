package source.controller.shops.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import source.controller.shops.ShopsController;
import source.domain.dto.input.shops.ShopSearchInputData;
import source.usecases.shops.IShopSearchUsecase;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ShopsSearchController extends ShopsController {

    @Autowired
    private IShopSearchUsecase usecase;

    @GetMapping(value = "/")
    public String searchHandler(@PathVariable("userId") Long userId, @RequestParam("inputDataJson") String inputDataJson) {
        try {
            ShopSearchInputData inputData = super.MAPPER.readValue(inputDataJson, ShopSearchInputData.class);

            return super.MAPPER.writeValueAsString(this.usecase.search(userId, inputData));
        } catch (JsonProcessingException jpe) {
            jpe.printStackTrace();

            return null;
        } catch (IOException ioe) {
            ioe.printStackTrace();

            return null;
        }
    }

}
