package invozone.ecommerce.shopping.service;

import invozone.ecommerce.shopping.dto.CategoryDto;
import invozone.ecommerce.shopping.dto.ProductDto;
import invozone.ecommerce.shopping.dto.UpdateCategoryDto;
import invozone.ecommerce.shopping.dto.UpdateProductDto;
import invozone.ecommerce.shopping.entities.Category;
import invozone.ecommerce.shopping.entities.Product;
import invozone.ecommerce.shopping.enums.Responses;
import invozone.ecommerce.shopping.exceptions.CustomBadRequest;
import invozone.ecommerce.shopping.repo.CategoryRepository;
import invozone.ecommerce.shopping.repo.ProductRepository;
import invozone.ecommerce.shopping.utils.Utility;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MainService {

    @Autowired
    CategoryRepository categoryRepository;


    @Autowired
    ProductRepository productRepository;

    private static final ModelMapper modelMapper= Utility.getMapperObject();

    public Map<String, Object> createCategory(CategoryDto categoryDto){
        Map<String, Object> response ;
        Category category=modelMapper.map(categoryDto,Category.class);
        categoryRepository.save(category);
        response = Utility.getResponse(Responses.SUCCESS, "", category);
        return response;
    }

    public Map<String, Object> getCategory(){
        Map<String, Object> response ;
        List<Category> categories=categoryRepository.findAll();
        if (!(categories.size() >0)){
            response = Utility.getResponse(Responses.SUCCESS, "No Categories Found", categories);
        }else{
            response = Utility.getResponse(Responses.SUCCESS, "", categories);
        }
        return response;
    }

    public Map<String, Object> getCategoryById(String id){
        Map<String, Object> response ;
        Category category=categoryRepository.findById(Integer.valueOf(id)).orElse(null);
        if (category==null){
            response = Utility.getResponse(Responses.SUCCESS, "No Category Found", category);
        }else {
            response = Utility.getResponse(Responses.SUCCESS, "", category);
        }
        return response;
    }

    public Map<String, Object> deleteCategoryById(String id){
        Map<String, Object> response ;
        Category category=categoryRepository.findById(Integer.valueOf(id)).orElse(null);
        if (category==null){
            throw new CustomBadRequest("1000","Please Provide A Valid Category Id");
        }
        categoryRepository.delete(category);
        response = Utility.getResponse(Responses.SUCCESS, "", "Category Deleted Successfully");
        return response;
    }

    public Map<String, Object> updateCategoryById(String id, UpdateCategoryDto categoryDto){
        Map<String, Object> response ;
        Category category=categoryRepository.findById(Integer.valueOf(id)).orElse(null);
        if (category==null){
            throw new CustomBadRequest("1000","Please Provide A Valid Category Id");
        }
        modelMapper.map(categoryDto,category);
        category = categoryRepository.save(category);
        response = Utility.getResponse(Responses.SUCCESS, "Category Updated Successfully", category);
        return response;
    }


    public Map<String, Object> createProduct(ProductDto productDto){
        Map<String, Object> response ;
        Product product=modelMapper.map(productDto,Product.class);
        Category category=categoryRepository.findById(productDto.getCategoryId()).orElse(null);
        if (category==null){
            throw new CustomBadRequest("1000","Please Provide A Valid Category Id");
        }
        product.setCategoryId(category);
        productRepository.save(product);
        response = Utility.getResponse(Responses.SUCCESS, "", product);
        return response;
    }

    public Map<String, Object> getProduct(){
        Map<String, Object> response ;
        List<Product> products=productRepository.findAll();
        if (!(products.size()>0)){
            response = Utility.getResponse(Responses.SUCCESS, "No Products Found", products);
        }else {
            response = Utility.getResponse(Responses.SUCCESS, "", products);
        }
        return response;
    }

    public Map<String, Object> getProductById(String id){
        Map<String, Object> response ;
        Product product=productRepository.findById(Integer.valueOf(id)).orElse(null);
        if (product==null){
            response = Utility.getResponse(Responses.SUCCESS, "No Product Found", product);
        }else {
            response = Utility.getResponse(Responses.SUCCESS, "", product);
        }
        return response;
    }

    public Map<String, Object> deleteProductById(String id){
        Map<String, Object> response ;
        Product product=productRepository.findById(Integer.valueOf(id)).orElse(null);
        if (product==null){
            throw new CustomBadRequest("1000","Please Provide A Valid Product Id");
        }
        productRepository.delete(product);
        response = Utility.getResponse(Responses.SUCCESS, "", "Product Deleted Successfully");
        return response;
    }

    public Map<String, Object> updateProductById(String id, UpdateProductDto productDto){
        Map<String, Object> response ;
        Product product=productRepository.findById(Integer.valueOf(id)).orElse(null);
        if (product==null){
            throw new CustomBadRequest("1000","Please Provide A Valid Product Id");
        }
        if (productDto.getCategoryId()!=null){
            Category category=categoryRepository.findById(productDto.getCategoryId()).orElse(null);
            if (category==null){
                throw new CustomBadRequest("1000","Please Provide A Valid Category Id");
            }
            product.setCategoryId(category);
        }
        modelMapper.map(productDto,product);
        product = productRepository.save(product);
        response = Utility.getResponse(Responses.SUCCESS, "Product Updated Successfully", product);
        return response;
    }
}
