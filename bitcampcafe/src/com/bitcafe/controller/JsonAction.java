package com.bitcafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

public interface JsonAction {
	public JSONObject execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
