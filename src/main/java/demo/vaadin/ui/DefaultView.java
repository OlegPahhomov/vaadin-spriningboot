package demo.vaadin.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import demo.vaadin.db.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.persistence.MapKeyEnumerated;

@SpringView(name = DefaultView.VIEW_NAME)
public class DefaultView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "";

    @Autowired
    PersonRepository personRepository;

    @PostConstruct
    void init() {
        addComponent(new Label(personRepository.findAll().toString() + "This is the default view"));
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }
}
