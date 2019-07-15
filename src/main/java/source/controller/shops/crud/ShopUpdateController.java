package source.controller.shops.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import source.controller.shops.ShopsController;
import source.domain.dto.input.shops.ShopUpdateInputData;
import source.usecases.shops.IShopUpdateUsecase;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ShopUpdateController extends ShopsController {

    @Autowired
    private IShopUpdateUsecase usecase;

    @PutMapping(value = "/")
    public String updateHandler(@PathVariable("userId") Long userId, @RequestParam("inputDataJson") String inputDataJson) {
        try {
            ShopUpdateInputData inputData = super.MAPPER.readValue(inputDataJson, ShopUpdateInputData.class);

            return super.MAPPER.writeValueAsString(this.usecase.update(userId, inputData));
        } catch (JsonProcessingException jpe) {
            jpe.printStackTrace();

            return null;
        } catch (IOException ioe) {
            ioe.printStackTrace();

            return null;
        }
    }
}
