package com.learnKafka.libraryeventsconsumer.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LibraryEvent {

	@Id
	@GeneratedValue
    private Integer libraryEventId;

	@OneToOne(mappedBy = "libraryEvent", cascade = {CascadeType.ALL})
    private Book book;
	public Integer getLibraryEventId() {
		return libraryEventId;
	}
	public void setLibraryEventId(Integer libraryEventId) {
		this.libraryEventId = libraryEventId;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "LibraryEvent [libraryEventId=" + libraryEventId + "]";
	}

    
    
    
    
}
