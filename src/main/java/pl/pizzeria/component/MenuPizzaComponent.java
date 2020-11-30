package pl.pizzeria.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.pizzeria.model.MenuPizza;

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
