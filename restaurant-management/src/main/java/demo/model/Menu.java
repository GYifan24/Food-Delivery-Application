package demo.model;

import lombok.NoArgsConstructor;

import java.util.HashMap;

@NoArgsConstructor
public class Menu {

    HashMap<String, Double> menu;

    @Override
    public String toString(){
        StringBuilder menuStr = new StringBuilder();
        menuStr.append("MENU");
        for(String name : menu.keySet()) {
            double price;
            price = menu.get(name);
            String s = name + " :" + price + "\n";
            menuStr.append(s);
        }
        return menuStr.toString();

    }
}
