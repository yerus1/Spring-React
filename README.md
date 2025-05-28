const projects = [
  {
    projectName: "REST API",
    projectDescription: "Spring Boot starter project for hands-on REST API practice",
    technologies: ["Java", "Spring Boot", "SQL", "React"],
    codeSnippet: 
`@Service
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
}`
  }
];

