/*******************************************************************************
 * Copyright 2015-2024 Open Text.
 *
 * The only warranties for products and services of Open Text and its
 * affiliates and licensors ("Open Text") are as may be set forth in the
 * express warranty statements accompanying such products and services.
 * Nothing herein should be construed as constituting an additional warranty.
 * Open Text shall not be liable for technical or editorial errors or
 * omissions contained herein. The information contained herein is subject
 * to change without notice.
 *
 * Except as specifically indicated otherwise, this document contains
 * confidential information and a valid license is required for possession,
 * use or copying. If this work is provided to the U.S. Government, consistent
 * with FAR 12.211 and 12.212, Commercial Computer Software, Computer Software
 * Documentation, and Technical Data for Commercial Items are licensed to the
 * U.S. Government under vendor's standard commercial license.
 ******************************************************************************/
package com.fortify.sample.bugtracker.alm.infra;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 *
 * This file has been taken as is from ALM REST documentation
 * available at http://almhost:port/qcbin/Help/doc_library/api_refs/REST/webframe.html
 *
 * A utility class for converting between JAXB annotated objects and XML.
 */
public class EntityMarshallingUtils {

	private EntityMarshallingUtils() {
	}

	/**
	 * @param <T>
	 *            the type to serialize
	 * @param c
	 *            the class of the type to serialize
	 * @param o
	 *            the instance containing the data to serialize
	 * @return a string representation of the data.
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> String marshal(Class<T> c, Object o) throws JAXBException {
		JAXBContext ctx = JAXBContext.newInstance(c);
		Marshaller marshaller = ctx.createMarshaller();
		StringWriter entityXml = new StringWriter();
		marshaller.marshal(o, entityXml);
		String entityString = entityXml.toString();
		return entityString;
	}
}
