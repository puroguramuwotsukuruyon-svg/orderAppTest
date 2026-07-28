package rei18;

import java.util.Map;

public class OrderApp {

	public static void main(String[] args) {
		MenuBean menu = new MenuBean();
		
		menu.addProduct(new Product("ハンバーグ",500));
		menu.addProduct(new Product("ドリアジャポネーゼ",460));
		menu.addProduct(new Product("ラムネ",180));
		menu.addProduct(new Product("ミラノ風ドリア",300));
		
		OrderBean order = new OrderBean();
		
		order.addOrder("ハンバーグ", 3, menu);
		order.addOrder("ラムネ", 2, menu);
		order.addOrder("ミラノ風ドリア", 4, menu);

		//合計金額を出す。
		int total=0;
		
			for(Map.Entry<Product, Integer> e: order.getOrder().entrySet()){
				int subtotal = 0;
				subtotal = e.getKey().getPrice() * e.getValue();//その商品の合計；
				System.out.println(e.getKey().getName()+"："+e.getKey().getPrice()+"円……"+e.getValue()+"点");
				System.out.println("計:"+subtotal+"円");
				
				total += subtotal;
			}
			System.out.println("合計金額："+total+"円");

	}
}
