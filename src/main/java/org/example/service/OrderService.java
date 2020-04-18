package org.example.service;


import org.example.dao.OrderDAO;
import org.example.model.Order;

import java.util.List;

public class OrderService {

    public static Order create(Order order){
        Order dbOrder = OrderDAO.findOrderByItem(order.getItemId());
        if (dbOrder == null){
            OrderDAO.create(order);
            return order;
        }else {
            dbOrder.setAmount(dbOrder.getAmount() + order.getAmount());
            OrderDAO.update(dbOrder);
            return dbOrder;
        }
    }

    public static Order update(Order order){
        if (OrderDAO.findById(order.getId()) != null){
            OrderDAO.update(order);
            return order;
        }
        return null;
    }

    public static void delete(Integer id){
        OrderDAO.delete(id);
    }

    public static Order findById(Integer id){
       return OrderDAO.findById(id);
    }

    public static List<Order> findByCart(Integer cartId){
        return OrderDAO.findByCart(cartId);
    }

    public static Integer sumAnyUserById(Integer id){
        return OrderDAO.sumAnyUserById(id);
    }


}
