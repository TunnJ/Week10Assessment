package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class IceCream {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String flavor;
	private String toppings;
	private int numScoops;
	
	public IceCream(String flavor, String toppings, int numScoops) {
		this.flavor = flavor;
		this.toppings = toppings;
		this.numScoops = numScoops;
	}
	
	public IceCream() {};
}
