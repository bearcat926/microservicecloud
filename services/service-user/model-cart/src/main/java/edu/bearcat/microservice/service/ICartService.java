package edu.bearcat.microservice.service;

import edu.bearcat.microservice.entities.Cart;
import edu.bearcat.microservice.entities.ProductVO;

/**
 * <p>
 * 购物车表 服务类
 * </p>
 *
 * @author haohao
 * @since 2019-04-10
 */
public interface ICartService {

    public Cart selectByIds(Cart cart);

    public Cart selectByCartId(Cart cart);

    public boolean insertCart(Cart cart);

    public boolean insertCartDetails(ProductVO productVO);

    public boolean updateCart(Cart cart);

    public boolean updateCartDetails(ProductVO productVO);

    public boolean deleteCart(Cart cart);

    public boolean deleteCartDetails(ProductVO productVO);
}
