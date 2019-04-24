package com.danieldelfim.webdescontos.services;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
				array = line.split(";");

				categoryRepository
						.save(new Category(null, array[0].trim(), array[1].trim(), Long.parseLong(array[2].trim())));
			}
		} catch (Exception e) {
			log.error("Erro ao criar a category." + array, e);
		}

	}

	private Map<String, Category> allCategories = new HashMap<>();

	private void loadCategories() {
		for (Category category : categoryRepository.findAll()) {
			allCategories.put(category.getUrlSeoCategory(), category);
		}
	}

	public void createStores() {
		loadCategories();

		String[] array = null;
		try {
			File f = new File("src/main/resources/stores.txt");
			List<String> lines = FileUtils.readLines(f, "UTF-8");
			for (String line : lines) {
				array = line.split(";");

				List<Category> categories = new ArrayList<>();
				for (int i = 6; i < array.length; i = i + 1) {
					if (!StringUtils.isEmpty(array[i])) {
						categories.add(allCategories.get(array[i]));
					}
				}
				storeRepository.save(new Store(null, Long.parseLong(array[0].trim()), array[1].trim(), array[2].trim(),
						array[3].trim(), array[4].trim(), array[5].trim(), categories));
			}
		} catch (Exception e) {
			log.error("Erro ao criar a store." + array, e);
		}
	}

}
