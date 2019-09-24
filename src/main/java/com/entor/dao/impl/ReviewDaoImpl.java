package com.entor.dao.impl;

import org.springframework.stereotype.Repository;

import com.entor.dao.ReviewDao;
import com.entor.entity.Review;

@Repository("reviewDao")

public class ReviewDaoImpl extends BaseDaoImpl<Review> implements ReviewDao{

}
