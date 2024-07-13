package com.epharmacy.Controller;

import java.io.IOException;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.epharmacy.Entity.Medicine;
import com.epharmacy.Entity.ImageModel;
import com.epharmacy.Service.MedicineService;

@RestController
public class MedicineController {

	@Autowired
	private MedicineService medicineService;

	@PreAuthorize("hasRole('Admin')")
	@PostMapping(value = { "/addMedicine" }, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public Medicine addNewMedicine(@RequestPart("medicine") Medicine medicine,
			@RequestPart("imageFile") MultipartFile[] file)

	{

		try {
			Set<ImageModel> images = uploadImage(file);
			medicine.setMedicineImages(images);
			return medicineService.addNewMedicine(medicine);

		} catch (Exception e) {
			System.out.println(e.getMessage());

			return null;
		}
	}

	public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
		Set<ImageModel> imageModels = new HashSet<>();

		for (MultipartFile file : multipartFiles) {
			ImageModel imageModel = new ImageModel(

					file.getOriginalFilename(), file.getContentType(), file.getBytes()

			);
			imageModels.add(imageModel);
		}
		return imageModels;
	}

	@GetMapping({ "/getAllMedicines" })
	public List<Medicine> getAllMedicines(@RequestParam(defaultValue = "0") int pageNumber,
			@RequestParam(defaultValue = "") String searchKey) {
		List<Medicine> result =medicineService.getAllMedicines(pageNumber, searchKey);
		System.out.println(result.size());
		return result;

	}

	@GetMapping({ "/getMedicineDetailsById/{medicineId}" })
	public Medicine getMedicineDetailsById(@PathVariable("medicineId") Integer medicineId) {
		return medicineService.getMedicineDetailsById(medicineId);

	}

	@PreAuthorize("hasRole('Admin')")
	@DeleteMapping({ "/deleteMedicine/{medicineId}" })
	public void deleteMedicine(@PathVariable("medicineId") Integer medicineId) {

		medicineService.deleteMedicine(medicineId);
	}

	// buy-medicine
	@PreAuthorize("hasRole('User')")
	@GetMapping({ "/getMedicineDetails/{isSingleMedicineCheckout}/{medicineId}" })
	public List<Medicine> getMedicineDetails(
			@PathVariable(name = "isSingleMedicineCheckout") boolean isSingleMedicineCheckout,
			@PathVariable(name = "medicineId") Integer medicineId) {
		return medicineService.getMedicineDetails(isSingleMedicineCheckout, medicineId);

	}

}
