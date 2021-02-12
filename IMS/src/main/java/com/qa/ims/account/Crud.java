package com.qa.ims.account;



/**
 * Create, Read, Update and Delete controller. Takes in inputs for each action
 * to be sent to a service class
 */
public interface Crud<T> {

	T login();

	T create();



}
