package controller;

import dbo.FitterDBIF;
import model.Fitter;

public class FitterController implements FitterControllerIF{
	
	private FitterDBIF fitterDB;
	@Override
	public Fitter getFitter(int fitterId) {
		return fitterDB.getFitter(fitterId);
	}
	
}
