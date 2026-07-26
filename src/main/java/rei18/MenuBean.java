package rei18;

import java.io.Serializable;
import java.util.ArrayList;

public class MenuBean implements Serializable {
	private ArrayList<Product> items = new ArrayList<>();

	public void addProduct(Product p) {
		this.items.add(p);
	}
	
	
	public Product findByName(String name){
		for(Product p:this.items){
		
			if(p.getName().equals(name)){
				return p;
			}	
		}
		return null;
	}
}

