package com.entor.dao;

import java.util.List;

import com.entor.entity.Review;

public interface ReviewDao extends BaseDao<Review>{

	List<Review> queryAll();
}
