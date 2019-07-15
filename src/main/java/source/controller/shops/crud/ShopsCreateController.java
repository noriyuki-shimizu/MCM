package source.controller.shops.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import source.controller.shops.ShopsController;
import source.domain.dto.input.shops.ShopCreateInputData;
import source.usecases.shops.IShopCreateUsecase;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ShopsCreateController extends ShopsController {

    @Autowired
    private IShopCreateUsecase usecase;

    @PostMapping(value = "/")
    public String createHandler(@PathVariable("userId") Long userId, @RequestParam("inputDataJson") String inputDataJson) {
        try {
            ShopCreateInputData inputData = super.MAPPER.readValue(inputDataJson, ShopCreateInputData.class);

            return super.MAPPER.writeValueAsString(this.usecase.create(userId, inputData));
        } catch (JsonProcessingException jpe) {
            jpe.printStackTrace();

            return null;
        } catch (IOException ioe) {
            ioe.printStackTrace();

            return null;
        }
    }
}
