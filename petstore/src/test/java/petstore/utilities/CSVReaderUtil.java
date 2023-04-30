package petstore.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import petstore.payloads.UserPOJO;

public class CSVReaderUtil {

	public static ArrayList<UserPOJO> readAllData() throws FileNotFoundException, IOException, CsvException {

		String filePath = "./testData.csv";
		ArrayList<UserPOJO> userList;
		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			List<String[]> csvData = reader.readAll();
			userList= new ArrayList<>();

			// Skip the first row (column names)
			for (int i = 1; i < csvData.size(); i++) {
				String[] rowData = csvData.get(i);

				if (rowData.length == 7) {
					int id = Integer.parseInt(rowData[0]);
					String username = rowData[1];
					String firstName = rowData[2];
					String lastName = rowData[3];
					String email = rowData[4];
					String password = rowData[5];
					String phone = rowData[6];

					UserPOJO user = new UserPOJO(id, username, firstName, lastName, email, password, phone);
					userList.add(user);
				}
			}
		}
		return userList;
	}



	public static ArrayList<String> readUserName() throws FileNotFoundException, IOException, CsvException {

		String filePath = "./testData.csv";
		ArrayList<String> userNameList;
		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			List<String[]> csvData = reader.readAll();
			userNameList= new ArrayList<>();

			// Skip the first row (column names)
			for (int i = 1; i < csvData.size(); i++) {
				String[] rowData = csvData.get(i);

				if (rowData.length == 7) {
					String username = rowData[1];
					userNameList.add(username);				}
			}
		}
		return userNameList;

	}
}