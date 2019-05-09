package cucumberTest;

import org.apache.commons.io.FilenameUtils;
import org.testng.Assert;

public class testJ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerifyInvalidFileErrorMsg("abc.xml");		

	}


public static boolean VerifyInvalidFileErrorMsg(String fileName)
        {
	
			String basename = FilenameUtils.getBaseName(fileName);
			String extension = FilenameUtils.getExtension(fileName);
			
			System.out.println(basename); // file
			System.out.println(extension); // txt (NOT ".txt" !)
		
			String fileType[] = fileName.split(".");
			for(int i=0;i<=fileType.length;i++)
			{
				System.out.println(fileType[i]);
			}
            Boolean element = false;
            String exptdmsg = "Error - Invalid." + fileType + " file uploaded";
           
            switch (fileType[1])
            {
                case "csv":
                	String msgcsv = "Error - Invalid.csv file uploaded";
                    element =  msgcsv.equals(exptdmsg);
                    System.out.println("CSV :" + element);
                    break;
                case "xml":
                	String msgxml = "Error - Invalid.xml file uploaded";
                	element = msgxml.equals(exptdmsg);
                	System.out.println("XML :" + element);
                    break;
                 default:
                    element = false;
            }
            return element;
        }
}