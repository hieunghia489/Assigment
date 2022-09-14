/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nghialh.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */
public class CartDTO implements Serializable {

    private Map<String, Integer> items;

    public CartDTO(Map<String, Integer> items) {
        this.items = items;
    }

    public CartDTO() {
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    public void addToCart(String course, int quantity) {
        if (this.items == null) {
            this.items = new HashMap<>();
        }
        if (this.items.containsKey(course)) {
            int value = this.items.get(course);
            quantity += value;
        }
        this.items.put(course, quantity);
    }

    public void removeCourse(String course) {
        if (this.items == null) {
            return;
        }
        if (this.items.containsKey(course)) {
            this.items.remove(course);
        }
        if (this.items.isEmpty()) {
            this.items = null;
        }
    }

    public void updateCourse(String course, int quantity) {
        if (this.items == null) {
            return;
        }
        if (this.items.containsKey(course)) {
            if (quantity == 0) {
                removeCourse(course);
            } else {
                this.items.put(course, quantity);
            }
        }
    }
}
