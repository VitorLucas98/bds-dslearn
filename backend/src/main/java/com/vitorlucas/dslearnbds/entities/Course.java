package com.vitorlucas.dslearnbds.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course  implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String imgUri;
	private String imgGrayUri;
	private List<Offer> offers = new ArrayList<>();
	
	public Course() {
	}

	public Course(Long id, String name, String imgUri, String imgGrayUri) {
		super();
		this.id = id;
		this.name = name;
		this.imgUri = imgUri;
		this.imgGrayUri = imgGrayUri;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUri() {
		return imgUri;
	}

	public void setImgUri(String imgUri) {
		this.imgUri = imgUri;
	}

	public String getImgGrayUri() {
		return imgGrayUri;
	}

	public void setImgGrayUri(String imgGrayUri) {
		this.imgGrayUri = imgGrayUri;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}