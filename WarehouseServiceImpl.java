package com.inventorysystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorysystem.dao.WarehouseDao;
import com.inventorysystem.domain.Warehouse;
import com.inventorysystem.service.WarehouseService;

@Service("warehouseService")
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	private WarehouseDao warehouseDao;

	public void saveWarehouse(Warehouse ware) {
		// TODO Auto-generated method stub
		Warehouse warehouse = warehouseDao.getWarehouseByName(ware.getCwar());
		if(warehouse == null){
			ware.setSloc(false);
			warehouseDao.saveWarehouse(ware);
		}
		else if  (warehouse.getCwar().equalsIgnoreCase(ware.getCwar())) {
			System.out.println("warehouse already exists");
		}  
	}

	// public Warehouse updateWarehouse(Warehouse ware) {
	// // TODO Auto-generated method stub
	// return warehouseDao.updateWarehouse(ware);
	// }
	//
	// public Warehouse deleteWarehouse(Warehouse ware) {
	// // TODO Auto-generated method stub
	// return warehouseDao.deleteWarehouse(ware);
	// }

	public Warehouse getWarehouseByName(String name) {
		// TODO Auto-generated method stub
		return warehouseDao.getWarehouseByName(name);
	}

	public List<Warehouse> list() {
		// TODO Auto-generated method stub
		return warehouseDao.list();
	}

}
