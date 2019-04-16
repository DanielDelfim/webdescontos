package com.danieldelfim.webdescontos.parser.lomadee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.jar.JarException;

import com.google.gson.Gson;

public class ParserLomadeeUtil {

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static String readJsonFromUrl(String url) throws IOException, JarException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			return jsonText;
		} finally {
			is.close();
		}
	}

	public static CouponLomadeeResponse getCouponLomadeeResponse() throws JarException, IOException {
		String valor = readJsonFromUrl(
				"http://sandbox-api.lomadee.com/v2/155432384104638958bf5/coupon/_all?sourceId=36115094");
		System.out.println(valor);

		return new Gson().fromJson(valor, CouponLomadeeResponse.class);

	}

	public static void main(String[] args) throws IOException, JarException {
		CouponLomadeeResponse couponLomadeeResponse = getCouponLomadeeResponse();
		System.out.println(couponLomadeeResponse.getCoupons().size());
		for (CouponLomadee couponLomadee : couponLomadeeResponse.getCoupons()) {
			System.out.println(couponLomadee.getDescription());
		}

	}
}
