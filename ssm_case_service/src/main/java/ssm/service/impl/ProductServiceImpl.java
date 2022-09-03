package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.dao.IProductDao;
import ssm.domain.Product;
import ssm.service.IProductService;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    @Override
    public Product findById(Integer productId) throws Exception {
        return productDao.findById(productId);
    }

    @Override
    public void alter(Product product) {
        productDao.alter(product);
    }
}
