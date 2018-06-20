package com.inventorysystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorysystem.dao.ItemDao;
import com.inventorysystem.domain.Items;
import com.inventorysystem.service.ItemService;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;

	public void saveItem(Items item) {
		// TODO Auto-generated method stub
		Items item1 = itemDao.getItemByName(item.getItems1());
		if (item1 == null) {
			itemDao.saveItem(item);
		} else if (item1.getItems1().equalsIgnoreCase(item.getItems1())) {
			System.out.println("Item already exists");
		}
	}

	// public Item updateItem(Item item) {
	// // TODO Auto-generated method stub
	// return itemDao.updateItem(item);
	// }
	//
	// public Item deleteItem(Item item) {
	// // TODO Auto-generated method stub
	// return itemDao.deleteItem(item);
	// }

	public Items getItemByName(String name) {
		// TODO Auto-generated method stub
		return itemDao.getItemByName(name);
	}

	public List<Items> list() {
		// TODO Auto-generated method stub
		return itemDao.list();
	}

}
