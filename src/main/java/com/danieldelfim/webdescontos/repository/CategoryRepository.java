package com.danieldelfim.webdescontos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danieldelfim.webdescontos.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

}
