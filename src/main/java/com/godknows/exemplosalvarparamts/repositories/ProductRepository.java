package com.godknows.exemplosalvarparamts.repositories;

import com.godknows.exemplosalvarparamts.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
