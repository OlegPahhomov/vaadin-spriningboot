package demo.vaadin.ui;

import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;
import demo.vaadin.db.Person;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.form.AbstractForm;
import org.vaadin.viritin.layouts.MFormLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

public class PersonForm extends AbstractForm<Person> {

    TextField fullName = new MTextField("Full name");
    TextField examName = new MTextField("Name of the exam");
    TextField examCode = new MTextField("Exam code");
    TextField score = new MTextField("Exam score");

    public PersonForm(Person person) {
        setSizeUndefined();
        setEntity(person);
    }

    @Override
    protected Component createContent() {
        return new MVerticalLayout(
                new MFormLayout(
                        fullName,
                        examName,
                        examCode,
                        score
                ).withWidth(""),
                getToolbar()
        ).withWidth("");
    }
}