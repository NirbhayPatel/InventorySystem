package com.inventorysystem.daoImpl;

import java.util.List;

//import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inventorysystem.dao.AbstractDao;
import com.inventorysystem.dao.WarehouseDao;
import com.inventorysystem.domain.Warehouse;

@Repository("warehouseDao")
@Transactional
public class WarehouseDaoImpl extends AbstractDao implements WarehouseDao {

	public void saveWarehouse(Warehouse ware) {
		// TODO Auto-generated method stub
		persist(ware);
		getSession().flush();

	}

	 public void updateWarehouse(Warehouse ware) {
	 // TODO Auto-generated method stub
		 getSession().saveOrUpdate(ware);
	 }
	//
	// public Warehouse deleteWarehouse(Warehouse ware) {
	// // TODO Auto-generated method stub
	// return null;
	// }

	public Warehouse getWarehouseByName(String name) {
		// TODO Auto-generated method stub
		Warehouse ware1 = (Warehouse) getSession().createCriteria(Warehouse.class).add(Restrictions.like("cwar", name))
				.uniqueResult();
		return ware1;

	}

	public List<Warehouse> list() {
		// TODO Auto-generated method stub
		List<Warehouse> warehouses = getSession().createCriteria(Warehouse.class).list();

		return warehouses;
	}

}
