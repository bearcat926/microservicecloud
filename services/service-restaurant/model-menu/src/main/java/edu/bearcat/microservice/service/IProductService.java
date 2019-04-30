package edu.bearcat.microservice.service;

import edu.bearcat.microservice.entities.Product;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author haohao
 * @since 2019-04-11
 */
public interface IProductService {

    public Product selectById(Product product);

    public List<Product> selectProductList(Product product);

    public boolean insertProduct(Product product);

    public boolean updateProduct(Product product);

    public boolean deleteProduct(Product product);
}
