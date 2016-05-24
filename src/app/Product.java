package app;

import javax.jdo.annotations.PersistenceCapable;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import jello.annotation.Expose;
import jello.annotation.Reference;
import jello.annotation.Required;
import jello.model.JelloEntity;
import jello.rest.IllegalRequestResource;
import jello.security.Accessible;
import jello.security.Role;
import jello.ux.Control;
import jello.ux.Preview;
import jello.annotation.Attachment;

@PersistenceCapable
@Accessible(
		   retrieve = Role.USER,
		   create =   Role.USER,
		   update =   Role.OWNER,
		   query =    Role.USER,
		   delete =   Role.OWNER
		)
public class Product extends JelloEntity {
	private static final long serialVersionUID = 9074250486174010304L;
	
	@Expose @Required  
	public String name;
	
	@Expose @Reference(Category.class)
	public Key category;
	
	@Reference(User.class) @Expose @Required @Preview(element = "name")
	public Key user;

	@Expose
	public String description;

	@Expose @Required
	public Double cost;

	@Attachment(accept="image/*") @Expose
	public String image;

	@Accessible(Role.USER) 
	public String book() throws IllegalRequestResource {
		Booking b = new Booking();
		b.product = this.getKey();
		UserService userService = UserServiceFactory.getUserService();
		if (userService.isUserLoggedIn()) {
			b.key = userService.getCurrentUser().getEmail() + b.product.getName();
		}
		b.cost = this.cost;
		b.create();
		return "Thank you for booking with Strive! To check your bookings, navigate to the bookings menu.";
	}
	
	@Expose @Control(src="/demo/custom/checkbox2")
	public Boolean monday;

	@Expose @Control(src="/demo/custom/checkbox2")
	public Boolean tuesday;

	@Expose @Control(src="/demo/custom/checkbox2")
	public Boolean wednesday;

	@Expose @Control(src="/demo/custom/checkbox2")
	public Boolean thursday;

	@Expose @Control(src="/demo/custom/checkbox2")
	public Boolean friday;

	@Expose @Control(src="/demo/custom/checkbox2")
	public Boolean saturday;

	@Expose @Control(src="/demo/custom/checkbox2")
	public Boolean sunday;
}
