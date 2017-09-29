package com.shimh.model.embeddedableType.multiple;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@AttributeOverrides({
    @AttributeOverride(
        name = "ebookPublisher.name",
        column = @Column(name = "ebook_publisher_name")
    ),
    @AttributeOverride(
        name = "paperBackPublisher.name",
        column = @Column(name = "paper_back_publisher_name")
    ),
    @AttributeOverride(
        name = "paperBackPublisher.country",
        column = @Column(name = "paper_back_publisher_country")
    ),
    @AttributeOverride(
        name = "paperBackPublisher.country",
        column = @Column(name = "paper_back_publisher_country")
    )
})

/*
 * 用于关联属性
 * @AssociationOverrides({
    @AssociationOverride(
        name = "ebookPublisher.country",
        joinColumns = @JoinColumn(name = "ebook_publisher_country_id")
    ),
    @AssociationOverride(
        name = "paperBackPublisher.country",
        joinColumns = @JoinColumn(name = "paper_back_publisher_country_id")
    )
})*/
//@Table
//@Entity
public class Book {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    private String title;

    private String author;

    private Publisher ebookPublisher;

    private Publisher paperBackPublisher;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Publisher getEbookPublisher() {
		return ebookPublisher;
	}

	public void setEbookPublisher(Publisher ebookPublisher) {
		this.ebookPublisher = ebookPublisher;
	}

	public Publisher getPaperBackPublisher() {
		return paperBackPublisher;
	}

	public void setPaperBackPublisher(Publisher paperBackPublisher) {
		this.paperBackPublisher = paperBackPublisher;
	}

    
}
