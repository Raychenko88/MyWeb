package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private Integer id;
    private String itemCode;
    private String name;
    private Integer price;
    private Integer availability;

    public Item(String itemCode, String name, Integer price, Integer availability) {
        this.itemCode = itemCode;
        this.name = name;
        this.price = price;
        this.availability = availability;
    }
}
