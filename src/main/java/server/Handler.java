package server;

import model.Author;
import model.Chapter;
import model.Directory;
import model.Item;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Handler {
    private List<Item> items = new ArrayList<Item>();

    public Handler(){
    }

    public void addItem(Item Item) throws JAXBException {
        items = unmarshal();
        if (items.indexOf(Item)==-1)
            items.add(Item);
        marshal(items);
    }

    public void updateItem(Item Item) throws JAXBException {
        items = unmarshal();
        for(Item i: items)
            if(i.getItemName().equals(Item.getItemName())) {
                items.set(items.indexOf(i), Item);
                marshal(items);
            }
    }

    public void deleteItem(String name) throws JAXBException {
        items = unmarshal();
        for(Item i: items)
            if(i.getItemName().equals(name)) {
                items.remove(i);
                marshal(items);
            }
    }

    public List<Item> getItems() throws JAXBException {
        return unmarshal();
    }

    private List<Item> unmarshal() throws JAXBException {
        File file = new File("D:\\work\\java\\AIPOS\\resources\\temp2.xml");
        JAXBContext context = JAXBContext.newInstance(Directory.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Directory directory = (Directory) unmarshaller.unmarshal(file);
        List<Item> itemList = directory.getItems();
        List<Item> items1 = new ArrayList<Item>();
        for (Item item:itemList){
            Item item1 = new Item();
            item1.setYearOfPublication(item.getYearOfPublication());
            item1.setItemName(item.getItemName());
            Author author = new Author();
            author.setFirstName(item.getAuthor().getFirstName());
            author.setSecondName(item.getAuthor().getSecondName());
            item1.setAuthor(author);
            for (Chapter chapter:item.getChapters()){
                Chapter chapter1 = new Chapter();
                chapter1.setChapterName(chapter.getChapterName());
                chapter1.setText(chapter.getText());
                item1.addChapter(chapter1);
            }
            items1.add(item1);
        }
        return items1;
    }
    private void marshal(List<Item> items) throws JAXBException {
        Directory directory = new Directory();
        directory.setItems(items);
        File file = new File("D:\\work\\java\\AIPOS\\resources\\temp2.xml");
        JAXBContext context = JAXBContext.newInstance(Directory.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(directory, file);
    }
}
