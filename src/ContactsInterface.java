

import java.util.List;


public interface ContactsInterface {
    List<Contact> all();
    List<Contact> search(String searchTerm);
    void add(Contact contact);
    void remove(Contact contact);
}