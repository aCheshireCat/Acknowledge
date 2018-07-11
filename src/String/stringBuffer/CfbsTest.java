package String.stringBuffer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;

import talent.CfbsAPI;

/********************************************************************
**
** (C) Copyright Talent Information Solutions Ltd. 2008.06.16
**
** File name:	CfbsTest.java
** Project:		CFBS
**
** Aim:		Sample source in using security API.
**
** Function List:
**			main()
**
**			(static)
**			txnEncSample()
**			txnDencSample()
**			fileEncSample()
**			fileDecSample()
**
** Creation Date:	2008.06.16
** Origin Author:	Chen Yida
**
** Version:	%I%
**
** Modification History
**
** Reference	Date		Modified By	Reason
** ---------	----		-----------	------
**
********************************************************************/

public class CfbsTest {
	
	public static void main( String args[])
	{
		/*
		 * 单笔交易信息加MAC、加密流程
		 */
		txnEncSample();
		
		/*
		 * 单笔交易信息解密、校验MAC流程
		 */
		txnDecSample();
		
		/*
		 * 交易文件加MAC、加密流程
		 */
		fileEncSample();
		
		/*
		 * 交易文件解密、校验MAC流程
		 */
		fileDecSample();
	}
	
	/**
	 * 函数演示实时交易信息加MAC、加密流程。
	 * 
	 * @return void
	 */
	public static void txnEncSample()
	{
		/*
		**	----------------------------------------------------
		**	Variables Definitions
		**	----------------------------------------------------
		*/
		String strInMsg = null;
		String strOutMsg = null;
		int	intInLength = 0;
		int intOutLength = 0;
		
		/*
		**	----------------------------------------------------
		**	Process
		**	----------------------------------------------------
		*/
		try
		{
			/*
			 * 1、构造原始交易报文(下面构造例程未包括前导码和通讯头)
			 */
			strInMsg = "1003011202000000000000000320080601000000001234567890        231255297                                                              201581000018            44001400102050031709               关羽                                                        007000158102312552970070020144001400102050031709                 CNY000000000000100000000000000000附言                                                        0000000000000000        000000000CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC";
			intInLength = strInMsg.getBytes("GBK").length;
			
			
			/*
			 * 2、生成MAC，并附在信息串MAC校验位
			 */
			CfbsAPI cfbsAPIMac = new CfbsAPI(true);
			cfbsAPIMac.setStrMsg(strInMsg);
			cfbsAPIMac.setLngLength((long)intInLength);
			cfbsAPIMac.ORG_MAC();
			
			if(!cfbsAPIMac.getStrRetcd().equals("000"))
			{
				//生成MAC失败，进行内部处理 ...
				
				return;
			}
			
			//重置信息串MAC校验位
			strInMsg = strInMsg.substring(0, strInMsg.length()-64) + cfbsAPIMac.getStrMac();
			
			
			/*
			 * 3、加密，并重置信息长度
			 */
			CfbsAPI cfbsAPITxnEnc = new CfbsAPI(true);
			cfbsAPITxnEnc.setStrKey("123456");
			cfbsAPITxnEnc.setIntAction(0);
			cfbsAPITxnEnc.setStrInMsg(strInMsg);
			cfbsAPITxnEnc.setLngInLength((long)intInLength);
			cfbsAPITxnEnc.ORG_TXN_CRYPT();
			
			if(!cfbsAPITxnEnc.getStrRetcd().equals("000"))
			{
				//加密信息串失败，进行内部处理 ...
				
				return;
			}
			
			//加密后，重置信息长度
			intOutLength = (int)cfbsAPITxnEnc.getLngOutLength() + 9; //长度包括通讯头
			
			DecimalFormat df = new DecimalFormat("00000000");
			strOutMsg	= "C"
						+ df.format(intOutLength) 
						+ cfbsAPITxnEnc.getStrOutMsg();
			
			System.out.println("INFO: ["+intOutLength+"]["+strOutMsg+"]");
			
			
			/*
			 * 4、通过socket/中间件发送至代收付中心
			 */
			//发送前导码 0xef0x14+通讯头+信息体+校验码 ...
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 函数演示实时交易信息解密、校验MAC流程。
	 * 
	 * @return void
	 */
	public static void txnDecSample()
	{
		/*
		**	----------------------------------------------------
		**	Variables Definitions
		**	----------------------------------------------------
		*/
		String strInMsg = null;
		int	intInLength = 0;
		
		/*
		**	----------------------------------------------------
		**	Process
		**	----------------------------------------------------
		*/
		try
		{
			/*
			 * 1、通过socket/中间件从代收付中心获取到信息(下面例程未包括前导码和通讯头)
			 */
			strInMsg = "0272F1A344FD7E6E35E057F9B3D75D6E3489073EFA10FC2AFE09D1CD26765CAFD851EB3D41AB44579A088CF112D9CB216458F4EFCB6D46D4405A2B04E2F36D8116710B32B5DC1B27150ABE7C06005FA44081DD89B64C4FC2F89E7F633FA6BE5B174980B96DD894E6398A54ECD22655124CA63ADDCF16E8AB8CFE8BC95DC7949629F812569E0F116FFB76094DFE9F629FCB31C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF45416C5D0EC4EF46911188F27C420876604C8D53E8FDB5FF454B217501FC8BECC9606D6078D4F512A24CAA79665CAF69AA7C8D53E8FDB5FF4543DDF55CE6603E6FCF94BA0363A6742F0C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF45423B74A0260DDF1D87AAF9149F2D5B7732E99FF12ED85BBFE5662003129F1A0BB5A9DACA51F2E8FB080DDF863DEFF93CEBE7F8CFFD87B5802C8D53E8FDB5FF4542787D5A8DE281C8C5262499944C29255BCC30E3E440F2B5E5262499944C292557F95A797B1BEBB71C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF4545262499944C292555262499944C29255C8D53E8FDB5FF4545262499944C29255F5E64D21FE812BF7B573100ACE9B63FAE7EBBCAC6F85068194B7C3A7EAE2DC271307387FCF5956AC471D434015460643338E82C0C207138F18D65BD547C8C453DB78040BB5B79C53";
			intInLength = strInMsg.getBytes("GBK").length;
			
			
			/*
			 * 2、解密
			 */
			CfbsAPI cfbsAPITxnDec = new CfbsAPI(true);
			cfbsAPITxnDec.setStrKey("123456");
			cfbsAPITxnDec.setIntAction(1);
			cfbsAPITxnDec.setStrInMsg(strInMsg);
			cfbsAPITxnDec.setLngInLength(intInLength);
			cfbsAPITxnDec.ORG_TXN_CRYPT();
			
			if(!cfbsAPITxnDec.getStrRetcd().equals("000"))
			{
				//解密信息串失败，进行内部处理 ...
				
				return;
			}
			
			
			/*
			**	3、生成MAC，并校验MAC
			*/
			CfbsAPI cfbsAPIMac = new CfbsAPI(true);
			cfbsAPIMac.setStrMsg(cfbsAPITxnDec.getStrOutMsg());
			cfbsAPIMac.setLngLength(cfbsAPITxnDec.getLngOutLength());
			cfbsAPIMac.ORG_MAC();
			
			if(!cfbsAPIMac.getStrRetcd().equals("000"))
			{
				//生成MAC失败，进行内部处理 ...
				
				return;
			}
			
			//重置信息串MAC校验位
			if(!cfbsAPITxnDec.getStrOutMsg()
					.substring(cfbsAPITxnDec.getStrOutMsg().length()-64)
						.equals(cfbsAPIMac.getStrMac()))
			{
				//MAC校验失败，进行内部处理 ...
				
				return;
			}
			
			
			/*
			 * 4、MAC校验成功，报文合法，企业进行内部业务逻辑处理
			 */
			//内部业务逻辑处理流程，例如拆解报文，登记数据库等 ...
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 函数演示交易文件加MAC、加密流程。
	 * 
	 * @return void
	 */
	public static void fileEncSample()
	{
		/*
		**	----------------------------------------------------
		**	Variables Definitions
		**	----------------------------------------------------
		*/
		String strInFn = null;
		String strTmpFn = null;
		String strLine = null;
		int intLength = 0;
		
		char[] chrLineEnd = new char[2];
		chrLineEnd[0] = 0x0d;
		chrLineEnd[1] = 0x0a;
		
		/*
		**	----------------------------------------------------
		**	Process
		**	----------------------------------------------------
		*/
		try
		{
			/*
			 * 1、构造交易文件
			 */
			strInFn = "F:\\test\\TXNTYP1202105301231255297200807080000000100001297";
			strTmpFn = strInFn.substring(0, strInFn.length()-8)+"00000000";
			
			
			/*
			 * 2、循环读取文件，加MAC处理
			 */
			//检查原始文件
			File fInFile = new File(strInFn);
			
			if(!fInFile.exists())
			{
				System.out.println("ERROR: file [" + strInFn + "] not exist!");
				return;
			}
			
			if(fInFile.length() == 0)
			{
				System.out.println("ERROR: file [" + strInFn + "] is empty!");
				return;
			}
			
			//生成临时文件
			File fTmpFile = new File(strTmpFn);
			
			if(fTmpFile.exists())
			{
				fTmpFile.delete();
			}
			
			fTmpFile.createNewFile();
			
			//循环读取文件
			InputStream isInFile = new FileInputStream(strInFn);
			BufferedReader brInFile = new BufferedReader(new InputStreamReader(isInFile,"GBK"));
			
			OutputStream osTmpFile = new FileOutputStream(fTmpFile.getAbsolutePath());
			PrintStream psTmpFile = new PrintStream(osTmpFile);
			
			strLine = brInFile.readLine();
			
			while(strLine != null)
			{
				CfbsAPI cfbsAPIMac = new CfbsAPI(true);
				cfbsAPIMac.setStrMsg(strLine);
				cfbsAPIMac.setLngLength((long)strLine.getBytes("GBK").length);
				cfbsAPIMac.ORG_MAC();
				
				if(!cfbsAPIMac.getStrRetcd().equals("000"))
				{
					//生成MAC失败，关闭文件，进行内部处理 ...
					psTmpFile.close();
					osTmpFile.close();
					brInFile.close();
					isInFile.close();
					fTmpFile.delete();
					
					return;
				}
				
				//MAC正确生成，写入临时文件
				intLength = strLine.length();
				psTmpFile.print(strLine.substring(0, intLength-64)
						+cfbsAPIMac.getStrMac());
				psTmpFile.print(chrLineEnd);
				
				//读下一行
				strLine = brInFile.readLine();
			}
			
			//关闭文件
			psTmpFile.close();
			osTmpFile.close();
			brInFile.close();
			isInFile.close();
			
			
			/*
			 * 3、文件加密加压
			 */
			CfbsAPI cfbsAPIFileEnc = new CfbsAPI(true);
			cfbsAPIFileEnc.setStrKey("123456");
			cfbsAPIFileEnc.setIntAction(0);
			cfbsAPIFileEnc.setStrInFilename(strTmpFn);
			cfbsAPIFileEnc.ORG_FILE_CRYPT();
			
			if(!cfbsAPIFileEnc.getStrRetcd().equals("000"))
			{
				//文件加密加压失败，进行内部处理 ...
				fTmpFile.delete();
				
				return;
			}
			
			//删除临时文件
			fTmpFile.delete();
			
			
			/*
			 * 4、发送文件至代收付中心
			 */
			//发送流程 ...
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 函数演示交易文件解密、校验MAC流程。
	 * 
	 * @return void
	 */
	public static void fileDecSample()
	{
		/*
		**	----------------------------------------------------
		**	Variables Definitions
		**	----------------------------------------------------
		*/
		String strInFn = null;
		String strFilePath = null;
		String strLine = null;
		
		/*
		**	----------------------------------------------------
		**	Process
		**	----------------------------------------------------
		*/
		try
		{
			/*
			 * 1、构造交易文件
			 */
			strFilePath = "F:\\test\\";
			strInFn = "F:\\test\\TXNTYP1212105301231255297200807080000001100001092";
			
			
			/*
			 * 2、文件解压解密
			 */
			CfbsAPI cfbsAPIFileDec = new CfbsAPI(true);
			cfbsAPIFileDec.setStrKey("123456");
			cfbsAPIFileDec.setIntAction(1);
			cfbsAPIFileDec.setStrInFilename(strInFn);
			cfbsAPIFileDec.ORG_FILE_CRYPT();
			
			if(!cfbsAPIFileDec.getStrRetcd().equals("000"))
			{
				//文件解压解密失败，进行内部处理 ...
				
				return;
			}
			
			
			/*
			 * 3、循环读取文件，校验MAC
			 */
			InputStream isInFile = new FileInputStream(strFilePath+cfbsAPIFileDec.getStrOutFilename());
			BufferedReader brInFile = new BufferedReader(new InputStreamReader(isInFile,"GBK"));
			
			strLine = brInFile.readLine();
			
			while(strLine != null)
			{
				//生成MAC
				CfbsAPI cfbsAPIMac = new CfbsAPI(true);
				cfbsAPIMac.setStrMsg(strLine);
				cfbsAPIMac.setLngLength((long)strLine.getBytes("GBK").length);
				cfbsAPIMac.ORG_MAC();
				
				if(!cfbsAPIMac.getStrRetcd().equals("000"))
				{
					//生成MAC失败，关闭文件，进行内部处理 ...
					brInFile.close();
					isInFile.close();
					
					return;
				}
				
				//校验MAC
				if(!strLine.substring(strLine.length()-64)
							.equals(cfbsAPIMac.getStrMac()))
				{
					//MAC校验失败，进行内部处理 ...
					brInFile.close();
					isInFile.close();
					
					return;
				}
				
				//读下一行
				strLine = brInFile.readLine();
			}
			
			//关闭文件
			brInFile.close();
			isInFile.close();
			
			/*
			 * 4、MAC校验成功，文件合法，企业进行内部业务逻辑处理
			 */
			//内部业务逻辑处理流程 ...
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
