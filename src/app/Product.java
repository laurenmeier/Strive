package app;

import java.util.List;

import javax.jdo.annotations.PersistenceCapable;

import com.google.appengine.api.datastore.Key;

import jello.annotation.Expose;
import jello.annotation.KeyElement;
import jello.annotation.Reference;
import jello.annotation.Required;
import jello.model.JelloEntity;
import jello.model.JelloModel;
import jello.rest.IllegalRequestResource;
import jello.security.Accessible;


@Accessible @PersistenceCapable
public class Product extends JelloEntity {
	private static final long serialVersionUID = 9074250486174010304L;

	@Expose @KeyElement 
	public String serialNumber;
	
	@Expose @Required  
	public String name;
	
	@Expose @Reference(Category.class)
	public Key category;
	
	@Expose 
	public Integer price;
	
	@Accessible 
	@SuppressWarnings("unchecked")
	public static List<Product> createCatalog() throws IllegalRequestResource {
		JelloModel.deleteAll(Category.class);
		for(int i=0;i<4;i++) {
			Category c = new Category();
			c.label = "Category " + i;
			c.create();
		}
		
		JelloModel.deleteAll(Product.class);
		for(int i=0; i<10; i++) {
			Product p = new Product();
			p.serialNumber = "SN-000" + i;
			p.name = "Product " + i;
			p.price = (int) (1000 * Math.random());
			p.category = JelloModel.selectRandom(Category.class).getKey();
			p.create();
		}
		
		return (List<Product>) JelloModel.select(Product.class);
	}
}
