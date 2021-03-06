package edu.bearcat.microservice.dao;

import edu.bearcat.microservice.entities.Cart;
import edu.bearcat.microservice.entities.ProductVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 购物车表 Mapper 接口
 * </p>
 *
 * @author haohao
 * @since 2019-04-10
 */
@Mapper
public interface CartDao {

    public Cart selectByIds(Cart cart);

    public Cart selectByCartId(Cart cart);

    public boolean insertCart(Cart cart);

    public boolean insertCartDetails(ProductVO productVO);

    public boolean updateCart(Cart cart);

    public boolean updateCartDetails(ProductVO productVO);

    public boolean deleteCart(Cart cart);

    public boolean deleteCartDetails(ProductVO productVO);
}
