package demo.vaadin.ui;

import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;
import demo.vaadin.db.Person;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.form.AbstractForm;
import org.vaadin.viritin.layouts.MFormLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

public class PersonForm extends AbstractForm<Person> {
    private TextField fullName;
    private TextField examName;
    private TextField examCode;
    private TextField score;

    public PersonForm(Person person) {
        fullName = new MTextField("Full name");
        examName = new MTextField("Name of the exam");
        examCode = new MTextField("Exam code");
        examCode.setInputPrompt("XXX-ZZZ");
        examCode.setWidth(100, Unit.PIXELS);
        score = new MTextField("Exam score");
        score.setInputPrompt("YYY");
        score.setWidth(50, Unit.PIXELS);
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