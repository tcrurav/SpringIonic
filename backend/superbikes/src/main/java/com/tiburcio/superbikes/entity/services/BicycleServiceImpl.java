package com.tiburcio.superbikes.entity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiburcio.superbikes.entity.dao.IBicycleDao;
import com.tiburcio.superbikes.entity.models.Bicycle;

@Service
public class BicycleServiceImpl implements IBicycleService {

	@Autowired
	IBicycleDao bicycleDao;
	
	@Override
	public List<Bicycle> getAll() {
		return (List<Bicycle>) bicycleDao.findAll();
	}

	@Override
	public void addBicycle(Bicycle bicycle) {
		bicycleDao.save(bicycle);
	}

	@Override
	public void deleteBicycle(int id) {
		bicycleDao.deleteById(id);
	}

	@Override
	public void updateBicycle(int id, Bicycle bicycle) {
		Optional<Bicycle> b = bicycleDao.findById(id);
		
		if (b.isPresent()) {
			bicycle.setId(id);
			bicycleDao.save(bicycle);
		}
	}
	
	

}
