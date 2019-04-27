package source.domain.entity.list;

import lombok.Value;
import source.domain.dto.assist.ShopOutputData;
import source.domain.entity.MShop;

import java.util.List;
import java.util.stream.Collectors;

@Value(staticConstructor = "of")
public class MShopList {

    private List<MShop> values;

    public List<ShopOutputData> convertAssistShopOutputData() {
        return this.values.stream().map(value -> {
            return ShopOutputData.of(value.getId(), value.getName());
        }).collect(Collectors.toList());
    }

}
