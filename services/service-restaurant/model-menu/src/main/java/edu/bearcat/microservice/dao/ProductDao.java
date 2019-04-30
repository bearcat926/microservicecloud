package edu.bearcat.microservice.dao;

import edu.bearcat.microservice.entities.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author haohao
 * @since 2019-04-11
 */
@Mapper
public interface ProductDao{
    public Product selectById(Product product);

    public List<Product> selectProductList(Product product);

    public boolean insertProduct(Product product);

    public boolean updateProduct(Product product);

    public boolean deleteProduct(Product product);
}
