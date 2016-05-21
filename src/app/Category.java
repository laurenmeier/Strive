package app;

import java.util.List;

import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;

import jello.annotation.Association;
import jello.annotation.Expose;
import jello.annotation.KeyElement;
import jello.model.JelloEntity;
import jello.security.Accessible;



@Accessible @PersistenceCapable
public class Category extends JelloEntity {
	private static final long serialVersionUID = -374009095641063548L;
	
	@Expose @KeyElement 
	public String label;
	
	@Expose @NotPersistent @Association(mappedBy="category") 
	public List<Product> products;



	
}
