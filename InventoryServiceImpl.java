package com.inventorysystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorysystem.dao.InventoryDao;
import com.inventorysystem.dao.ItemDao;
import com.inventorysystem.dao.LocationDao;
import com.inventorysystem.dao.WarehouseDao;
import com.inventorysystem.domain.Inventory;
import com.inventorysystem.domain.Items;
import com.inventorysystem.domain.Location;
import com.inventorysystem.domain.Warehouse;
import com.inventorysystem.service.InventoryService;

@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryDao inventoryDao;
	@Autowired
	private LocationDao locationDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private WarehouseDao warehouseDao;

	public void saveInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		Inventory inventory1 =inventoryDao.getInventoryByName(inventory.getClot());
		if (inventory1 == null) {
			Location location = locationDao.getLocationByName(inventory.getLocation().getLoca());
			System.out.println(location);
			Warehouse warehouse =warehouseDao.getWarehouseByName(location.getWarehouse().getCwar());
			System.out.println(warehouse);
		Items item1 = itemDao.getItemByName(inventory.getItem1().getItems1());
			System.out.println(item1);
			inventory.setItem1(item1);
			inventory.setLocation(location);
			inventory.setWarehouse(warehouse);
			System.out.println("inventory if condition");
			inventoryDao.saveInventory(inventory);
		} else if (inventory1.getClot().equalsIgnoreCase(inventory.getClot())) {
			System.out.println("inventory already exists");
		}
		
	}

	// public Inventory updateInventory(Inventory Inventory) {
	// // TODO Auto-generated method stub
	// return inventoryDao.updateInventory(Inventory);
	// }
	//
	// public Inventory deleteInventory(Inventory Inventory) {
	// // TODO Auto-generated method stub
	// return inventoryDao.deleteInventory(Inventory);
	// }

	public Inventory getInventoryByName(String name) {
		// TODO Auto-generated method stub
		return inventoryDao.getInventoryByName(name);
	}

	public List<Inventory> list() {
		// TODO Auto-generated method stub
		return inventoryDao.list();
	}

}
