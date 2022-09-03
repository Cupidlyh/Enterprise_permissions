package ssm.service;

import ssm.domain.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll(int page,int size) throws Exception;

    void save(Product product) throws Exception;

    Product findById(Integer productId) throws Exception;

    void alter(Product product);
}
