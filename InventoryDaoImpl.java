package com.inventorysystem.daoImpl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inventorysystem.dao.AbstractDao;
import com.inventorysystem.dao.InventoryDao;
import com.inventorysystem.domain.Inventory;

@Repository("inventoryDao")
@Transactional
public class InventoryDaoImpl extends AbstractDao implements InventoryDao {

	public void saveInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		persist(inventory);
		getSession().flush();
	}

	// public Inventory updateInventory(Inventory Inventory) {
	// // TODO Auto-generated method stub
	// return null;
	// }

	// public Inventory deleteInventory(Inventory Inventory) {
	// // TODO Auto-generated method stub
	// return null;
	// }

	public Inventory getInventoryByName(String name) {
		// TODO Auto-generated method stub
		Inventory inventory1 = (Inventory) getSession().createCriteria(Inventory.class)
				.add(Restrictions.like("clot", name)).uniqueResult();
		return inventory1;

	}

	public List<Inventory> list() {
		// TODO Auto-generated method stub
		List<Inventory> inventorys = getSession().createCriteria(Inventory.class).list();

		return inventorys;
	}

}
