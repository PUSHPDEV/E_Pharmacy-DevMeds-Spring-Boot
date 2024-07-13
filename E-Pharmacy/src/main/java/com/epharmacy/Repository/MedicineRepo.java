package com.epharmacy.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.epharmacy.Entity.Medicine;


public interface MedicineRepo extends CrudRepository<Medicine, Integer>{

	public List<Medicine> findAll(Pageable pageable);
	
	// This is used for searching the medicine
//	public List<Medicine> findByMedicineNameContainingIgnoreOrMedicineDescriptionContainingIgnore(
//			String key1, String key2, Pageable pageable
//			);

	public List<Medicine> findByMedicineNameContainingIgnoreCaseOrMedicineDescriptionContainingIgnoreCase(String searchKey,
			String searchKey2, Pageable pageable);
	

}
