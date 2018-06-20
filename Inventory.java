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
@Table(name = "whinr140")
public class Inventory implements Serializable {

	@Id
	@Column(name = "Clot")
	private String clot;
	@Column(name = "Qhnd")
	private double qhnd;
	@Column(name = "Qlal")
	private double qlal;

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

	@Access(AccessType.PROPERTY)
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "loca")
	private Location location;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Access(AccessType.PROPERTY)
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "item")
	private Items item1;

	public Items getItem1() {
		return item1;
	}

	public void setItem1(Items item1) {
		this.item1 = item1;
	}

	public String getClot() {
		return clot;
	}

	public void setClot(String clot) {
		this.clot = clot;
	}

	public double getQhnd() {
		return qhnd;
	}

	public void setQhnd(double qhnd) {
		this.qhnd = qhnd;
	}

	public double getQlal() {
		return qlal;
	}

	public void setQlal(double qlal) {
		this.qlal = qlal;
	}

	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inventory(String clot, double qhnd, double qlal, Warehouse warehouse, Location location, Items item1) {
		super();
		this.clot = clot;
		this.qhnd = qhnd;
		this.qlal = qlal;
		this.warehouse = warehouse;
		this.location = location;
		this.item1 = item1;
	}

	@Override
	public String toString() {
		return "Inventory [clot=" + clot + ", qhnd=" + qhnd + ", qlal=" + qlal + ", warehouse=" + warehouse
				+ ", location=" + location + ", item1=" + item1 + "]";
	}

}
