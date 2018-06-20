package com.inventorysystem.dao;

import java.util.List;

import com.inventorysystem.domain.Inventory;

public interface InventoryDao {
	
public void saveInventory(Inventory Inventory);
	
	//public Inventory updateInventory(Inventory Inventory);
	
	//public Inventory deleteInventory(Inventory Inventory);
	
	public Inventory getInventoryByName(String name);
	
	public List<Inventory> list();

}
