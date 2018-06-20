package com.inventorysystem.service;

import java.util.List;

import com.inventorysystem.domain.Location;

public interface LocationService {

	public void saveLocation(Location loca);

	// public Location updateLocation(Location loca);
	//
	// public Location deleteLocation(Location loca);
	//
	public Location getLocationByName(String name);

	public List<Location> list();

}
