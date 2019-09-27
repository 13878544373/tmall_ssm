package com.entor.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entor.dao.ReviewDao;
import com.entor.entity.Review;

@Repository("reviewDao")

public class ReviewDaoImpl extends BaseDaoImpl<Review> implements ReviewDao{

	private final String namespace = "Review";
	@Override
	public List<Review> queryAll() {
		return getSqlSession().selectList(namespace+".queryAll");
	}

}
