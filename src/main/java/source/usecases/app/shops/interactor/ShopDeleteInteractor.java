package source.usecases.app.shops.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.Shops;
import source.domain.repository.db.ShopsRepository;
import source.usecases.app.shops.IShopDeleteUsecase;

import javax.transaction.Transactional;

@Component
@Transactional
public class ShopDeleteInteractor implements IShopDeleteUsecase {

    @Autowired
    private ShopsRepository repository;

    @Override
    public Shops delete(Long id) {
        return this.repository.deleteById(id);
    }
}
