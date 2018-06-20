package com.inventorysystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inventorysystem.domain.Warehouse;
import com.inventorysystem.service.WarehouseService;

@Controller
public class WarehouseController {

	@Autowired
	private WarehouseService warehouseService;

	@RequestMapping("/warehouses")
	public ModelAndView getAllWarehouses() {
		List<Warehouse> warehouselist = warehouseService.list();
		return new ModelAndView("warehousesList", "warehouselist", warehouselist);
	}

	@RequestMapping("/warehouse/{Name}")
	public ModelAndView getDetailsByWarehouse(@PathVariable String Name) {
		Warehouse warehouse1 = warehouseService.getWarehouseByName(Name);
		return new ModelAndView("warehousesList", "warehouse1", warehouse1);
	}

	@RequestMapping("/createWarehouse")
    public ModelAndView createWarehouse(@ModelAttribute Warehouse Warehouse) {
        return new ModelAndView("warehousesform");
    }
	
	
	@RequestMapping("/newwarehouse")
	public ModelAndView addWarehouseDetails(@ModelAttribute Warehouse warehouse) {
		warehouseService.saveWarehouse(warehouse);
		return new ModelAndView("redirect:/warehouses");
	}
}
