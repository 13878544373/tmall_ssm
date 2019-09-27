package com.entor.service;

import java.util.List;

import com.entor.entity.Review;

public interface ReviewService extends BaseService<Review>{

	List<Review> queryAll();
}
