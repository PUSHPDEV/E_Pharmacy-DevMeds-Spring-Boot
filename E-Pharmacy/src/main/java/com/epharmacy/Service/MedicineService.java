package com.epharmacy.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epharmacy.Entity.Medicine;
import com.epharmacy.Repository.MedicineRepo;

@Service
public class MedicineService {

	@Autowired
	private MedicineRepo medicineRepo;

	public Medicine addNewMedicine(Medicine medicine) {
		return medicineRepo.save(medicine);

	}

	public List<Medicine> getAllMedicines(int pageNumber, String searchKey) {
		Pageable pageable = PageRequest.of(pageNumber, 12);

		if (searchKey.equals("")) {
			return (List<Medicine>) medicineRepo.findAll(pageable);
		} else {
			return (List<Medicine>) medicineRepo
					.findByMedicineNameContainingIgnoreCaseOrMedicineDescriptionContainingIgnoreCase(searchKey, searchKey,
							pageable);
		}

	}

	public void deleteMedicine(Integer medicineId) {
		medicineRepo.deleteById(medicineId);
	}

	public Medicine getMedicineDetailsById(Integer medicineId) {
		return medicineRepo.findById(medicineId).get();
	}

	public List<Medicine> getMedicineDetails(boolean isSingleMedicineCheckout, Integer medicineId) {
		if (isSingleMedicineCheckout) {
			// we buy only single medicine

			List<Medicine> list = new ArrayList<>();
			Medicine medicine = medicineRepo.findById(medicineId).get();
			list.add(medicine);
			return list;

		} else {
			// we checkout entire cart

		}
		return new ArrayList<>();
	}
}
