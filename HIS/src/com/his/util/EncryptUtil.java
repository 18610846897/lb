package com.his.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 功能描述 加密常用类
 */
public class EncryptUtil
{
	private static Logger log = Logger.getLogger(EncryptUtil.class);
	
	public final static String DES_KEY = "LmMGStGtOpF4xNyvYt54EQ==";;
	
	/**
	 * 加密方法
	 * @param jsonStr 需要加密的消息字符串
	 * @return 加密后的字符串
	 */
	public static String encrypt(String jsonStr,String pubKey)
	{
		// 使用DES算法使用加密消息体
		String result = null;
		try
		{
			// 取需要加密内容的utf-8编码。
			byte[] encrypt = jsonStr.getBytes("utf-8");
			// 取MD5Hash码，并组合加密数组
			byte[] md5Hasn = EncryptUtil.MD5Hash(encrypt, 0, encrypt.length);
			// 组合消息体
			byte[] totalByte = EncryptUtil.addMD5(md5Hasn, encrypt);
			// 取密钥和偏转向量
			byte[] key = new byte[8];
			byte[] iv = new byte[8];
			getKeyIV(pubKey, key, iv);
			SecretKeySpec deskey = new SecretKeySpec(key, "DES");
			IvParameterSpec ivParam = new IvParameterSpec(iv);

			byte[] temp = EncryptUtil.DES_CBC_Encrypt(totalByte, deskey, ivParam);
			result = new BASE64Encoder().encode(temp);
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		// 使用Base64加密后返回
		return result;
	}

	/**
	 * 解密方法
	 * @param jsonStr 需要解密的消息字符串
	 * @return 解密后的字符串
	 * @throws Exception
	 */
	public static String decrypt(String jsonStr,String pubKey)
	{
		// 使用DES算法解密
		String result = null;
		try
		{
			// base64解码
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] encBuf = decoder.decodeBuffer(jsonStr);
			// 取密钥和偏转向量
			byte[] key = new byte[8];
			byte[] iv = new byte[8];
			getKeyIV(pubKey, key, iv);
			SecretKeySpec deskey = new SecretKeySpec(key, "DES");
			IvParameterSpec ivParam = new IvParameterSpec(iv);
			byte[] temp = EncryptUtil.DES_CBC_Decrypt(encBuf, deskey, ivParam);
			// 进行解密后的md5Hash校验
			byte[] md5Hash = EncryptUtil.MD5Hash(temp, 16, temp.length - 16);
			// 进行解密校检
			for (int i = 0; i < md5Hash.length; i++)
			{
				if (md5Hash[i] != temp[i])
				{
					throw new Exception();
				}
			}
			result = new String(temp, 16, temp.length - 16, "utf-8");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		// 返回解密后的数组，其中前16位MD5Hash码要除去。
		return result;
	}

	/**
	 * <li>方法名称:TripleDES_CBC_Encrypt</li>
	 * <li>功能描述:
	 * <pre>经过封装的三重DES/CBC加密算法，如果包含中文，请注意编码。</pre>
	 * </li>
	 * @param sourceBuf  需要加密内容的字节数组。
	 * @param deskey KEY 由24位字节数组通过SecretKeySpec类转换而成。
	 * @param ivParam IV偏转向量，由8位字节数组通过IvParameterSpec类转换而成。
	 * @return 加密后的字节数组
	 * @throws Exception
	 */
	public static byte[] TripleDES_CBC_Encrypt(byte[] sourceBuf, SecretKeySpec deskey, IvParameterSpec ivParam)
			throws Exception
	{
		byte[] cipherByte;
		// 使用DES对称加密算法的CBC模式加密
		Cipher encrypt = Cipher.getInstance("TripleDES/CBC/PKCS5Padding");

		encrypt.init(Cipher.ENCRYPT_MODE, deskey, ivParam);

		cipherByte = encrypt.doFinal(sourceBuf, 0, sourceBuf.length);
		// 返回加密后的字节数组
		return cipherByte;
	}

	/**
	 * <li>方法名称:TripleDES_CBC_Decrypt</li>
	 * <li>功能描述:
	 * <pre>经过封装的三重DES / CBC解密算法</pre>
	 * </li>
	 * @param sourceBuf 需要解密内容的字节数组
	 * @param deskey KEY 由24位字节数组通过SecretKeySpec类转换而成。
	 * @param ivParam IV偏转向量，由6位字节数组通过IvParameterSpec类转换而成。
	 * @return 解密后的字节数组
	 * @throws Exception
	 */
	public static byte[] TripleDES_CBC_Decrypt(byte[] sourceBuf, SecretKeySpec deskey, IvParameterSpec ivParam)
			throws Exception
	{

		byte[] cipherByte;
		// 获得Cipher实例，使用CBC模式。
		Cipher decrypt = Cipher.getInstance("TripleDES/CBC/PKCS5Padding");
		// 初始化加密实例，定义为解密功能，并传入密钥，偏转向量
		decrypt.init(Cipher.DECRYPT_MODE, deskey, ivParam);

		cipherByte = decrypt.doFinal(sourceBuf, 0, sourceBuf.length);
		// 返回解密后的字节数组
		return cipherByte;
	}

	/**
	 * <li>方法名称:DES_CBC_Encrypt</li>
	 * <li>功能描述:
	 * <pre>经过封装的DES/CBC加密算法，如果包含中文，请注意编码。</pre>
	 * </li>
	 * @param sourceBuf 需要加密内容的字节数组。
	 * @param deskey KEY 由8位字节数组通过SecretKeySpec类转换而成。
	 * @param ivParam IV偏转向量，由8位字节数组通过IvParameterSpec类转换而成。
	 * @return 加密后的字节数组
	 * @throws Exception
	 */
	public static byte[] DES_CBC_Encrypt(byte[] sourceBuf, SecretKeySpec deskey, IvParameterSpec ivParam)
			throws Exception
	{
		byte[] cipherByte;
		// 使用DES对称加密算法的CBC模式加密
		Cipher encrypt = Cipher.getInstance("DES/CBC/PKCS5Padding");

		encrypt.init(Cipher.ENCRYPT_MODE, deskey, ivParam);

		cipherByte = encrypt.doFinal(sourceBuf, 0, sourceBuf.length);
		// 返回加密后的字节数组
		return cipherByte;
	}

	/**
	 * <li>方法名称:DES_CBC_Decrypt</li>
	 * <li>功能描述:
	 * <pre>经过封装的DES/CBC解密算法。</pre>
	 * </li>
	 * @param sourceBuf 需要解密内容的字节数组
	 * @param deskey KEY 由8位字节数组通过SecretKeySpec类转换而成。
	 * @param ivParam IV偏转向量，由6位字节数组通过IvParameterSpec类转换而成。
	 * @return 解密后的字节数组
	 * @throws Exception
	 */
	public static byte[] DES_CBC_Decrypt(byte[] sourceBuf, SecretKeySpec deskey, IvParameterSpec ivParam)
			throws Exception
	{

		byte[] cipherByte;
		// 获得Cipher实例，使用CBC模式。
		Cipher decrypt = Cipher.getInstance("DES/CBC/PKCS5Padding");
		// 初始化加密实例，定义为解密功能，并传入密钥，偏转向量
		decrypt.init(Cipher.DECRYPT_MODE, deskey, ivParam);

		cipherByte = decrypt.doFinal(sourceBuf, 0, sourceBuf.length);
		// 返回解密后的字节数组
		return cipherByte;
	}

	/**
	 * <li>方法名称:MD5Hash</li>
	 * <li>功能描述:
	 * <pre>MD5，进行了简单的封装，以适用于加，解密字符串的校验。</pre>
	 * </li>
	 * @param buf 需要MD5加密字节数组。
	 * @param offset 加密数据起始位置。
	 * @param length 需要加密的数组长度。
	 * @return
	 * @throws Exception
	 */
	public static byte[] MD5Hash(byte[] buf, int offset, int length) throws Exception
	{
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(buf, offset, length);
		return md.digest();
	}

	/**
	 * <li>方法名称:byte2hex</li>
	 * <li>功能描述:
	 * <pre>字节数组转换为二行制表示</pre>
	 * </li>
	 * @param inStr 需要转换字节数组。
	 * @return 字节数组的二进制表示。
	 */
	public static String byte2hex(byte[] inStr)
	{
		String stmp;
		// out = new StringBuffer(inStr.length * 2);
		String out = new String("");
		for (int n = 0; n < inStr.length; n++)
		{
			// 字节做"与"运算，去除高位置字节 11111111
			stmp = Integer.toHexString(inStr[n] & 0xFF);
			if (stmp.length() == 1)
			{
				// 如果是0至F的单位字符串，则添加0
				out = out + "0" + stmp;
			} else
			{
				out = out + stmp;
			}
		}
		return out;
	}

	/**
	 * <li>方法名称:addMD5</li>
	 * <li>功能描述:
	 * <pre>MD校验码 组合方法，前16位放MD5Hash码。 把MD5验证码byte[]，加密内容byte[]组合的方法。</pre>
	 * </li>
	 * @param md5Byte 加密内容的MD5Hash字节数组。
	 * @param bodyByte 加密内容字节数组
	 * @return 组合后的字节数组，比加密内容长16个字节。
	 */
	public static byte[] addMD5(byte[] md5Byte, byte[] bodyByte)
	{
		int length = bodyByte.length + md5Byte.length;
		byte[] resutlByte = new byte[length];

		// 前16位放MD5Hash码
		for (int i = 0; i < length; i++)
		{
			if (i < md5Byte.length)
			{
				resutlByte[i] = md5Byte[i];
			} else
			{
				resutlByte[i] = bodyByte[i - md5Byte.length];
			}
		}

		return resutlByte;
	}

	/**
	 * <li>方法名称:getKeyIV</li>
	 * <li>功能描述:
	 * @param encryptKey
	 * @param key
	 * @param iv
	 */
	public static void getKeyIV(String encryptKey, byte[] key, byte[] iv)
	{
		// 密钥Base64解密
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] buf = null;
		try
		{
			buf = decoder.decodeBuffer(encryptKey);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		// 前8位为key
		int i;
		for (i = 0; i < key.length; i++)
		{
			key[i] = buf[i];
		}
		// 后8位为iv向量
		for (i = 0; i < iv.length; i++)
		{
			iv[i] = buf[i + 8];
		}
	}
	
	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
	 
	/**
	 * 使用 HMAC-SHA1 签名方法对data进行签名
	 * 
	 * @param data
	 *            被签名的字符串
	 * @param key
	 *            密钥     
	 * @return 
                      加密后的字符串
	 */
	public static String genHMAC(String data, String key) {
		byte[] result = null;
		try {
			//根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称  
			SecretKeySpec signinKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
			//生成一个指定 Mac 算法 的 Mac 对象  
			Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
			//用给定密钥初始化 Mac 对象  
			mac.init(signinKey);
			//完成 Mac 操作   
			byte[] rawHmac = mac.doFinal(data.getBytes());
			result = Base64.encodeBase64(rawHmac);
 
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
			log.error("HMAC encript error -- ", e);
		}
		if (null != result) {
			return new String(result);
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		//{“name”: “张三”, “idcard_type”: 0, “idcard_number”: “123456789123456789”, “time”:“1532748538”}
		//64d2a6275f0c3a9675e1a8076a14410eda4926a6
		String msg = "idcard_type=0&idcard_number=123456789123456789&name=张三&time=1532748538";
		String msg1 = "idcard_number=123456789123456789&idcard_type=0&name=张三&time=1532748538";
		System.out.println(genHMAC(msg1, "123456"));
	
	}

}