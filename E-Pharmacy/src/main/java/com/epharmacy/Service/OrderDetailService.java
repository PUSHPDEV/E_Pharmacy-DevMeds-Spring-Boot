package com.epharmacy.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epharmacy.Configuration.JwtRequestFilter;
import com.epharmacy.Entity.Medicine;
import com.epharmacy.Entity.OrderDetail;
import com.epharmacy.Entity.OrderInput;
import com.epharmacy.Entity.OrderMedicineQuantity;
import com.epharmacy.Entity.User;
import com.epharmacy.Repository.MedicineRepo;
import com.epharmacy.Repository.OrderDetailDao;
import com.epharmacy.Repository.UserRepo;

@Service
public class OrderDetailService {

	private static final String ORDER_PLACED = "Placed";

	@Autowired
	private MedicineRepo medicineRepo;

	@Autowired
	private OrderDetailDao orderDetailDao;

	@Autowired
	private UserRepo userRepo;

	public void placeOrder(OrderInput orderInput) {
		List<OrderMedicineQuantity> medicineQuantityList = orderInput.getOrderMedicineQuantityList();

		for (OrderMedicineQuantity o : medicineQuantityList) {

			Medicine medicine = medicineRepo.findById(o.getMedicineId()).get();

			String currentUser = JwtRequestFilter.CURRENT_USER;
			User user = userRepo.findById(currentUser).get();

			// creating object of order detail
			OrderDetail orderDetail = new OrderDetail(

					orderInput.getFullName(), orderInput.getFullAddress(), orderInput.getContactNumber(),
					orderInput.getAlternateContactNumber(), ORDER_PLACED,
					medicine.getMedicineDiscountedPrice() * o.getQuantity(), medicine, user

			);

			orderDetailDao.save(orderDetail);
		}

	}
}
