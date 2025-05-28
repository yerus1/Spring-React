@Service
public class InventoryService {
    @Autowired
    private ProductRepository productRepo;

    @Transactional
    public StockLevel updateStock(
        String productId, int change) {
      Product product = productRepo
        .findById(productId)
        .orElseThrow(); 
      product.adjustStock(change);
      productRepo.save(product);
      // Logger.info("Stock updated...");
      return product.getStockLevel();
    }
}
