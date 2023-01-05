package invozone.ecommerce.shopping.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import invozone.ecommerce.shopping.dto.CategoryDto;
import invozone.ecommerce.shopping.dto.UpdateCategoryDto;
import invozone.ecommerce.shopping.exceptions.RequestValidationException;
import invozone.ecommerce.shopping.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    MainService mainService;


    @PostMapping
    public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryDto categoryDto, BindingResult errors){
        if (errors.hasErrors()) {
            throw new RequestValidationException(errors);
        }
        return ResponseEntity.ok(mainService.createCategory(categoryDto));
    }

    @GetMapping
    public ResponseEntity<?> getCategory(){
        return ResponseEntity.ok(mainService.getCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable("id") String id){
        return ResponseEntity.ok(mainService.getCategoryById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable("id") String id){
        return ResponseEntity.ok(mainService.deleteCategoryById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategoryById(@PathVariable("id") String id, @Valid @RequestBody UpdateCategoryDto categoryDto, BindingResult errors){
        if (errors.hasErrors()) {
            throw new RequestValidationException(errors);
        }
        return ResponseEntity.ok(mainService.updateCategoryById(id,categoryDto));
    }
}
