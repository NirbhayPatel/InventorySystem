package com.inventorysystem.service;

import java.util.List;

import com.inventorysystem.domain.Warehouse;

public interface WarehouseService {

	public void saveWarehouse(Warehouse ware);

	// public Warehouse updateWarehouse(Warehouse ware);
	//
	// public Warehouse deleteWarehouse(Warehouse ware);
	//
	public Warehouse getWarehouseByName(String name);

	public List<Warehouse> list();

}
