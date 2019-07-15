package source.usecases.shops.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import source.domain.entity.Shops;
import source.domain.repository.db.ShopsRepository;
import source.usecases.shops.IShopDeleteUsecase;

public class ShopDeleteInteractor implements IShopDeleteUsecase {

    @Autowired
    private ShopsRepository repository;

    @Override
    public Shops delete(Long id) {
        return this.repository.deleteById(id);
    }
}
