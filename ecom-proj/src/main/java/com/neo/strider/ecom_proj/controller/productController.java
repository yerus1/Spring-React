package com.neo.strider.ecom_proj.controller;

import com.neo.strider.ecom_proj.model.product;
import com.neo.strider.ecom_proj.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class productController {

    @Autowired
    productService productservice;


    @GetMapping("/products")
    public ResponseEntity<List<product> > getproducts(){
        return new ResponseEntity<>(productservice.getproducts(), HttpStatus.OK);
    }

    @GetMapping("product/{prodId}")
    public ResponseEntity<product> getProductById(@PathVariable int prodId){
        product product= productservice.getProductById(prodId);
        if(product!=null)
            return new ResponseEntity<>(product,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart product product, @RequestPart MultipartFile imageFile){
      try  {
            product prod1 = productservice.addProduct(product, imageFile);
            return new ResponseEntity<>(prod1, HttpStatus.CREATED);
        } catch (Exception e) {
          return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId ){
        product product=productservice.getProductById(productId);
        byte[] imageFile=product.getImageData();

        return ResponseEntity.ok().
                contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);

    }

    @PutMapping("/product/{productId}")
    public ResponseEntity<String> updateProduct(@PathVariable int productId,
                                                @RequestPart product product, @RequestPart MultipartFile imageFile){
        product prod1= null;
        try {
            prod1 = productservice.updateProduct(productId,product,imageFile);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);
        }
        if(prod1!=null)
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        else
            return new ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable int productId){
        product product=productservice.getProductById(productId);
        if(product!=null) {
            productservice.deleteProductById(productId);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("products/search")
    public ResponseEntity<List<product>> searchProducts(@RequestParam String keyword){
        List<product> product=productservice.searchProducts(keyword);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
}
