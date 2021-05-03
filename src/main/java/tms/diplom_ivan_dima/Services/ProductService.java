package tms.diplom_ivan_dima.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tms.diplom_ivan_dima.Model.Product;
import tms.diplom_ivan_dima.Repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product) { //добавляем товар
        productRepository.save(product);
    }

    public void deleteProductBYId(long id) { //удаление товара по Id
        productRepository.deleteById(id);
    }

    public void deleteProductByItsName(String name) { //удаление товара по наименованию
        productRepository.deleteProductByName(name);
    }

    public boolean existProductById(long id) { //проверка на наличие товара нпо ID
        return productRepository.existsById(id);
    }

    public Product getProductById(long id) { //нахождение товара по ID
        return productRepository.getOne(id);
    }

    public Product getProductByName(String name) {  //нахождение товара по Наименованию
        return productRepository.getProductByName(name);
    }

    public void editProductDescription(String name, String description) {  //добавление описания продукта
        Product productUpdateDescription = productRepository.getProductByName(name);
        productUpdateDescription.setDescription(description);
        productRepository.save(productUpdateDescription);
    }

    public void editProductPrice(String name, String price) { //доюавление цены продукта
        Product productUpdatePrice = productRepository.getProductByName(name);
        productUpdatePrice.setPrice(price);
        productRepository.save(productUpdatePrice);
    }
}
