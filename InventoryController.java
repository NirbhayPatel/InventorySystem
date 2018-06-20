package com.inventorysystem.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inventorysystem.domain.Inventory;
import com.inventorysystem.domain.Items;
import com.inventorysystem.domain.Location;
import com.inventorysystem.domain.Warehouse;
import com.inventorysystem.service.InventoryService;
import com.inventorysystem.service.ItemService;
import com.inventorysystem.service.LocationService;
import com.inventorysystem.service.WarehouseService;

@Controller
public class InventoryController {
	@Autowired
	private WarehouseService warehouseService;

	@Autowired
	private LocationService locationService;
	
	@Autowired
	private ItemService itemService;
	//
	@Autowired
	private InventoryService inventoryService;

	@RequestMapping("/inventorys")
	public ModelAndView getAllInventory() {
		List<Inventory> inventorylist = inventoryService.list();
		return new ModelAndView("inventorysList", "inventorylist", inventorylist);
	}

	@RequestMapping("/inventoryName/{Name}")
	public ModelAndView getDetailsByInventoryName(@PathVariable String Name) {
		Inventory inventory1 = inventoryService.getInventoryByName(Name);
		return new ModelAndView("inventorysList", "inventory1", inventory1);
	}

	@RequestMapping("/createinventory")
    public ModelAndView createInventory(@ModelAttribute Inventory inventory,HttpServletRequest request) {
		List<Items> itemlist = itemService.list();
		List<Location> locationlist = locationService.list();
		List<Warehouse> warehouselist = warehouseService.list();
		request.setAttribute("warehouselist", warehouselist);
		request.setAttribute("itemlist", itemlist);
		request.setAttribute("locationlist", locationlist);
        return new ModelAndView("inventoryforms");
    }
	
	@RequestMapping("/newInventory")
	public ModelAndView addInventoryDetails(@ModelAttribute Inventory Inventory) {
		inventoryService.saveInventory(Inventory);
		return new ModelAndView("redirect:/inventorys");
	}

}
