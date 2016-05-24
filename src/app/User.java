package app;

import jello.model.JelloEntity;
import jello.rest.IllegalRequestResource;
import jello.annotation.Required;
import jello.security.Accessible;
import jello.security.Role;
import jello.ux.Validation;
import jello.annotation.Association;
import jello.annotation.Attachment;
import jello.annotation.Expose;
import jello.annotation.Final;

import java.util.List;

import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@PersistenceCapable
@Accessible(
		   retrieve = Role.USER,
		   create =   Role.USER,
		   update =   Role.OWNER,
		   query =    Role.USER,
		   delete =   Role.OWNER
		)
public class User extends JelloEntity {

	private static final long serialVersionUID = -8622619703852330513L;

	@Validation(email = true) @Expose
	public String email;

	@Expose @Required
	public String name;

	@Expose
	public String bio;

	@Expose @Required @Final
	public Integer age;
	
	@Expose @NotPersistent @Association(mappedBy = "User")
	public List<Product> services;

	
	@Attachment(accept = "image/*") @Expose
	public String profilePic;

	@Override
	protected JelloEntity beforeSave() throws IllegalRequestResource {
		UserService userService = UserServiceFactory.getUserService();
		if (userService.isUserLoggedIn()) {
			if(email == null)
				email = userService.getCurrentUser().getEmail();
		}
		return this;
	}
}
