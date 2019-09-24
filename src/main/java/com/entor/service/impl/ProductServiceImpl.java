package com.entor.service.impl;

import org.springframework.stereotype.Service;

import com.entor.entity.Product;
import com.entor.service.ProductService;
@Service("productService")

public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService{

}
