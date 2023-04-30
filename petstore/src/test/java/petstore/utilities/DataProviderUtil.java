package petstore.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;

import com.opencsv.exceptions.CsvException;

import petstore.payloads.UserPOJO;

public class DataProviderUtil {
	@DataProvider(name = "testData")
	public Object[][] readAll() throws FileNotFoundException, IOException, CsvException {
	    ArrayList<UserPOJO> userList = CSVReaderUtil.readAllData();
	    Object[][] data = new Object[userList.size()][1];

	    for (int i = 0; i < userList.size(); i++) {
	        UserPOJO user = userList.get(i);
	        data[i][0] = user;
	    }

	    return data;
	}

	@DataProvider(name = "userData")
	public Object[][] readAllUserName() throws FileNotFoundException, IOException, CsvException {
	    ArrayList<String> userNameList = CSVReaderUtil.readUserName();
	    Object[][] data = new Object[userNameList.size()][1];

	    for (int i = 0; i < userNameList.size(); i++) {
	        String userName = userNameList.get(i);
	        data[i][0] = userName;
	    }

	    return data;
	}



}
