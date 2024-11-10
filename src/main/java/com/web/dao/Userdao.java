package com.web.dao;
public class Webdao;
import com.web.model.Products;
import java.util.List;

public interface ProductsDAO {
    void addProduct(Products product);
    Products getProductById(int productId);
    List<Products> getAllProducts();
    void updateProduct(Products product);
    void deleteProduct(int productId);
}
