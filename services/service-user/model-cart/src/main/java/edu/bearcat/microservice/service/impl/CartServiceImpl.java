package edu.bearcat.microservice.service.impl;

import edu.bearcat.microservice.dao.CartDao;
import edu.bearcat.microservice.entities.Cart;
import edu.bearcat.microservice.entities.ProductVO;
import edu.bearcat.microservice.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author haohao
 * @since 2019-04-10
 */
@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public Cart selectByIds(Cart cart) {
        return cartDao.selectByIds(cart);
    }

    @Override
    public Cart selectByCartId(Cart cart) {
        return cartDao.selectByCartId(cart);
    }

    @Override
    public boolean insertCart(Cart cart) {
        return cartDao.insertCart(cart);
    }

    @Override
    public boolean insertCartDetails(ProductVO productVO) {
        return cartDao.insertCartDetails(productVO);
    }

    @Override
    public boolean updateCart(Cart cart) {
        return cartDao.updateCart(cart);
    }

    @Override
    public boolean updateCartDetails(ProductVO productVO) {
        return cartDao.updateCartDetails(productVO);
    }

    @Override
    public boolean deleteCart(Cart cart) {
        return cartDao.deleteCart(cart);
    }

    @Override
    public boolean deleteCartDetails(ProductVO productVO) {
        return cartDao.deleteCartDetails(productVO);
    }
}
