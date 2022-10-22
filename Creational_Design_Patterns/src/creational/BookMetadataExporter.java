package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.PrintStream;

public abstract class BookMetadataExporter extends BookCollection {//CREATER?? - a class that to export from all the books in its collection the metadata in one of supported formats. You need to implement this class as well as create its subclasses.

    public abstract BookMetadataFormatter getBookMetadataFormatter();

    public void export(PrintStream stream){
        BookMetadataFormatter bookMetadataFormatter = getBookMetadataFormatter();
        for(Book book : books){
            bookMetadataFormatter.append(book);
        }
        stream.print(bookMetadataFormatter.getMetadataString());
    }
}
