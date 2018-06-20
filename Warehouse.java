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
@Table(name = "whwmd200")
public class Warehouse implements Serializable {
	@Id
	@Column(name = "cwar")
	private String cwar;
	@Column(name = "Sloc")
	private Boolean sloc;
	@Column(name = "Dsca")
	private String dsca;
	private Location location;
	private Inventory inventory;

	public String getCwar() {
		return cwar;
	}

	public void setCwar(String cwar) {
		this.cwar = cwar;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cwar", nullable = false)
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cwar", nullable = false)
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Boolean getSloc() {
		return sloc;
	}

	public void setSloc(Boolean sloc) {
		this.sloc = sloc;
	}

	public String getDsca() {
		return dsca;
	}

	public void setDsca(String dsca) {
		this.dsca = dsca;
	}

	public Warehouse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Warehouse(String cwar, Boolean sloc, String dsca, Location location, Inventory inventory) {
		super();
		this.cwar = cwar;
		this.sloc = sloc;
		this.dsca = dsca;
		this.location = location;
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "Warehouse [cwar=" + cwar + ", sloc=" + sloc + ", dsca=" + dsca + ", location=" + location
				+ ", inventory=" + inventory + "]";
	}

}