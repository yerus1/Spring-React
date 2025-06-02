

```Technologies
Java
Spring Boot
PostgreSQL
```


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


