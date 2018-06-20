package com.inventorysystem.daoImpl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inventorysystem.dao.AbstractDao;
import com.inventorysystem.dao.LocationDao;
import com.inventorysystem.domain.Location;

@Repository("locationDao")
@Transactional
public class LocationDaoImpl extends AbstractDao implements LocationDao {
	
	

	public void saveLocation(Location loca) {
		// TODO Auto-generated method stub
		persist(loca);
		getSession().flush();
	}

	// public Location updateLocation(Location loca) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// public Location deleteLocation(Location loca) {
	// // TODO Auto-generated method stub
	// return null;
	// }

	public Location getLocationByName(String name) {
		// TODO Auto-generated method stub
		Location locations = (Location) getSession().createCriteria(Location.class).add(Restrictions.like("loca", name))
				.uniqueResult();
		return locations;

	}

	public List<Location> list() {
		// TODO Auto-generated method stub
		List<Location> locations = getSession().createCriteria(Location.class).list();

		return locations;
	}

}
