package com.epharmacy.Entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer medicineId;
	private String medicineName;
	@Column(length = 2000)
	private String medicineDescription;
	private Double medicineDiscountedPrice;
	private Double medicineActualPrice;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "medicine_images",

			joinColumns = {

					@JoinColumn(name = "medicine_id")

			}, inverseJoinColumns = { @JoinColumn(name = "image_id") }

	)
	private Set<ImageModel> medicineImages;

	public Medicine() {
		super();

	}

	public Medicine(Integer medicineId, String medicineName, String medicineDescription, Double medicineDiscountedPrice,
			Double medicineActualPrice) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.medicineDescription = medicineDescription;
		this.medicineDiscountedPrice = medicineDiscountedPrice;
		this.medicineActualPrice = medicineActualPrice;
	}

	public Set<ImageModel> getMedicineImages() {
		return medicineImages;
	}

	public void setMedicineImages(Set<ImageModel> medicineImages) {
		this.medicineImages = medicineImages;
	}

	public Integer getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getMedicineDescription() {
		return medicineDescription;
	}

	public void setMedicineDescription(String medicineDescription) {
		this.medicineDescription = medicineDescription;
	}

	public Double getMedicineDiscountedPrice() {
		return medicineDiscountedPrice;
	}

	public void setMedicineDiscountedPrice(Double medicineDiscountedPrice) {
		this.medicineDiscountedPrice = medicineDiscountedPrice;
	}

	public Double getMedicineActualPrice() {
		return medicineActualPrice;
	}

	public void setMedicineActualPrice(Double medicineActualPrice) {
		this.medicineActualPrice = medicineActualPrice;
	}

}
