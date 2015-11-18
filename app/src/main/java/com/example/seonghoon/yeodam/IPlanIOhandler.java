package com.example.seonghoon.yeodam;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public interface IPlanIOhandler extends IIOhandler {

	int read(InputStream inputStream) throws IOException, ParseException;
	int save(PlanManager planManager) throws IOException;
	int readRelation(InputStream inputStream) throws IOException;
}
