package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer id;
    private Integer itemId;
    private Integer cartId;
    private Integer amount;


    public Order(Integer itemId, Integer cartId, Integer amount) {
        this.itemId = itemId;
        this.amount = amount;
        this.cartId = cartId;
    }
}
