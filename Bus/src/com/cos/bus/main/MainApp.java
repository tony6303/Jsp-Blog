package com.cos.bus.main;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.cos.bus.api.ApiExplorer;
import com.cos.bus.api.ApiExplorer2;

public class MainApp {

	public static void main(String[] args) throws Exception {
    	ApiExplorer ae = new ApiExplorer();
    	ae.busInfoParse();
    	
//    	ApiExplorer2 ae2 = new ApiExplorer2();
//    	ae2.busStationInfo();
    }

}
