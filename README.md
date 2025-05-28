# Project Name
Spring-React

## Description
This project is a personal initiative to enhance my problem-solving skills

## Technologies
[Java, Spring Boot, SQL, React,Redis]

## Code Snippet
```java
@Service
public class InventoryService {
    @Autowired
    private ProductRepository productRepo;

    @Transactional
    public StockLevel updateStock(String productId, int change) {
        Product product = productRepo.findById(productId).orElseThrow();
        product.adjustStock(change);
        productRepo.save(product);
        return product.getStockLevel();
    }
}
```


