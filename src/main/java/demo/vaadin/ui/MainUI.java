package demo.vaadin.ui;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import demo.vaadin.db.Person;
import demo.vaadin.db.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.vaadin.viritin.SortableLazyList;
import org.vaadin.viritin.button.ConfirmButton;
import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.MTable;
import org.vaadin.viritin.layouts.MHorizontalLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

@Title("Certified personnel")
@Theme("valo")
@SpringUI
public class MainUI extends UI {
    private static final int PAGESIZE = 15;
    private static final long serialVersionUID = 1L;

    @Autowired
    PersonRepository repo;

    private MTable<Person> people = new MTable<>(Person.class)
            .withProperties("fullName", "examName", "examCode", "score")
            .withColumnHeaders("Person name", "Name of the Exam", "Exam code", "Score")
            .setSortableProperties("fullName", "examName", "examCode", "score")
            .withFullWidth();
    private Button addNew = new MButton(FontAwesome.PLUS, this::add);
    private Button edit = new MButton(FontAwesome.PENCIL_SQUARE_O, this::edit);
    private Button delete = new ConfirmButton(FontAwesome.TRASH_O, "Are you sure you want to delete the entry?", this::remove);

    @Override
    protected void init(VaadinRequest request) {
        setContent(
                new MVerticalLayout(
                        //new RichText().withMarkDownResource("/welcome.md"),
                        new MHorizontalLayout(addNew, edit, delete),
                        people
                ).expand(people)
        );
        listEntities();
        people.addMValueChangeListener(e -> adjustActionButtonState());
    }

    protected void adjustActionButtonState() {
        boolean hasSelection = people.getValue() != null;
        edit.setEnabled(hasSelection);
        delete.setEnabled(hasSelection);
    }

    private void listEntities() {
        people.setBeans(findAll());
        adjustActionButtonState();
    }

    private SortableLazyList<Object> findAll() {
        return new SortableLazyList<>(
                getSortablePagingProvider(),
                () -> (int) repo.count(),
                PAGESIZE
        );
    }

    private SortableLazyList.SortablePagingProvider getSortablePagingProvider() {
        return (firstRow, asc, sortProperty) -> repo.findAllBy(
                new PageRequest(
                        firstRow / PAGESIZE,
                        PAGESIZE,
                        asc ? Sort.Direction.ASC : Sort.Direction.DESC,
                        sortProperty == null ? "id" : sortProperty));
    }

    public void add(Button.ClickEvent clickEvent) {
        edit(new Person());
    }

    public void edit(Button.ClickEvent e) {
        edit(people.getValue());
    }

    public void remove(Button.ClickEvent e) {
        repo.delete(people.getValue());
        people.setValue(null);
        listEntities();
    }

    protected void edit(final Person phoneBookEntry) {
        PersonForm personForm = new PersonForm(phoneBookEntry);
        personForm.openInModalPopup();
        personForm.setSavedHandler(this::saveEntry);
        personForm.setResetHandler(this::resetEntry);
    }

    public void saveEntry(Person entry) {
        repo.save(entry);
        listEntities();
        closeWindow();
    }

    public void resetEntry(Person entry) {
        listEntities();
        closeWindow();
    }

    protected void closeWindow() {
        getWindows().stream().forEach(this::removeWindow);
    }
}