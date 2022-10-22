package creational;

//import org.json.simple.JSONObject;
//import org.json.simple.JSONArray;
import org.json.JSONObject;
import org.json.JSONArray;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {//this  - a class to construct from books a string of metadata in JSON format.
    private JSONObject OBJ;
    private JSONArray ListOfBooks;

    public JSONBookMetadataFormatter(){
        this.OBJ = new JSONObject();
        this.ListOfBooks = new JSONArray();
    }
    @Override
    public BookMetadataFormatter reset() {
        ListOfBooks.clear();
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        // Please implement this method. You may create additional methods as you see fit.
        JSONObject book = new JSONObject();
        JSONArray author_list = new JSONArray();
        for(String author_name : b.getAuthors()){
            author_list.put(author_name);
        }

        book.put("Book id",b.getISBN());
        book.put("Title",b.getTitle());
        book.put("Plubisher",b.getPublisher());
        book.put("Authors",author_list);

        ListOfBooks.put(book);
        OBJ.put("BOOK", ListOfBooks);

        return this;
    }

    @Override
    public String getMetadataString() {
        return OBJ.toString(4);
    }
}
