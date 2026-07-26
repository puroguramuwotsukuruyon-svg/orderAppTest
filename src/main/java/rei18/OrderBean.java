package rei18;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class OrderBean implements Serializable {
	private Map<Product,Integer> order = new HashMap<>();
	
	public void addOrder(String name,int count,MenuBean mb) {
		Product p = mb.findByName(name);
		order.put(p, count);
	}
	
	public Map<Product,Integer> getOrder() {
		return order;
	}
}
