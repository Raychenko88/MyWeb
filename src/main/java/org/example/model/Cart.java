package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private Integer id;
    private Long creationTime;
    private Integer closed;
    private Integer userId;

    public Cart(Long creationTime, Integer closed, Integer userId) {
        this.creationTime = creationTime;
        this.closed = closed;
        this.userId = userId;
    }
}
