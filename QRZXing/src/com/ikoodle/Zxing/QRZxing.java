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
 //���ɶ�ά��
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
       int width = 300; //ָ����ά��Ŀ��
       int height = 300; //ָ����ά��ĸ߶�
       String format = "png"; //ָ�����ɵ�ͼƬ��ʽ
       String content = "www.ikoodle.com"; //ָ�����ɵ�����
       
       //�����ά��Ĳ���
       HashMap hm = new HashMap();
       hm.put(EncodeHintType.CHARACTER_SET, "utf-8");  //ָ���ַ�����
       hm.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);//ָ������ȼ����ȼ�Խ�ߣ��洢��ϢԽ��
       hm.put(EncodeHintType.MARGIN,2); //ָ���߾�
       
       //���ɶ�ά��
       try {
		BitMatrix  bitmatrix = new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE,width,height,hm);
		Path file = new File("D:/code/img.png").toPath();
		MatrixToImageWriter.writeToPath(bitmatrix, format, file);
	} catch (WriterException | IOException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}
	}

}
