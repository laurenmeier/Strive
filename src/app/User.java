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

import java.util.List;

import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import jello.annotation.KeyElement;
import com.google.appengine.api.datastore.Key;
import jello.annotation.Reference;
import jello.ux.Preview;

@PersistenceCapable
@Accessible(Role.USER)
public class User extends JelloEntity {

	private static final long serialVersionUID = -8622619703852330513L;

	// key - email
	@Validation(email = true) @Expose @KeyElement
	public String email;

	@Expose @Required
	public String name;

	@Expose
	public String bio;

	@Expose @Required
	public Integer age;
	
	@Expose @Association(mappedBy = "User")
	public List<Product> services;

	@Attachment(accept = "image/*") @Expose
	public String profilePic;


	@Override
	protected JelloEntity beforeSave() throws IllegalRequestResource {
		UserService userService = UserServiceFactory.getUserService();
		if (userService.isUserLoggedIn()) {
			email = userService.getCurrentUser().getEmail();
		}
		//TODO: if email is already linked to a user, do not create new user
		return this;
	}
}
