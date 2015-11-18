package com.example.seonghoon.yeodam;

import java.io.IOException;
import java.io.InputStream;

public interface ILocationIOhandler extends IIOhandler{

	 int read(InputStream inputStream) throws IOException;

}
