package com.yelpCamp.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.yelpCamp.entity.Campground;

import java.util.ArrayList;
import java.util.Collection;



public interface CampgroundDao {
	Collection<DBObject> getAllCampgrounds();

	BasicDBObject getCampgroundById(double id);

    void deleteCampgroundById(double id);

    void updateCampground(Campground campground);

    void insertCampground(Campground campground);
}
