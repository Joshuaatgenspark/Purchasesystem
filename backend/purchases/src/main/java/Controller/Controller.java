package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Purchase;
import Service.Purchase_Service;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class Controller {
	
	@Autowired
	private Purchase_Service purchase_serviceservice;
	
	@PostMapping("save-purchase")
	public boolean savePurchase(@RequestBody Purchase purchase) {
		 return purchase_serviceservice.savePurchase(purchase);
		
	}
	
	@GetMapping("purchases-list")
	public List<Purchase> allpurchases() {
		 return purchase_serviceservice.getPurchases();
	}
	
	
	@DeleteMapping("delete-purchase/{purchase_id}")
	public boolean deletePurchase(@PathVariable("purchase_id") int purchase_id,Purchase purchase) {
		purchase.setPurchase_id(purchase_id);
		return purchase_serviceservice.deletePurchase(purchase);
	}

	@GetMapping("purchase/{purchase_id}")
	public List<Purchase> allpurchaseByID(@PathVariable("purchase_id") int purchase_id,Purchase purchase) {
		 purchase.setPurchase_id(purchase_id);
		 return purchase_serviceservice.getPurchaseByID(purchase);
		
	}
	
	@PostMapping("update-purchase/{purchase_id}")
	public boolean updatePurchase(@RequestBody Purchase purchase,@PathVariable("purchase_id") int purchase_id) {
		purchase.setPurchase_id(purchase_id);
		return purchase_serviceservice.updatePurchase(purchase);
	}
}
