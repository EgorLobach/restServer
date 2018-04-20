package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.NONE)
public class Item {

    @XmlElement(name = "itemName")
    private String itemName;

    @XmlElement(name = "yearOfPublication")
    private long yearOfPublication;

    @XmlElement(name = "author")
    private Author author;

    @XmlElement(name = "chapters")
    private List<Chapter> chapters;

    public Item() {
        chapters = new ArrayList<Chapter>();
    }

    public Item(String itemName, long yearOfPublication, Author author, List<Chapter> chapters) {
        this.itemName = itemName;
        this.yearOfPublication = yearOfPublication;
        this.author = author;
        this.chapters = chapters;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public long getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(long yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public void addChapter(Chapter chapter){
        this.chapters.add(chapter);
    }
}
