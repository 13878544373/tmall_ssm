package com.entor.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Category;
import com.entor.entity.ProValPro;
import com.entor.entity.Product;
import com.entor.entity.ProductImage;
import com.entor.entity.PropertyValue;
import com.entor.entity.Review;
import com.entor.entity.User;
import com.entor.service.CategoryService;
import com.entor.service.HomeService;
import com.entor.service.ProductImageService;
import com.entor.service.ProductService;
import com.entor.service.PropertyValueService;
import com.entor.service.ReviewService;
import com.entor.service.UserService;

@Controller
public class HomePageController {

	@Resource
	private CategoryService cas;
	@Resource
	private HomeService hs;
	@Resource
	private ProductService ps;
	@Resource
	private ProductImageService pis;
	@Resource
	private PropertyValueService pvse;
	@Resource
	private ReviewService rs;
	@Resource
	private UserService us;
	
	@RequestMapping("/forehomepage")
	public String homePage(HttpServletRequest req) {
		List<Category> clist = getCs();
		req.setAttribute("cs", clist);
		return "fore/home";
	}
	
	@RequestMapping("/foreproduct")
	public String homeProduct(int pid,HttpServletRequest req) {
		List<ProductImage> single = new ArrayList<>();
		List<ProductImage> detail = new ArrayList<>();
		List<Category> clist = getCs();
		
		//查一个产品
		Product pr = ps.queryById(Product.class, pid);
		//查类别
		Category ca = cas.queryById(Category.class, pr.getCid());
		//查所有图片
		List<ProductImage> pimg = pis.queryByPidAll(pid);
		for (ProductImage pImage : pimg) {
			String type = pImage.getType();
			//判断图片位置
			if (type.equals("type_single")) {
				single.add(pImage);
			}else {
				detail.add(pImage);
			}
		}
		pr.setProductSingleImages(single);
		pr.setProductDetailImages(detail);
		//根据产品id查询产品属性
		List<ProValPro> pvs = pvse.queryPid(pid);
		req.setAttribute("cs", clist);
		pr.setPiId(pis.queryByPid(pid));
		req.setAttribute("p", pr);
		req.setAttribute("ca", ca);
		req.setAttribute("pvs", pvs);
		return "fore/product";
	}
	
	@RequestMapping("/forecategory")
	public String homeCategory(int cid, HttpServletRequest req) {
		List<Category> clist = getCs();
		//获取单个类别
		Category c = cas.queryById(Category.class, cid);
		//查出类别下的产品
		List<Product> p = ps.queryByCidPage(c.getId(), 1, 10);
		for (Product product : p) {
			//为产品添加第一张图id
			product.setPiId(pis.queryByPid(product.getId()));
		}
		c.setProducts(p);
		//获取所有评论
//		List<Review> rlist = rs.queryAll();
		
		req.setAttribute("cs", clist);
		req.setAttribute("c", c);
		return "fore/category";
	}
	
	@RequestMapping("/foresearch")
	public String homeSearch(String keyword, HttpServletRequest req) {
		List<Product> plist = ps.vagueQuery(keyword);
		for (Product product : plist) {
			int pid = pis.queryByPid(product.getId());
			product.setPiId(pid);
		}
		req.setAttribute("ps", plist);
		return "fore/searchResult";
	}
	//跳转登录界面
	@RequestMapping("/loginPage")
	public String loginPage() {
		return "fore/login";
	}
	//登陆处理
	@RequestMapping("/forelogin")
	public String login(String name, String password, HttpServletRequest req) {
		User user = us.login(name, password);
		if (user!=null) {
			req.setAttribute("user", user);
			req.getSession().setAttribute("user", user);
			return "forward:/forehomepage";
		}else {
			req.setAttribute("msg", "账号或密码错误");
			return "forward:/loginPage";
		}
	}
	
	//注销账户
	@RequestMapping("/forelogout")
	public String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		return "redirect:/forehomepage";
	}
	
	//跳转注册界面
	@RequestMapping("/registerPage")
	public String registerPage(HttpServletRequest req) {
		List<Category> clist = getCs();
		req.setAttribute("cs", clist);
		return "fore/register";
	}
	//注册处理
	@RequestMapping("/foreregister")
	public String register(String name, String password,HttpServletRequest req) {
		User  u = us.register(name);
		if (u==null) {
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			us.add(user);
		}else {
			req.setAttribute("msg", "账号名存在,请重新选择");
		}
		return "fore/registerSuccess";
	}
	//按购买时没登录跳到foreloginajax登录,
	@RequestMapping("/forecheckLogin")
	public String logincheck(HttpServletRequest req,HttpServletResponse res) throws IOException {
		Object user = req.getSession().getAttribute("user");
		if (user==null) {
			return "forward:/foreloginAjax";
		}else {
			PrintWriter pw = res.getWriter();
			pw.write("success");
			pw.flush();
			pw.close();
			return "forward:/fore/product.jsp";
		}
		
	}
	//按购买时没登录弹出登录界面出来
	@RequestMapping("/foreloginAjax")
	public String loginajax(String name,String password,HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		User user = us.login(name, password);
		if (user!=null) {
			req.getSession().setAttribute("user", user);
			out.write("success");
		}else {
			out.write("lose");
		}
		out.flush();
		out.close();
		return "fore/product";
	}
	
	//跳转到订单界面
	@RequestMapping("/forebuyone")
	public String buyone(int pid,int num,HttpServletRequest req) {
		return "fore/buy";
	}
	
	//获取全部产品类别
	public List<Category> getCs(){
		//查出所有类别
		List<Category> list = hs.queryAll();
		for (Category c : list) {
			//查出类别下的产品
			List<Product> p = ps.queryByCidPage(c.getId(), 1, 10);
			for (Product product : p) {
				//为产品添加第一张图id
				product.setPiId(pis.queryByPid(product.getId()));
			}
			c.setProducts(p);
		}
		return list;
	}
}
