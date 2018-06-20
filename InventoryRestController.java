package com.inventorysystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventorysystem.domain.Inventory;
import com.inventorysystem.domain.Items;
import com.inventorysystem.domain.Location;
import com.inventorysystem.domain.Warehouse;
import com.inventorysystem.service.InventoryService;
import com.inventorysystem.service.ItemService;
import com.inventorysystem.service.LocationService;
import com.inventorysystem.service.WarehouseService;

@RestController
public class InventoryRestController {

	@Autowired
	private WarehouseService warehouseService;
	
	@Autowired
	private LocationService locationService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private InventoryService inventoryService;

	@RequestMapping(value = "/rest/warehouses", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Warehouse> getAllWarehouse() {
		List<Warehouse> warehouseLists = warehouseService.list();
		return warehouseLists;
	}

	@RequestMapping(value = "/rest/warehouse/{Name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Warehouse getWarehousename(@PathVariable String Name) {
		Warehouse warehouseLists = warehouseService.getWarehouseByName(Name);
		return warehouseLists;
	}

	@RequestMapping(value = "/rest/savewarehosue", method = RequestMethod.POST, headers = "Content-Type=application/json")
	public ResponseEntity createwarehouse(@RequestBody Warehouse warehouse) {

		warehouseService.saveWarehouse(warehouse);

		return new ResponseEntity(warehouse, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/itemslist", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Items> getAllItem() {
		List<Items> itemLists = itemService.list();
		return itemLists;
	}

	@RequestMapping(value = "/rest/item/{Name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Items getItemname(@PathVariable String Name) {
		Items itemLists = itemService.getItemByName(Name);
		return itemLists;
	}

	@RequestMapping(value = "/rest/saveitem", method = RequestMethod.POST, headers = "Content-Type=application/json")
	public ResponseEntity createItem(@RequestBody Items item1) {
		itemService.saveItem(item1);
		return new ResponseEntity(item1, HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/locations", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Location> getAllLocation() {
		List<Location> locationLists = locationService.list();
		return locationLists;
	}

	@RequestMapping(value = "/rest/location/{Name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Location getLocationname(@PathVariable String Name) {
		Location locationLists = locationService.getLocationByName(Name);
		return locationLists;
	}

	@RequestMapping(value = "/rest/savelocation", method = RequestMethod.POST, headers = "Content-Type=application/json")
	public ResponseEntity createLocation(@RequestBody Location location) {

		locationService.saveLocation(location);

		return new ResponseEntity(location, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rest/inventorys", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Inventory> getAllInventory() {
		List<Inventory> inventoryLists = inventoryService.list();
		return inventoryLists;
	}

	@RequestMapping(value = "/rest/inventory/{Name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Inventory getInventoryname(@PathVariable String Name) {
		Inventory inventoryLists = inventoryService.getInventoryByName(Name);
		return inventoryLists;
	}

	@RequestMapping(value = "/rest/saveinventory", method = RequestMethod.POST, headers = "Content-Type=application/json")
	public ResponseEntity createInventory(@RequestBody Inventory inventory) {

		inventoryService.saveInventory(inventory);

		return new ResponseEntity(inventory, HttpStatus.OK);
	}

}
