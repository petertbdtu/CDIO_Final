package gr_34.controller;

import gr_34.entity.AbstraktFelt;
import gr_34.entity.FeltCreator;

public class BrætController {

	AbstraktFelt[] felter;
	
	public BrætController()
	{
		this.felter = FeltCreator.opretFelter();
	}

	public AbstraktFelt[] getFelter()
	{
		return this.felter;
	}
	
}
