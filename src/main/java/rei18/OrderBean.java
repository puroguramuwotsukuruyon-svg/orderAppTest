package rei18;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpSession;

public class OrderBean implements Serializable {
	private Map<Product, Integer> order = new HashMap<>();

	public void addOrder(String name, int count, MenuBean mb) {
		Product p = mb.findByName(name);
		order.put(p, count);
	}

	public Map<Product, Integer> getOrder() {
		return order;
	}

	public static boolean setOrderToDB(OrderBean ob,HttpSession session) {
		boolean chk = false;
		String sql = "INSERT INTO orders (order_id,name,count) values (?,?,?)";

			//order_idが注文ごとのまとまった明細書id
			//idは注文一行ごとのid。
			//DB上はordersのテーブルでorder_idがPK
			//order_itemsのテーブルでidがPK、order_idをFKにしてる。
		
			//次回、まずorder_idに空のものを挿入し、カラムを作る。
			//その後、そのorder_idを固定値させて、for文で注文を挿入する処理。
		
		try (
				//リソースファインダからコネクション呼ぶ。
				Connection conn = ResourceFinder.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);){
				//当然try-with
				int resultCount = 0;
			
			//OrderBeanをforで回して、値を回収する。
			for (Map.Entry<Product, Integer> entry : ob.getOrder().entrySet()) {
			
				pst.setInt(1, Integer.parseInt(session.getId()));
				//ここに注文番号。分からないため仮で３。
				pst.setString(2, entry.getKey().getName());
				pst.setInt(3, entry.getValue());
				
				int result = pst.executeUpdate();
				resultCount += result;
				
			}
			if(resultCount == ob.getOrder().size()) {
				chk = true;
			}
			
		} catch (Exception e) {
			//仮キャッチ。
		}

		return chk;

	}

}
