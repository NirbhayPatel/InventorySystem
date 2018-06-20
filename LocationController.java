package com.inventorysystem.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inventorysystem.domain.Location;
import com.inventorysystem.domain.Warehouse;
import com.inventorysystem.service.LocationService;
import com.inventorysystem.service.WarehouseService;

@Controller
public class LocationController {
	@Autowired
	private WarehouseService warehouseService;

	@Autowired
	private LocationService locationService;

	@RequestMapping("/locations")
	public ModelAndView getAllLocation() {
		List<Location> locationlist = locationService.list();
		
		return new ModelAndView("locationsList", "locationlist", locationlist);
	}

	@RequestMapping("/locationName/{Name}")
	public ModelAndView getDetailsByLocationName(@PathVariable String Name) {
		Location location1 = locationService.getLocationByName(Name);
		return new ModelAndView("locationsList", "location1", location1);
	}
	
	@RequestMapping("/createLocation")
    public ModelAndView createLocation(@ModelAttribute Location location,HttpServletRequest request) {
		List<Warehouse> warehouselist = warehouseService.list();
		request.setAttribute("warehouselist", warehouselist);
        return new ModelAndView("locationform");
    }

	@RequestMapping("/newLocation")
	public ModelAndView addLocationDetails(@ModelAttribute Location location) {
		locationService.saveLocation(location);
		return new ModelAndView("redirect:/locations");
	}

}
