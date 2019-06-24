package com.bitcafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.util.ForwardAction;

public interface Action {
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
