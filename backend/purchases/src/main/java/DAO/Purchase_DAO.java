package DAO;

import java.util.List;

import Model.Purchase;

public interface Purchase_DAO {

	public boolean savePurchase(Purchase purchase);
	public List<Purchase> getPurchases();
	public boolean deletePurchase(Purchase purchase);
	public List<Purchase> getPurchaseByID(Purchase purchase);
	public boolean updatePurchase(Purchase purchase);
}
