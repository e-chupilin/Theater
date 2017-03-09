package by.gsu.epamlab.model.xml;

import static by.gsu.epamlab.model.ConstantsModel.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import by.gsu.epamlab.model.beans.Play;

public class ResultHandler extends DefaultHandler {

	private static enum PlayEnum {
		DATE, NAME, DESCRIPTION, ABOUT, PICTURE
	}

	private List<Play> Plays = new ArrayList<>();
	private PlayEnum playEnum = null;
	private Play play;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		if (XML_TAG_DATE.equals(qName)) {
			play = new Play();
			playEnum = PlayEnum.valueOf(XML_TAG_DATE.toUpperCase());
		}

		if (XML_TAG_NAME.equals(qName)) {
			playEnum = PlayEnum.valueOf(XML_TAG_NAME.toUpperCase());
		}

		if (XML_TAG_DESCRIPTION.equals(qName)) {
			playEnum = PlayEnum.valueOf(XML_TAG_DESCRIPTION.toUpperCase());
		}

		if (XML_TAG_ABOUT.equals(qName)) {
			playEnum = PlayEnum.valueOf(XML_TAG_ABOUT.toUpperCase());
		}

		if (XML_TAG_PICTURE.equals(qName)) {
			playEnum = PlayEnum.valueOf(XML_TAG_PICTURE.toUpperCase());
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		if (playEnum == null) {
			return;
		}
		switch (playEnum) {
		
		case DATE:
			play.setDate(getDate(new String(ch, start, length)));
			playEnum = null;
			break;

		case NAME:
			play.setName(new String(ch, start, length));
			playEnum = null;
			break;

		case DESCRIPTION:
			play.setDescription(new String(ch, start, length));
			playEnum = null;
			break;

		case ABOUT:
			play.setAbout(new String(ch, start, length));
			playEnum = null;
			break;

		case PICTURE:
			play.setPictureFileName(new String(ch, start, length));
			playEnum = null;
			Plays.add(play);
			break;
		}
	}

	public List<Play> getPlay() {
		return Plays;
	}

	protected Date getDate(String stringDate) {
		try {			
			return Date.valueOf(stringDate);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
			throw new IllegalArgumentException(ERROR_XML_DATE, e);
		}
	}
}