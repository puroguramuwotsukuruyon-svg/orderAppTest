package rei18;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MenuInitListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		MenuBean menuBean = new MenuBean();
	
		menuBean.addProduct(new Product("マルゲリータ",480));
		menuBean.addProduct(new Product("ハンバーグ",500));
		menuBean.addProduct(new Product("ドリアジャポネーゼ",460));
		menuBean.addProduct(new Product("ラムネ",180));
		menuBean.addProduct(new Product("ミラノ風ドリア",300));
		menuBean.addProduct(new Product("メロンソーダ",200));
		
		sce.getServletContext().setAttribute("staticMenu", menuBean);
	}
	

	
}
