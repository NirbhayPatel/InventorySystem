package com.inventorysystem.service;

import java.util.List;

import com.inventorysystem.domain.Items;

public interface ItemService {

	public void saveItem(Items item);

	// public Item updateItem(Item item);
	//
	// public Item deleteItem(Item item);
	//
	public Items getItemByName(String name);

	public List<Items> list();

}
