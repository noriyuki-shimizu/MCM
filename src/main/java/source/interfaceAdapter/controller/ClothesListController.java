package source.interfaceAdapter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import source.domain.dto.clothes.ClothesSearchInputData;
import source.usecases.IClothesSearchUsecase;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/clothesList")
public class ClothesListController {

    @Autowired
    private IClothesSearchUsecase usecase;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search() {
        ClothesSearchInputData inputData = ClothesSearchInputData.builder()
                .brandId(0)
                .genreId(0)
                .shopId(0)
                .morePrice(0)
                .lessPrice(0)
                .buyDate(new Date())
                .deleteFlag(false)
                .build();

        return this.usecase.search(inputData);
    }
}
