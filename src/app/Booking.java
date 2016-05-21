package app;

import jello.model.JelloEntity;
import jello.annotation.KeyElement;
import jello.annotation.ReadOnly;
import jello.rest.IllegalRequestResource;
import jello.annotation.Required;
import jello.security.Accessible;
import com.google.appengine.api.datastore.Key;
import jello.security.Role;
import jello.ux.Preview;
import jello.annotation.Reference;
import jello.annotation.Expose;

import javax.jdo.annotations.PersistenceCapable;


@PersistenceCapable
@Accessible( Role.ALL )public class Booking extends JelloEntity {

	private static final long serialVersionUID = -6803958537889807074L;

	@Expose
	@Required
	@ReadOnly
	public Double cost;

	@Expose
	@KeyElement
	public String userId;

	@Reference(Product.class)
	@Preview(element="name")
	@Expose
	@Required
	@ReadOnly
	public Key product;

	@Override
	protected JelloEntity beforeSave() throws IllegalRequestResource {
		// TODO Auto-generated method stub
		return this;
	}



}
