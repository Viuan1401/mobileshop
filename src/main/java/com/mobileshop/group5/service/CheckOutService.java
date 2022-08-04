package com.mobileshop.group5.service;

import com.mobileshop.group5.common.Constants;
import com.mobileshop.group5.model.Order;
import com.mobileshop.group5.model.OrderDetail;
import com.mobileshop.group5.model.Product;
import com.mobileshop.group5.model.cart.Cart;
import com.mobileshop.group5.model.cart.CartBean;
import com.mobileshop.group5.repository.OrderDetailRepository;
import com.mobileshop.group5.repository.OrderRepository;
import com.mobileshop.group5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class CheckOutService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public boolean checkOut(HttpSession session){
        boolean flag = false;
        CartBean cartBean = (CartBean) session.getAttribute(Constants.ATTR_CART);
        /*Object principal = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();
        String username="";
        if (principal instanceof MyUserDetails) {
            username = ((MyUserDetails)principal). getUsername();
        }*/
        if (cartBean!=null && !cartBean.isEmpty() ){
            Order order = new Order();
            order.setDate(new Timestamp((new Date().getTime())));
            order.setTotal(cartBean.getTotal());
            order.setUserId("khang");
            order = orderRepository.save(order);
            if (order.getOrderId()>0){
                for (Object object : cartBean.values() ){
                    OrderDetail orderDetail = new OrderDetail();
                    Cart cart = (Cart) object;
                    Product product = cart.getProduct();
                    orderDetail.setOrderId(order.getOrderId());
                    orderDetail.setQuantity(cart.getQuantity());
                    orderDetail.setPrice(product.getPrice());
                    orderDetail.setProductId(product.getProductId());
                    orderDetailRepository.save(orderDetail);
                }
                for (Object object : cartBean.values() ){
                    Cart cart = (Cart) object;
                    Product product = cart.getProduct();
                    if (product.getQuantity()>=cart.getQuantity()){
                        product.setQuantity(product.getQuantity()-cart.getQuantity());
                        productRepository.save(product);
                    }
                }
                flag =true;
            }
        }
        return flag;
    }
}
