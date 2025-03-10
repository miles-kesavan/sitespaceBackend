package com.sitespace.common;

import com.google.zxing.WriterException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class CommonUtil {

	public static void createQR(String data, String empcode
            ,String filePath)throws WriterException, IOException
		{
		
		BitMatrix matrix = 
				new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 200, 200);
		
		Path path = FileSystems.getDefault().getPath(filePath);
		
		MatrixToImageWriter.writeToPath(matrix, "PNG", path);
}
	
}
