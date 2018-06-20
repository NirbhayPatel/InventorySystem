package com.inventorysystem.domain;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "tcibd001")
public class Items implements Serializable {
	@Id
	@Column(name = "Item")
	private String items1;
	@Column(name = "Dsca")
	private String dsca;
	private Inventory inventory;

	@Access(AccessType.PROPERTY)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn(name = "Item")
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public String getItems1() {
		return items1;
	}

	public void setItems1(String items1) {
		this.items1 = items1;
	}

	public String getDsca() {
		return dsca;
	}

	public void setDsca(String dsca) {
		this.dsca = dsca;
	}

	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Items(String items1, String dsca, Inventory inventory) {
		super();
		this.items1 = items1;
		this.dsca = dsca;
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "Items [items1=" + items1 + ", dsca=" + dsca + ", inventory=" + inventory + "]";
	}

	

}
