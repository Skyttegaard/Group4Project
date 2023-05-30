package controller;

import dbo.FitterDB;
import dbo.FitterDBIF;
import model.Fitter;

public class FitterController implements FitterControllerIF{
	
	private FitterDBIF fitterDB = new FitterDB();
	@Override
	public Fitter getFitter(int fitterId) {
		return fitterDB.getFitter(fitterId);
	}
	
}
