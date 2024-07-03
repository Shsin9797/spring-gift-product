package gift.controller;

import gift.dto.CreateProduct;
import gift.dto.EditProduct;
import gift.dto.ProductDTO;
import gift.dto.ProductDetailDTO;
import gift.entity.Product;
import gift.service.ProductService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@RestController("/api/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/")
    public void createProduct(@RequestBody CreateProduct.Request request){ productService.createProduct(request);}

    @GetMapping("/")
    public Map<Long,ProductDTO> getAllProducts() {
        return  productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDetailDTO getProductDetail(@PathVariable Long id) { return productService.getProductDetail(id);}

    @PutMapping("/{id}")
    public ProductDetailDTO putProductDetail(
            @PathVariable Long id,
            @RequestBody EditProduct.Request request
    ) { return productService.editProductDetail(id,request);}

    @DeleteMapping("/{id}")
    public ProductDetailDTO deleteProductDetail( @PathVariable Long id ) {
        return productService.deleteProduct(id);
    }
}
