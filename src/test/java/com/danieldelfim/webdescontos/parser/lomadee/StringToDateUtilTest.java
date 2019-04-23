package com.danieldelfim.webdescontos.parser.lomadee;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class StringToDateUtilTest {

	@Test
	public void testFormataData() throws Exception {
		Date data = StringToDateUtil.formataData("30/04/2019 23:59:00");
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		assertTrue(cal.get(Calendar.DAY_OF_MONTH) == 30);
		assertTrue(cal.get(Calendar.YEAR) == 2019);

	}

}
