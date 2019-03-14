package com.his.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.joda.time.LocalDate;

import com.alibaba.fastjson.JSONArray;
import com.his.domain.User;

import io.netty.util.CharsetUtil;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.ZipOutputStream;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class FileUtil {
	
	private static Logger log = Logger.getLogger(FileUtil.class);
	
	
	/**
	 * 压缩文件路径
	 */
	public static final String ZIP_ROOT = "/home/usr/uscore/";
//	public static final String ZIP_ROOT = "HRe/";
	
	
	private static final String ZIP_PWD = "zippwd";
	
	private final static String lineSeparator = System.getProperty("line.separator", "\n");

	
	/**
	 * 完整得分 0-353
	 * 第一行：基础信息，总得分
	 * 第二行：title
	 * 各项目结果和得分（包括项目0，项目0只有结果，没有得分)
	 * @param user
	 */
	public static String writeResult(User user) {
		JSONArray valArr = user.getItem();
		int[] result = user.getResult();
		StringBuilder sb = new StringBuilder();
		sb.append(user.printUserBase()).append(",").append(user.printScore()).append(lineSeparator)
			.append(title()).append(lineSeparator)
			.append("0," + valArr.getIntValue(0)).append(lineSeparator);
		for (int i = 1; i < result.length; i++) {
			sb.append(i + "," + valArr.getIntValue(i) + "," + result[i - 1]).append(lineSeparator);
		}
		return sb.toString();
	}
	
	public static String title() {
		return "项目序号,结果,得分"; 
	}
	
	/**
	 * 仅有项目0
	 * @param user
	 */
	public static String writeItem0(User user) {
		StringBuilder sb = new StringBuilder();
		sb.append(user.printUserBase()).append(lineSeparator)
			.append(title()).append(lineSeparator)
			.append("0," + user.getItem().getIntValue(0)).append(lineSeparator);
		return sb.toString();
	}
	
	public static String absoluteDir() {
		return ZIP_ROOT + LocalDate.now().toString();
	}
	
	public static File dir() {
		File dir = new File(absoluteDir());
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return dir;
	}
	
	public static void addFileToZip(User user, byte[] data//, ZipOutputStream zipOutputStream
			) throws ZipException, IOException {
		File dir = dir();
		String zipFilePath = dir.getAbsolutePath() + "/" + user.getName() + "_" + user.getId() + "_" + System.currentTimeMillis() + ".zip";
//		String sourcePath = SOURCE_ROOT + user.getName() + "_" + user.getId() + ".txt";
		String fileName = user.getName() + "_" + user.getId() + ".txt";
		
		ZipParameters zipParameters = new ZipParameters();
        zipParameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); // 压缩方式
        zipParameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); // 压缩级别

        zipParameters.setFileNameInZip(fileName);
        
        zipParameters.setEncryptFiles(true);
        zipParameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
        zipParameters.setPassword(ZIP_PWD.toCharArray());
        
        // 源文件是否为外部流，true表示使用内存文件而非本地存储文件
        zipParameters.setSourceExternalStream(true);
        
//        zipOutputStream.putNextEntry(null, zipParameters);
//        zipOutputStream.write(data);
        ZipFile zipFile = new ZipFile(zipFilePath);   
        zipFile.addStream(new ByteArrayInputStream(data), zipParameters);
//        zipOutputStream.closeEntry();
		
	}
	
	public static void closeZipOutputStream(ZipOutputStream zipOutputStream) throws IOException, ZipException {
        if (zipOutputStream == null) {
            return;
        }
        zipOutputStream.finish();
        zipOutputStream.close();
    }
	
	public static void resultToZip(User user) {
		try {
			addFileToZip(user, writeResult(user).getBytes(CharsetUtil.UTF_8));
		} catch (ZipException | IOException e) {
			log.error("Write to zip error1!", e);
		}
	}
	
	public static void item0ToZip(User user) {
		try {
			addFileToZip(user, writeItem0(user).getBytes(CharsetUtil.UTF_8));
		} catch (ZipException | IOException e) {
			log.error("Write to zip error 2!", e);
		}
	}
}
