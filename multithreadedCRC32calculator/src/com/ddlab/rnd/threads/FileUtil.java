package com.ddlab.rnd.threads;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.CRC32;

public class FileUtil 
{
	public static byte[] getFileBytes( File file )
	{
		byte[] fileBuff = new byte[(int)file.length()];
		InputStream inStream = null;
		Lock lock = new ReentrantLock(); 
		try 
		{
			lock.lock();
			inStream = new FileInputStream(file);
			inStream.read(fileBuff);
		}
		catch (FileNotFoundException fnfe) 
		{
			fnfe.printStackTrace();
		}
		catch( IOException ie )
		{
			ie.printStackTrace();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			lock.unlock();
			try 
			{
				if( inStream != null ) inStream.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		return fileBuff;
	}
	
	public static long getCRC32CheckSum( byte[] buff )
	{
		long crc32CheckSumValue = 0;
		try 
		{
			CRC32 crc = new CRC32();
			crc.update(buff);
			crc32CheckSumValue = crc.getValue();
		}
		catch (Exception e) 
		{
			System.out.println("Exception in CRC32 Checksum computation...");
			e.printStackTrace();
		}
		return crc32CheckSumValue;
	}
	
	public static String getChecksum( File file )
	{
		return Long.toHexString( getCRC32CheckSum(getFileBytes(file)) );
	}

//	public static void main(String[] args) 
//	{
//		String svnPath = "C:/SVN/OPEsrc/opeserver/build.xml";
//		String cvsPath = "C:/CVS1/OPEsrc/opeserver/build.xml";
//		
//		byte[] fileBuff = FileUtil.getFileBytes( new File(cvsPath));
//		long checkSumValue = FileUtil.getCRC32CheckSum(fileBuff);
//		System.out.println("CVS---->"+Long.toHexString(checkSumValue));
//		
//		fileBuff = FileUtil.getFileBytes( new File(svnPath));
//		checkSumValue = FileUtil.getCRC32CheckSum(fileBuff);
//		System.out.println("SVN---->"+Long.toHexString(checkSumValue));
//	}

}
