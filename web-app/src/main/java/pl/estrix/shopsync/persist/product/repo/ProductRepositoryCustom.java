package pl.estrix.shopsync.persist.product.repo;

import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.model.ProductSearchCriteriaDto;
import pl.estrix.shopsync.persist.product.model.ProductDao;

import java.util.List;

public interface ProductRepositoryCustom {

    List<ProductDao> find(ProductSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria);

    long findCount(ProductSearchCriteriaDto searchCriteria);
}
