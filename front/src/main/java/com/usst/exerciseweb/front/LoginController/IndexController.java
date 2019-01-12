package com.usst.exerciseweb.front.LoginController;

import com.usst.exerciseweb.cartmgr.service.ICartService;
import com.usst.exerciseweb.cartmgr.vo.CartModel;
import com.usst.exerciseweb.cartmgr.vo.CartQueryModel;
import com.usst.exerciseweb.goodsmgr.service.IGoodsService;
import com.usst.exerciseweb.goodsmgr.vo.GoodsModel;
import com.usst.exerciseweb.goodsmgr.vo.GoodsQueryModel;
import com.usst.exerciseweb.ordermgr.service.IOrderDetailService;
import com.usst.exerciseweb.ordermgr.service.IOrderService;
import com.usst.exerciseweb.ordermgr.vo.OrderDetailModel;
import com.usst.exerciseweb.ordermgr.vo.OrderModel;
import com.usst.exerciseweb.ordermgr.vo.OrderQueryModel;
import com.usst.exerciseweb.storemgr.service.IStoreService;
import com.usst.exerciseweb.storemgr.vo.StoreModel;
import com.usst.pageutil.Page;
import com.usst.util.format.DateFormatHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/")
public class IndexController {

	@Qualifier("goodsService")
	@Autowired
	private IGoodsService igs = null;

	@Qualifier("cartService")
	@Autowired
	private ICartService ics = null;

	@Qualifier("orderService")
	@Autowired
	private IOrderService ios = null;

	@Qualifier("orderDetailService")
	@Autowired
	private IOrderDetailService iods = null;

	@Qualifier("storeService")
	@Autowired
	private IStoreService iss = null;
	
	@RequestMapping(value="/toIndex",method=RequestMethod.GET)
	public String toIndex(Model model){
		GoodsQueryModel gqm = new GoodsQueryModel();
		gqm.getPage().setPageShow(100);

		Page<GoodsModel> page = igs.getByConditionPage(gqm);
		
		model.addAttribute("page",page);
		
		
		return "index";
	}
	
	@RequestMapping(value="/toGoodsDesc/{goodsUuid}",method=RequestMethod.GET)
	public String toGoodsDesc(Model model,@PathVariable("goodsUuid")int goodsUuid){
		GoodsModel gm = igs.getByUuid(goodsUuid);
		
		model.addAttribute("m",gm);
		return "goods/desc";
	}
	
	@RequestMapping(value="/addToCart/{goodsUuid}",method=RequestMethod.GET)
	public String addToCart(Model model,@PathVariable("goodsUuid")int goodsUuid,@CookieValue("MyLogin")String myLogin){
		int customerUuid = Integer.parseInt( myLogin.split(",")[0]);
		
		CartModel cm = new CartModel();
		cm.setBuyNum(1);
		cm.setCustomerUuid(customerUuid);
		cm.setGoodsUuid(goodsUuid);
		
		ics.create(cm);
		///////////////////////////
		CartQueryModel cqm = new CartQueryModel();
		cqm.getPage().setPageShow(1000);
		cqm.setCustomerUuid(customerUuid);
		
		
		Page<CartModel>  page = ics.getByConditionPage(cqm);
		
		model.addAttribute("page",page);
		
		return "cart/myCart";
	}
	@RequestMapping(value="/toCart",method=RequestMethod.GET)
	public String toCart(Model model,@CookieValue("MyLogin")String myLogin){
		int customerUuid = Integer.parseInt( myLogin.split(",")[0]);
		
		CartQueryModel cqm = new CartQueryModel();
		cqm.getPage().setPageShow(1000);
		cqm.setCustomerUuid(customerUuid);
		
		Page<CartModel>  page = ics.getByConditionPage(cqm);
		
		model.addAttribute("page",page);
		
		return "cart/myCart";
	}
	@RequestMapping(value="/order",method=RequestMethod.GET)
	public String order(@CookieValue("MyLogin")String myLogin, Model model){
		//1.查出这个人购物车中所有的信息
		int customerUuid = Integer.parseInt(myLogin.split(",")[0]);

		CartQueryModel cartQueryModel = new CartQueryModel();
		cartQueryModel.getPage().setPageShow(1000);
		cartQueryModel.setCustomerUuid(customerUuid);

		Page<CartModel> page = ics.getByConditionPage(cartQueryModel);

		//2.构建订单
		float totalMoney = 0.0f;
		for (CartModel cm : page.getResult()){
			totalMoney += 10;
		}

		OrderModel orderModel = new OrderModel();
		orderModel.setCustomerUuid(customerUuid);
		orderModel.setOrderTime(DateFormatHelper.long2str(System.currentTimeMillis()));
		orderModel.setSaveMoney(0.0F);
		orderModel.setTotalMoney(totalMoney);
		orderModel.setState(1);

		ios.create(orderModel);

		OrderQueryModel orderQueryModel = new OrderQueryModel();
		orderModel.setOrderTime(orderModel.getOrderTime());

		Page<OrderModel> orderModelPage = ios.getByConditionPage(orderQueryModel);
		orderModel = orderModelPage.getResult().get(0);

		//3.for循环
		for (CartModel cm : page.getResult()){
			OrderDetailModel orderDetailModel = new OrderDetailModel();
			orderDetailModel.setGoodsUuid(cm.getGoodsUuid());
			orderDetailModel.setOrderNum(cm.getBuyNum());
			orderDetailModel.setPrice(10.0f);
			orderDetailModel.setMoney(orderDetailModel.getPrice() * orderDetailModel.getOrderNum());
			orderDetailModel.setSaveMoney(0.0f);
			orderDetailModel.setOrderUuid(orderModel.getUuid());

			iods.create(orderDetailModel);

			//4.减库存
			StoreModel storeModel = iss.getByGoodsUuid(cm.getGoodsUuid());
			storeModel.setStoreNum(storeModel.getStoreNum() - orderDetailModel.getOrderNum());
			iss.update(storeModel);

			ics.delete(cm.getUuid());
		}

		return "success";
	}
}
