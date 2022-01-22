package top.aidan.mybatis.model;

import java.util.Date;
import java.util.Map;

/**
 * Created by Aidan on 2021/8/18 15:30
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class Book {
    private String name;
    private Author author;
    private Date publishDate;
    private Double price;
    private Map<String, Object> info;

    public Book() {
    }

    public Book(String name, Author author, Date publishDate, Double price) {
        this.name = name;
        this.author = author;
        this.publishDate = publishDate;
        this.price = price;
    }

    public Book(String name, Author author, Double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author=" + author +
                ", publishDate=" + publishDate +
                ", price=" + price +
                ", info=" + info +
                '}';
    }
}
