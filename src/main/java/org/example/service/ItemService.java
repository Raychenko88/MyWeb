package org.example.service;

import org.example.dao.ItemDAO;
import org.example.model.Item;

import java.util.List;

public class ItemService {


    public  static Item create(Item item){
        if (ItemDAO.findByItemCode(item.getItemCode()).isEmpty()){
            ItemDAO.create(item);
            return item;
        }
        return null;
    }
    public static Item update(Item item){
        if (ItemDAO.findById(item.getId()) != null){
            ItemDAO.update(item);
            return item;
        }
        return null;
    }

    public static void delete(Item item){
    ItemDAO.delete(item);
    }

    public static Item findById(Integer id){
       return ItemDAO.findById(id);
    }

    public static List<Item> findByItemCode(String code){
        return ItemDAO.findByItemCode(code);
    }

    public static List<Item> findByItemPriceBetween(Integer min, Integer max){
        return ItemDAO.findByItemPriceBetween(min,max);
    }

    private static List<Item> findAll(){
        return ItemDAO.findAll();
    }
}
