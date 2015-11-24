package demo.vaadin.ui;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import demo.vaadin.db.Person;
import demo.vaadin.db.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.button.ConfirmButton;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.MTable;
import org.vaadin.viritin.fields.MTextField;
import org.vaadin.viritin.label.RichText;
import org.vaadin.viritin.layouts.MHorizontalLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

@Title("Certified personnel")
@Theme("valo")
@SpringUI
public class MainUI extends UI {
    private static final long serialVersionUID = 1L;
    public static final String FULL_NAME = "fullName";
    public static final String EXAM_NAME = "examName";
    public static final String EXAM_CODE = "examCode";
    public static final String SCORE = "score";
    @Autowired
    PersonService personService;

    private MTable<Person> people;
    private Button addNew;
    private Button edit;
    private Button delete;
    private final TextField filter;

    public MainUI(){
        this.filter = new MTextField().withInputPrompt("Filter by person name").withWidth(400f, Unit.PIXELS);
        this.people = new MTable<>(Person.class)
                .withProperties(FULL_NAME, EXAM_NAME, EXAM_CODE, SCORE)
                .withColumnHeaders("Person name", "Name of the Exam", "Exam code", "Score")
                .setSortableProperties(FULL_NAME, EXAM_NAME, EXAM_CODE, SCORE)
                .withFullWidth();
        this.addNew = new MButton(FontAwesome.PLUS, this::add);
        this.edit = new MButton(FontAwesome.PENCIL_SQUARE_O, this::edit);
        this.delete = new ConfirmButton(FontAwesome.TRASH_O, "Are you sure you want to delete the entry?", this::remove);
    }

    @Override
    protected void init(VaadinRequest request) {
        filter.addTextChangeListener(e -> listEntities(e.getText()));
        setContent(
                new MVerticalLayout(
                        new RichText().withMarkDownResource("/welcome.md"),
                        new MHorizontalLayout(addNew, edit, delete, filter),
                        people
                ).expand(people)
        );
        listEntities();
        people.addMValueChangeListener(e -> adjustActionButtonState());
    }

    private void adjustActionButtonState() {
        boolean hasSelection = people.getValue() != null;
        edit.setEnabled(hasSelection);
        delete.setEnabled(hasSelection);
    }

    private void listEntities(String filter) {
        people.setBeans(personService.findAll(filter));
        adjustActionButtonState();
    }

    private void listEntities() {
        people.setBeans(personService.findAll(filter.getValue()));
        adjustActionButtonState();
    }

    private void add(Button.ClickEvent e) {
        edit(new Person());
    }

    private void edit(Button.ClickEvent e) {
        edit(people.getValue());
    }

    private void edit(final Person phoneBookEntry) {
        PersonForm personForm = new PersonForm(phoneBookEntry);
        personForm.openInModalPopup();
        personForm.setSavedHandler(this::saveEntry);
        personForm.setResetHandler(this::resetEntry);
    }

    public void saveEntry(Person entry) {
        personService.save(entry);
        listEntities();
        closeWindow();
    }

    public void remove(Button.ClickEvent e) {
        personService.delete(people.getValue());
        people.setValue(null);
        listEntities();
    }

    public void resetEntry(Person entry) {
        listEntities();
        closeWindow();
    }

    protected void closeWindow() {
        getWindows().stream().forEach(this::removeWindow);
    }
}