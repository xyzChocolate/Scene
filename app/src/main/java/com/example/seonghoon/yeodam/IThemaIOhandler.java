package com.example.seonghoon.yeodam;

import java.io.IOException;
import java.io.InputStream;

public interface IThemaIOhandler extends IIOhandler{

	 int read(InputStream inputStream) throws IOException;
	int readRelation(InputStream inputStream) throws IOException;
}
