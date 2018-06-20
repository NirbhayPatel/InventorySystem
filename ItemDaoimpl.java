package com.inventorysystem.daoImpl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inventorysystem.dao.AbstractDao;
import com.inventorysystem.dao.ItemDao;
import com.inventorysystem.domain.Items;
import org.hibernate.Query;

@Repository("itemDao")
@Transactional
public class ItemDaoimpl extends AbstractDao implements ItemDao {

	public void saveItem(Items item) {
		// TODO Auto-generated method stub
		persist(item);
		getSession().flush();
	}

	// public Item updateItem(Item item) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// public Item deleteItem(Item item) {
	// // TODO Auto-generated method stub
	// return null;
	// }

	public Items getItemByName(String name) {
		// TODO Auto-generated method stub
		Items item1 = (Items) getSession().createCriteria(Items.class).add(Restrictions.like("items1", name))
				.uniqueResult();
		return item1;

	}

	public List<Items> list() {
		// TODO Auto-generated method stub
		List<Items> items = getSession().createCriteria(Items.class).list();

		return items;
	}

}
