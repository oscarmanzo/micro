package com.globant.training.micro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the type_discount database table.
 * 
 */
@Entity
@Table(name="type_discount")
@NamedQuery(name="TypeDiscount.findAll", query="SELECT t FROM TypeDiscount t")
public class TypeDiscount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String name;

	//bi-directional many-to-one association to Discount
	@OneToMany(mappedBy="typeDiscount")
	private List<Discount> discounts;

	public TypeDiscount() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Discount> getDiscounts() {
		return this.discounts;
	}

	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}

	public Discount addDiscount(Discount discount) {
		getDiscounts().add(discount);
		discount.setTypeDiscount(this);

		return discount;
	}

	public Discount removeDiscount(Discount discount) {
		getDiscounts().remove(discount);
		discount.setTypeDiscount(null);

		return discount;
	}

}