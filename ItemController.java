package com.inventorysystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.inventorysystem.domain.Items;
import com.inventorysystem.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("/items")
	public ModelAndView getAllItems() {
		List<Items> itemlist = itemService.list();
		return new ModelAndView("itemsList", "itemlist", itemlist);
	}

	@RequestMapping("/itemName/{Name}")
	public ModelAndView getDetailsByItemName(@PathVariable String Name) {
		Items item1 = itemService.getItemByName(Name);
		return new ModelAndView("itemsList", "item1", item1);
	}

	
	@RequestMapping("/createItem")
    public ModelAndView createItem(@ModelAttribute Items items) {
        return new ModelAndView("itemsform");
    }
	
	@RequestMapping("/newitem")
	public ModelAndView addItemDetails(@ModelAttribute Items items) {
		itemService.saveItem(items);
		return new ModelAndView("redirect:/items");
	}

}
