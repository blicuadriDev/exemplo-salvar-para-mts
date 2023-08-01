package com.godknows.exemplosalvarparamts.repositories;

import com.godknows.exemplosalvarparamts.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
