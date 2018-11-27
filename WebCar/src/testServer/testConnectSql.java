package testServer;

import java.util.*;

import DAO.*;
import model.*;

public class testConnectSql {
	public static void main(String[] args) {
//		User u = (User) new UserDAO().selectById(2);
//		System.out.println(u.getName());
		
// -----------------------------Test DAO.update(), select()---------------------------
//		BrandDAO bdao = new BrandDAO();
//		Brand b = (Brand) bdao.selectById(21);
//		b.setHeadQuater("Vi");
//		bdao.update(21, b);
//		Car c = (Car) new CarDAO().selectById(2);
//		System.out.println(c.getName());
		
//		--------------------------Test DAO.search()------------------
//		ArrayList<Brand> listBrand = new ArrayList<>();
//		ArrayList<entity> listEntity = new CategoryDAO().search("t");
		
		ArrayList<entity> listEntity = new UpdateNewsDAO().selectAll();
		ArrayList<UpdateNews> listCar = new ArrayList<>();
		for(int i=0; i<listEntity.size();i++) {
			UpdateNews br = (UpdateNews) listEntity.get(i);
			listCar.add(br);
			System.out.println(br.getId() +" "+br.getContent_update());
			System.out.println(br.getTimeUpdate().after(new Date(2018-11-10)));
//			new UpdateNewsDAO().insert(br);
			
			
//			System.out.println(br.getBrand().getName());
//			br.setImage(br.getBrand().getAvatar());
			
		}
//		Update
		
//		listCar.get(2).setLastUpdate(new Timestamp(new Date().getTime()));
//		new CategoryDAO().update(listCar.get(2).getId(), listCar.get(2));

// ------------------------Test Insert-------------------------------		
//		News c = (News) new NewsDAO().selectById(3);
//		System.out.println(c.getTitle());
//		listCar.get(5).setViews(1000);
//		new NewsDAO().update(listCar.get(5).getId(), listCar.get(5));;

	}
}
