# Project Name
SpringBoot-React

## Description
A Spring Security protected REST controller endpoint for processing financial transactions securely, efficiently handling high throughput and returning detailed receipts.,

```Technologies
Java
Spring Boot
PostgreSQL
```


## Code Snippet
```java
@Service
public class ProductService {
  private final List<String> categories = Arrays.asList(
    "Electronics", "Clothing", "Books", "Home & Kitchen", "Beauty"
  );

  @Autowired
  private ProductRepository productRepo;

  public ProductProfile getProductProfile() {
    return ProductProfile.builder()
      .popularCategory("Electronics")
      .availableCategories(this.categories)
      .totalProducts(productRepo.countAll())
      .outOfStockProducts(productRepo.countOutOfStock())
      .build();
  }
}
```


