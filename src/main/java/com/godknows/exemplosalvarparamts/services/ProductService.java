package com.godknows.exemplosalvarparamts.services;

import com.godknows.exemplosalvarparamts.dtos.CategoryDTO;
import com.godknows.exemplosalvarparamts.dtos.ProductDTO;
import com.godknows.exemplosalvarparamts.entities.Category;
import com.godknows.exemplosalvarparamts.entities.Product;
import com.godknows.exemplosalvarparamts.repositories.CategoryRepository;
import com.godknows.exemplosalvarparamts.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository catRepository;

    /*
    Json do relacionamento Many-to-Many:
        {
        "name": "Produto novo",
        "price": 1000.0,
        "categories": [
                {
                    "id": 2
                },
                {
                    "id": 3
                }
            ]
        }
     */
    public ProductDTO insert(ProductDTO dto){

        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());

        for(CategoryDTO catDTO : dto.getCategories()){

            //Abaixo o objeto está transient(sem gerenciamento da JPA) pq instanciamos ele na mao. Ou seja, não pegar o name.
            //Category cat = new Category();
            //cat.setId(catDTO.getId());

            //Abaixo o objeto é gerenciado pela JPA e consnequentemente irá puxar o name da categoria
            Category cat = catRepository.getReferenceById(catDTO.getId());


            entity.getCategories().add(cat);
        }

        entity = repository.save(entity);

        return new ProductDTO(entity);

    }

}
