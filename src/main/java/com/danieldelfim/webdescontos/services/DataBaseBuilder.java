package com.danieldelfim.webdescontos.services;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danieldelfim.webdescontos.domain.Category;
import com.danieldelfim.webdescontos.domain.Store;
import com.danieldelfim.webdescontos.repository.CategoryRepository;
import com.danieldelfim.webdescontos.repository.StoreRepository;

@Service
public class DataBaseBuilder {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	public void createCategories() {
		String[] array = null;
		try {
			File f = new File("src/main/resources/categories.txt");
			List<String> lines = FileUtils.readLines(f, "UTF-8");
			for (String line : lines) {
				array = line.split(",");
				categoryRepository.save(new Category(null, 
						array[0].trim(), 
						array[1].trim(), 
						null));
			}
		} catch (Exception e) {
			log.error("Erro ao criar a category." + array, e);
		}

	}

	public void createStores() {
		String[] array = null;
		try {
			File f = new File("src/main/resources/stores.txt");
			List<String> lines = FileUtils.readLines(f, "UTF-8");
			for (String line : lines) {
				array = line.split(",");
				if(array.length == 4) {
					storeRepository.save(new Store(null, 
							array[0].trim(), 
							array[1].trim(), 
							array[1].trim(), 
							array[2].trim(),
							array[2].trim(),
							null));
				} else {
					storeRepository.save(new Store(null, 
							array[0].trim(), 
							array[1].trim(), 
							array[1].trim(), 
							array[2].trim(),
							array[2].trim(),
							null));
				}
			}
		} catch (Exception e) {
			log.error("Erro ao criar a store." + array, e);
		}
	}

	
}
