package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import Model.Purchase;

@Repository
public class Purchase_DAO_Imp  implements Purchase_DAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean savePurchase(Purchase purchase) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(purchase);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Purchase> getPurchases() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Purchase> query=currentSession.createQuery("from Purchase", Purchase.class);
		List<Purchase> list=query.getResultList();
		return list;
	}

	@Override
	public boolean deletePurchase(Purchase purchase) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().delete(purchase);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Purchase> getPurchaseByID(Purchase purchase) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Purchase> query=currentSession.createQuery("from Purchase where purchase_id=:purchase_id", Purchase.class);
		query.setParameter("purchase_id", purchase.getPurchase_id());
		List<Purchase> list=query.getResultList();
		return list;
	}

	@Override
	public boolean updatePurchase(Purchase purchase) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(purchase);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	

}
