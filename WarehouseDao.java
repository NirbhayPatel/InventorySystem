package com.inventorysystem.dao;

import java.util.List;

import com.inventorysystem.domain.Warehouse;

public interface WarehouseDao {
	
	public void saveWarehouse(Warehouse ware);
	
	public void updateWarehouse(Warehouse ware);
	
	//public Warehouse deleteWarehouse(Warehouse ware);
	
	public Warehouse getWarehouseByName(String name);
	
	public List<Warehouse> list();

}
