package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="purchase")
public class Purchase {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int purchase_id;
	private String purchase_name;
	private String purchase_email;
	private String purchase_branch;
	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public String getPurchase_name() {
		return purchase_name;
	}

	public void setPurchase_name(String purchase_name) {
		this.purchase_name = purchase_name;
	}

	public String getPurchase_email() {
		return purchase_email;
	}

	public void setPurchase_email(String purchase_email) {
		this.purchase_email = purchase_email;
	}

	public String getPurchase_branch() {
		return purchase_branch;
	}

	public void setPurchase_branch(String purchase_branch) {
		this.purchase_branch = purchase_branch;
	}

	
}
