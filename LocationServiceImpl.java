package com.inventorysystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorysystem.dao.LocationDao;
import com.inventorysystem.dao.WarehouseDao;
import com.inventorysystem.domain.Items;
import com.inventorysystem.domain.Location;
import com.inventorysystem.domain.Warehouse;
import com.inventorysystem.service.LocationService;

@Service("locationService")
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationDao locationDao;
	
	@Autowired
	private WarehouseDao warehouseDao;

	public void saveLocation(Location loca) {
		// TODO Auto-generated method stub
		Location location = locationDao.getLocationByName(loca.getLoca());
		if (location == null) {
			
			Warehouse warehouse =warehouseDao.getWarehouseByName(loca.getWarehouse().getCwar());		
			warehouse.setSloc(true);
			loca.setWarehouse(warehouse);
			locationDao.saveLocation(loca);
			warehouseDao.updateWarehouse(warehouse);

		} else if (location.getLoca().equalsIgnoreCase(loca.getLoca())) {
			System.out.println("Location already exists");
		}

	}

	// public Location updateLocation(Location loca) {
	// // TODO Auto-generated method stub
	// return locationDao.updateLocation(loca);
	// }
	//
	// public Location deleteLocation(Location loca) {
	// // TODO Auto-generated method stub
	// return locationDao.deleteLocation(loca);
	// }

	public Location getLocationByName(String name) {
		// TODO Auto-generated method stub
		return locationDao.getLocationByName(name);
	}

	public List<Location> list() {
		// TODO Auto-generated method stub
		return locationDao.list();
	}

}
