package com.pack1.servlet;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;


//@WebListener
public class RequestListener implements ServletRequestAttributeListener,ServletRequestListener {

	@Override
	public void requestInitialized(ServletRequestEvent sre)
	{
		System.out.println("Request Object Created");
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre)
	{
		System.out.println("Request Object destroyed");
	}
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae)
	{
		System.out.println("Attribute added: " +srae.getName());
	}
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae)
	{
		System.out.println("Attribute removed");
	}
}
