package by.gsu.epamlab.model.beans;

import static by.gsu.epamlab.model.ConstantsModel.DELIMITER;
import java.sql.Date;

public class Play {
	private Date date;
	private String name;
	private String description;
	private String about;
	private String pictureFileName;

	public Play() {
		super();
	}

	public Play(Date date, String name, String description, String about, String pictureFileName) {
		super();
		this.date = date;
		this.name = name;
		this.description = description;
		this.about = about;
		this.pictureFileName = pictureFileName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getPictureFileName() {
		return pictureFileName;
	}

	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}

	@Override
	public String toString() {
		return name + DELIMITER + description + DELIMITER + about + DELIMITER + pictureFileName + DELIMITER
				+ date.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Play other = (Play) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}