package com.pack1.servlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

	//@WebListener

		@Override
		public void sessionCreated(HttpSessionEvent hse)
		{
			System.out.println("Request Object Created");
		}
		@Override
		public void sessionDestroyed(HttpSessionEvent sre)
		{
			System.out.println("Request Object destroyed");
		}
		@Override
		public void attributeAdded(HttpSessionBindingEvent srae)
		{
			System.out.println("Attribute added: " +srae.getName());
		}
		@Override
		public void attributeRemoved(HttpSessionBindingEvent srae)
		{
			System.out.println("Attribute removed");
		}
	}

