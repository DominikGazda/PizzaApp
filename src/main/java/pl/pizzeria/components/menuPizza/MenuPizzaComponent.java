package pl.pizzeria.components.menuPizza;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.pizzeria.components.menuPizza.MenuPizza;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class MenuPizzaComponent {

    private List<MenuPizza> menuPizzaList;

    public MenuPizzaComponent(){
        clear();
    }

    public List<MenuPizza> getMenuPizzaList() {
        return menuPizzaList;
    }

    public void setMenuPizzaList(List<MenuPizza> menuPizzaList) {
        this.menuPizzaList = menuPizzaList;
    }

    public void clear(){
        menuPizzaList = new ArrayList<>();
    }

}
