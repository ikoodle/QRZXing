package com.ikoodle.Zxing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRZxing {
 //生成二维码
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
       int width = 300; //指定二维码的宽度
       int height = 300; //指定二维码的高度
       String format = "png"; //指定生成的图片格式
       String content = "www.ikoodle.com"; //指定生成的内容
       
       //定义二维码的参数
       HashMap hm = new HashMap();
       hm.put(EncodeHintType.CHARACTER_SET, "utf-8");  //指定字符编码
       hm.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);//指定纠错等级，等级越高，存储信息越少
       hm.put(EncodeHintType.MARGIN,2); //指定边距
       
       //生成二维码
       try {
		BitMatrix  bitmatrix = new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE,width,height,hm);
		Path file = new File("D:/code/img.png").toPath();
		MatrixToImageWriter.writeToPath(bitmatrix, format, file);
	} catch (WriterException | IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	}

}
