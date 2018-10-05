package com.yelpCamp.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.yelpCamp.entity.Campground;

@Repository
@Qualifier("MongoDB")
public class MongoDBDao implements CampgroundDao{
	
	MongoClient mongoClient = new MongoClient();
	DB database = mongoClient.getDB("campgroundsDev");
	DBCollection collection = database.getCollection("campgrounds");
	
	
	

	public Collection<DBObject> getAllCampgrounds() {
		DBCursor cursor = this.collection.find();
		List<DBObject> campgrounds = new ArrayList<DBObject>();
		
		while (cursor.hasNext()) {
			campgrounds.add(cursor.next());
		}
		return campgrounds;
	}

	
	
	public BasicDBObject getCampgroundById(double id) {
		BasicDBObject query = new BasicDBObject();
		query.put("id", id);
		DBCursor cursor = this.collection.find(query);
		BasicDBObject foundCampground = new BasicDBObject();
		
		while (cursor.hasNext()) {
		    foundCampground.putAll(cursor.next());
		}
		return foundCampground;
	}

	
	
	public void deleteCampgroundById(double id) {
		BasicDBObject query = new BasicDBObject();
		query.put("id", id);
		this.collection.remove(query);
		
	}

	
	
	public void updateCampground(Campground campground) {
		BasicDBObject updatedCampground = new BasicDBObject();
		double id = campground.getId();
		final String name = campground.getName();
		final String info = campground.getInfo();
		updatedCampground.append("$set", new BasicDBObject().append("name", name).append("info", info));
				
		BasicDBObject query = new BasicDBObject().append("id", id);

		this.collection.update(query, updatedCampground);
		
	}

	
	
	public void insertCampground(Campground campground) {
		BasicDBObject document = new BasicDBObject();
		double id = campground.getId();
		final String name = campground.getName();
		final String info = campground.getInfo();		
		document.put("id", id);
		document.put("name", name);
		document.put("info", info);
		this.collection.insert(document);
		
	}


	
}
