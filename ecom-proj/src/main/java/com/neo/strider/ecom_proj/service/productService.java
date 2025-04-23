package com.neo.strider.ecom_proj.service;

import com.neo.strider.ecom_proj.model.product;
import com.neo.strider.ecom_proj.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class productService {

    @Autowired
    private productRepository productrepository;

    public product addproducts(product prod){
        return productrepository.save(prod);
    }

    public List<product> getproducts() {
        return productrepository.findAll();
    }

    public product getProductById(int prodId) {
        return productrepository.findById(prodId).orElse(null);
    }

    public product addProduct(product prod, MultipartFile imageFile) throws IOException {
        prod.setImageName(imageFile.getOriginalFilename());
        prod.setImageType(imageFile.getContentType());
        prod.setImageData(imageFile.getBytes());
        return productrepository.save(prod);
    }

    public product updateProduct(int productId, product product, MultipartFile imageFile) throws IOException {
        product.setImageData(imageFile.getBytes());
        product.setImageType(imageFile.getContentType());
        product.setImageName(imageFile.getOriginalFilename());
        return productrepository.save(product);
    }

    public void deleteProductById(int productId) {
        productrepository.deleteById(productId);
    }

    public List<product> searchProducts(String keyword) {
        return productrepository.searchProducts(keyword);
    }
}

