# Project Name
Spring-React

## Description
A Spring Security protected REST controller endpoint for processing financial transactions securely, efficiently handling high throughput and returning detailed receipts and  efficiently handling high throughput and returning detailed receipts

## Technologies
[Java, Spring Boot, SQL, React]

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


