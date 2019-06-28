package com.bitcafe.controller.calendar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface GetJsonAction {
	public JSONArray execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

}
