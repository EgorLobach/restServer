package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "chapter")
@XmlAccessorType(XmlAccessType.NONE)
public class Chapter {

    @XmlElement(name="chapterName")
    private String chapterName;

    @XmlElement(name="text")
    private String text;

    public Chapter() {
    }

    public Chapter(String chapterName, String text) {
        this.chapterName = chapterName;
        this.text = text;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
