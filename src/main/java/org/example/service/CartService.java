package org.example.service;

import org.example.dao.CartDAO;
import org.example.model.Cart;
import org.example.model.User;

import java.util.List;

public class CartService {

    public static Cart create(Cart cart){
        if (CartDAO.findOpenCartByUser(cart.getUserId()) == null){
            CartDAO.create(cart);
            return cart;
        }
        return null;
    }

    public static Cart update(Cart cart){
        if (CartDAO.findOpenCartByUser(cart.getUserId()) != null){
            CartDAO.update(cart);
            return cart;
        }
        return null;
    }

    public static void delete(Cart cart){
    CartDAO.delete(cart);
    }

    public static Cart findById(Integer id){
       return CartDAO.findById(id);
    }

    public static List<Cart> findByUser(User user){
        return CartDAO.findByUser(user);
    }

    public static Cart findOpenCartByUser(Integer userId){
        return CartDAO.findOpenCartByUser(userId);
    }
}
