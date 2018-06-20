package com.inventorysystem.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "whwmd300")
public class Location implements Serializable {

	@Id
	@Column(name = "Loca")
	private String loca;
	@Column(name = "Dsca")
	private String dsca;
	private Inventory inventory;

	@Access(AccessType.PROPERTY)
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "Cwar")
	private Warehouse warehouse;

	
	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public String getLoca() {
		return loca;
	}

	public void setLoca(String loca) {
		this.loca = loca;
	}

	public String getDsca() {
		return dsca;
	}

	public void setDsca(String dsca) {
		this.dsca = dsca;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "Loca", nullable = false)
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(String loca, String dsca, Inventory inventory, Warehouse warehouse) {
		super();
		this.loca = loca;
		this.dsca = dsca;
		this.inventory = inventory;
		this.warehouse = warehouse;
	}

	@Override
	public String toString() {
		return "Location [loca=" + loca + ", dsca=" + dsca + ", inventory=" + inventory + ", warehouse=" + warehouse
				+ "]";
	}

}
