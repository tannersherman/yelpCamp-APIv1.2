package com.yelpCamp.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.yelpCamp.dao.CampgroundDao;
import com.yelpCamp.entity.Campground;

@Service
public class CampgroundService {

    @Autowired
    @Qualifier("MongoDB")
    private CampgroundDao campgroundDao;

    public Collection<DBObject> getAllCampgrounds(){
    	return this.campgroundDao.getAllCampgrounds();
    }

    public BasicDBObject getCampgroundById(double id){
        return this.campgroundDao.getCampgroundById(id);
    }

    public void deleteCampgroundById(double id) {
        this.campgroundDao.deleteCampgroundById(id);
    }

    public void updateCampground(Campground campground){
        this.campgroundDao.updateCampground(campground);
    }

    public void insertCampground(Campground campground) {
        this.campgroundDao.insertCampground(campground);
    }
}

