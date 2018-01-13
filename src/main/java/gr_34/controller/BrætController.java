package gr_34.controller;

import gr_34.entity.felter.*;
import gr_34.entity.FeltCreator;

public class BrætController {

	private AbstraktFelt[] felter;
	
	public BrætController()
	{
		this.felter = FeltCreator.getFelter();
	}

	public AbstraktFelt[] getFelter()
	{
		return this.felter;
	}
	
	public AbstraktFelt getFelt(int position)
	{
		return felter[position];
	}
}
