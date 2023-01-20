package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.Purchase_DAO;
import Model.Purchase;

@Service
@Transactional
public class Purchase_Service_Imp implements Purchase_Service {
 
	@Autowired
	private Purchase_DAO purchasedao;
	
	@Override
	public boolean savePurchase(Purchase purchase) {
		return purchasedao.savePurchase(purchase);
	}

	@Override
	public List<Purchase> getPurchases() {
		return purchasedao.getPurchases();
	}

	@Override
	public boolean deletePurchase(Purchase purchase) {
		return purchasedao.deletePurchase(purchase);
	}

	@Override
	public List<Purchase> getPurchaseByID(Purchase purchase) {
		return purchasedao.getPurchaseByID(purchase);
	}

	@Override
	public boolean updatePurchase(Purchase purchase) {
		return purchasedao.updatePurchase(purchase);
	}

}
