package invozone.ecommerce.shopping.controller;

import invozone.ecommerce.shopping.dto.ProductDto;
import invozone.ecommerce.shopping.dto.UpdateProductDto;
import invozone.ecommerce.shopping.exceptions.RequestValidationException;
import invozone.ecommerce.shopping.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    MainService mainService;


    @PostMapping
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDto productDto, BindingResult errors){
        if (errors.hasErrors()) {
            throw new RequestValidationException(errors);
        }
        return ResponseEntity.ok(mainService.createProduct(productDto));
    }

    @GetMapping
    public ResponseEntity<?> getProduct(){
        return ResponseEntity.ok(mainService.getProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") String id){
        return ResponseEntity.ok(mainService.getProductById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable("id") String id){
        return ResponseEntity.ok(mainService.deleteProductById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable("id") String id, @Valid @RequestBody UpdateProductDto productDto, BindingResult errors){
        if (errors.hasErrors()) {
            throw new RequestValidationException(errors);
        }
        return ResponseEntity.ok(mainService.updateProductById(id,productDto));
    }

}
