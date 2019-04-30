package edu.bearcat.microservice.controller;


import edu.bearcat.microservice.entities.Product;
import edu.bearcat.microservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author haohao
 * @since 2019-04-11
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping(value = "/id",method = RequestMethod.GET)
    public Product selectById(@RequestBody Product product) {
        return productService.selectById(product);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Product> selectProductList(@RequestBody Product product) {
        return productService.selectProductList(product);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public boolean insertProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public boolean updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public boolean deleteProduct(@RequestBody Product product) {
        return productService.deleteProduct(product);
    }
}
