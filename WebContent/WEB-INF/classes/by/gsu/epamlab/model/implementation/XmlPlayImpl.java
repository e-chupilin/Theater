package by.gsu.epamlab.model.implementation;

import static by.gsu.epamlab.model.ConstantsModel.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.gsu.epamlab.ifaces.IPlayDAO;
import by.gsu.epamlab.model.beans.Play;
import by.gsu.epamlab.model.exceptions.DaoException;
import by.gsu.epamlab.model.xml.ResultHandler;
import by.gsu.epamlab.utilities.ServletUtilities;

public class XmlPlayImpl implements IPlayDAO {

	public List<Play> getPlays() throws DaoException {
		try {
			XMLReader xmlReader = XMLReaderFactory.createXMLReader();
			ResultHandler resultHandler = new ResultHandler();
			xmlReader.setContentHandler(resultHandler);

			if (resultHandler != null) {
				xmlReader.parse(ServletUtilities.getApplicationPath() + XML_PATH + XML_FILE_NAME_PLAYS);
			}
			return resultHandler.getPlay();

		} catch (SAXException | IOException | ServletException e) {
			System.err.println(e.getMessage());
			throw new DaoException(ERROR_XML_PARSE);
		}
	}

	public Play getPlay(Date date) throws DaoException {
		List<Play> plays = getPlays();
		Play playToReturn = null;
		for (Play play : plays) {
			if (play.getDate().equals(date)) {
				playToReturn = play;
			}
		}
		if (playToReturn != null) {
			return playToReturn;
		} else {
			throw new DaoException(ERROR_PLAY_NOT_FOUND);
		}
	}

	@Override
	public void addPlay(Play playToSet) throws DaoException {
		ServletUtilities.checkInputOnNull(playToSet);
		ServletUtilities.checkInputOnNull(playToSet.getDate(), playToSet.getName(), playToSet.getDescription(),
				playToSet.getAbout(), playToSet.getPictureFileName());

		List<Play> plays = getPlays();
		plays.add(playToSet);
		writePlaysToXml(plays);
	}

	@Override
	public void deletePlay(Date date) throws DaoException {
		ServletUtilities.checkInputOnNull(date);

		List<Play> plays = getPlays();
		Iterator<Play> iterator = plays.iterator();
		while (iterator.hasNext()) {
			Play play = iterator.next();
			if (play.getDate().equals(date)) {
				iterator.remove();
				System.out.println("remove play");
				writePlaysToXml(plays);
				return;
			}
		}
		throw new DaoException(ERROR_REMOVE_PLAY);
	}

	synchronized private void writePlaysToXml(List<Play> plays) throws DaoException {
		try {
			OutputStream outputStream = new FileOutputStream(
					new File(ServletUtilities.getApplicationPath() + XML_PATH + XML_FILE_NAME_PLAYS));

			XMLStreamWriter out = XMLOutputFactory.newInstance()
					.createXMLStreamWriter(new OutputStreamWriter(outputStream, XML_ENCODING));

			out.writeStartDocument();
			out.writeStartElement(XML_TAG_PLAYS);

			for (Play play : plays) {
				out.writeStartElement(XML_TAG_PLAY);

				out.writeStartElement(XML_TAG_DATE);
				out.writeCharacters(play.getDate().toString());
				out.writeEndElement();

				out.writeStartElement(XML_TAG_NAME);
				out.writeCharacters(play.getName());
				out.writeEndElement();

				out.writeStartElement(XML_TAG_DESCRIPTION);
				out.writeCharacters(play.getDescription());
				out.writeEndElement();

				out.writeStartElement(XML_TAG_ABOUT);
				out.writeCharacters(play.getAbout());
				out.writeEndElement();

				out.writeStartElement(XML_TAG_PICTURE);
				out.writeCharacters(play.getPictureFileName());
				out.writeEndElement();

				out.writeEndElement();
			}
			out.writeEndElement();
			out.close();
		} catch (ServletException | XMLStreamException | FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}
	}
}