package edu.bearcat.microservice.service.impl;

import edu.bearcat.microservice.dao.ProductDao;
import edu.bearcat.microservice.entities.Product;
import edu.bearcat.microservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author haohao
 * @since 2019-04-11
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product selectById(Product product) {
        return productDao.selectById(product);
    }

    @Override
    public List<Product> selectProductList(Product product) {
        return productDao.selectProductList(product);
    }

    @Override
    public boolean insertProduct(Product product) {
        return productDao.insertProduct(product);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(Product product) {
        return productDao.deleteProduct(product);
    }
}
