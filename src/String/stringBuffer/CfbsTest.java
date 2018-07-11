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
		 * ���ʽ�����Ϣ��MAC����������
		 */
		txnEncSample();
		
		/*
		 * ���ʽ�����Ϣ���ܡ�У��MAC����
		 */
		txnDecSample();
		
		/*
		 * �����ļ���MAC����������
		 */
		fileEncSample();
		
		/*
		 * �����ļ����ܡ�У��MAC����
		 */
		fileDecSample();
	}
	
	/**
	 * ������ʾʵʱ������Ϣ��MAC���������̡�
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
			 * 1������ԭʼ���ױ���(���湹������δ����ǰ�����ͨѶͷ)
			 */
			strInMsg = "1003011202000000000000000320080601000000001234567890        231255297                                                              201581000018            44001400102050031709               ����                                                        007000158102312552970070020144001400102050031709                 CNY000000000000100000000000000000����                                                        0000000000000000        000000000CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC";
			intInLength = strInMsg.getBytes("GBK").length;
			
			
			/*
			 * 2������MAC����������Ϣ��MACУ��λ
			 */
			CfbsAPI cfbsAPIMac = new CfbsAPI(true);
			cfbsAPIMac.setStrMsg(strInMsg);
			cfbsAPIMac.setLngLength((long)intInLength);
			cfbsAPIMac.ORG_MAC();
			
			if(!cfbsAPIMac.getStrRetcd().equals("000"))
			{
				//����MACʧ�ܣ������ڲ����� ...
				
				return;
			}
			
			//������Ϣ��MACУ��λ
			strInMsg = strInMsg.substring(0, strInMsg.length()-64) + cfbsAPIMac.getStrMac();
			
			
			/*
			 * 3�����ܣ���������Ϣ����
			 */
			CfbsAPI cfbsAPITxnEnc = new CfbsAPI(true);
			cfbsAPITxnEnc.setStrKey("123456");
			cfbsAPITxnEnc.setIntAction(0);
			cfbsAPITxnEnc.setStrInMsg(strInMsg);
			cfbsAPITxnEnc.setLngInLength((long)intInLength);
			cfbsAPITxnEnc.ORG_TXN_CRYPT();
			
			if(!cfbsAPITxnEnc.getStrRetcd().equals("000"))
			{
				//������Ϣ��ʧ�ܣ������ڲ����� ...
				
				return;
			}
			
			//���ܺ�������Ϣ����
			intOutLength = (int)cfbsAPITxnEnc.getLngOutLength() + 9; //���Ȱ���ͨѶͷ
			
			DecimalFormat df = new DecimalFormat("00000000");
			strOutMsg	= "C"
						+ df.format(intOutLength) 
						+ cfbsAPITxnEnc.getStrOutMsg();
			
			System.out.println("INFO: ["+intOutLength+"]["+strOutMsg+"]");
			
			
			/*
			 * 4��ͨ��socket/�м�����������ո�����
			 */
			//����ǰ���� 0xef0x14+ͨѶͷ+��Ϣ��+У���� ...
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * ������ʾʵʱ������Ϣ���ܡ�У��MAC���̡�
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
			 * 1��ͨ��socket/�м���Ӵ��ո����Ļ�ȡ����Ϣ(��������δ����ǰ�����ͨѶͷ)
			 */
			strInMsg = "0272F1A344FD7E6E35E057F9B3D75D6E3489073EFA10FC2AFE09D1CD26765CAFD851EB3D41AB44579A088CF112D9CB216458F4EFCB6D46D4405A2B04E2F36D8116710B32B5DC1B27150ABE7C06005FA44081DD89B64C4FC2F89E7F633FA6BE5B174980B96DD894E6398A54ECD22655124CA63ADDCF16E8AB8CFE8BC95DC7949629F812569E0F116FFB76094DFE9F629FCB31C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF45416C5D0EC4EF46911188F27C420876604C8D53E8FDB5FF454B217501FC8BECC9606D6078D4F512A24CAA79665CAF69AA7C8D53E8FDB5FF4543DDF55CE6603E6FCF94BA0363A6742F0C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF45423B74A0260DDF1D87AAF9149F2D5B7732E99FF12ED85BBFE5662003129F1A0BB5A9DACA51F2E8FB080DDF863DEFF93CEBE7F8CFFD87B5802C8D53E8FDB5FF4542787D5A8DE281C8C5262499944C29255BCC30E3E440F2B5E5262499944C292557F95A797B1BEBB71C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF454C8D53E8FDB5FF4545262499944C292555262499944C29255C8D53E8FDB5FF4545262499944C29255F5E64D21FE812BF7B573100ACE9B63FAE7EBBCAC6F85068194B7C3A7EAE2DC271307387FCF5956AC471D434015460643338E82C0C207138F18D65BD547C8C453DB78040BB5B79C53";
			intInLength = strInMsg.getBytes("GBK").length;
			
			
			/*
			 * 2������
			 */
			CfbsAPI cfbsAPITxnDec = new CfbsAPI(true);
			cfbsAPITxnDec.setStrKey("123456");
			cfbsAPITxnDec.setIntAction(1);
			cfbsAPITxnDec.setStrInMsg(strInMsg);
			cfbsAPITxnDec.setLngInLength(intInLength);
			cfbsAPITxnDec.ORG_TXN_CRYPT();
			
			if(!cfbsAPITxnDec.getStrRetcd().equals("000"))
			{
				//������Ϣ��ʧ�ܣ������ڲ����� ...
				
				return;
			}
			
			
			/*
			**	3������MAC����У��MAC
			*/
			CfbsAPI cfbsAPIMac = new CfbsAPI(true);
			cfbsAPIMac.setStrMsg(cfbsAPITxnDec.getStrOutMsg());
			cfbsAPIMac.setLngLength(cfbsAPITxnDec.getLngOutLength());
			cfbsAPIMac.ORG_MAC();
			
			if(!cfbsAPIMac.getStrRetcd().equals("000"))
			{
				//����MACʧ�ܣ������ڲ����� ...
				
				return;
			}
			
			//������Ϣ��MACУ��λ
			if(!cfbsAPITxnDec.getStrOutMsg()
					.substring(cfbsAPITxnDec.getStrOutMsg().length()-64)
						.equals(cfbsAPIMac.getStrMac()))
			{
				//MACУ��ʧ�ܣ������ڲ����� ...
				
				return;
			}
			
			
			/*
			 * 4��MACУ��ɹ������ĺϷ�����ҵ�����ڲ�ҵ���߼�����
			 */
			//�ڲ�ҵ���߼��������̣������ⱨ�ģ��Ǽ����ݿ�� ...
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * ������ʾ�����ļ���MAC���������̡�
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
			 * 1�����콻���ļ�
			 */
			strInFn = "F:\\test\\TXNTYP1202105301231255297200807080000000100001297";
			strTmpFn = strInFn.substring(0, strInFn.length()-8)+"00000000";
			
			
			/*
			 * 2��ѭ����ȡ�ļ�����MAC����
			 */
			//���ԭʼ�ļ�
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
			
			//������ʱ�ļ�
			File fTmpFile = new File(strTmpFn);
			
			if(fTmpFile.exists())
			{
				fTmpFile.delete();
			}
			
			fTmpFile.createNewFile();
			
			//ѭ����ȡ�ļ�
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
					//����MACʧ�ܣ��ر��ļ��������ڲ����� ...
					psTmpFile.close();
					osTmpFile.close();
					brInFile.close();
					isInFile.close();
					fTmpFile.delete();
					
					return;
				}
				
				//MAC��ȷ���ɣ�д����ʱ�ļ�
				intLength = strLine.length();
				psTmpFile.print(strLine.substring(0, intLength-64)
						+cfbsAPIMac.getStrMac());
				psTmpFile.print(chrLineEnd);
				
				//����һ��
				strLine = brInFile.readLine();
			}
			
			//�ر��ļ�
			psTmpFile.close();
			osTmpFile.close();
			brInFile.close();
			isInFile.close();
			
			
			/*
			 * 3���ļ����ܼ�ѹ
			 */
			CfbsAPI cfbsAPIFileEnc = new CfbsAPI(true);
			cfbsAPIFileEnc.setStrKey("123456");
			cfbsAPIFileEnc.setIntAction(0);
			cfbsAPIFileEnc.setStrInFilename(strTmpFn);
			cfbsAPIFileEnc.ORG_FILE_CRYPT();
			
			if(!cfbsAPIFileEnc.getStrRetcd().equals("000"))
			{
				//�ļ����ܼ�ѹʧ�ܣ������ڲ����� ...
				fTmpFile.delete();
				
				return;
			}
			
			//ɾ����ʱ�ļ�
			fTmpFile.delete();
			
			
			/*
			 * 4�������ļ������ո�����
			 */
			//�������� ...
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * ������ʾ�����ļ����ܡ�У��MAC���̡�
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
			 * 1�����콻���ļ�
			 */
			strFilePath = "F:\\test\\";
			strInFn = "F:\\test\\TXNTYP1212105301231255297200807080000001100001092";
			
			
			/*
			 * 2���ļ���ѹ����
			 */
			CfbsAPI cfbsAPIFileDec = new CfbsAPI(true);
			cfbsAPIFileDec.setStrKey("123456");
			cfbsAPIFileDec.setIntAction(1);
			cfbsAPIFileDec.setStrInFilename(strInFn);
			cfbsAPIFileDec.ORG_FILE_CRYPT();
			
			if(!cfbsAPIFileDec.getStrRetcd().equals("000"))
			{
				//�ļ���ѹ����ʧ�ܣ������ڲ����� ...
				
				return;
			}
			
			
			/*
			 * 3��ѭ����ȡ�ļ���У��MAC
			 */
			InputStream isInFile = new FileInputStream(strFilePath+cfbsAPIFileDec.getStrOutFilename());
			BufferedReader brInFile = new BufferedReader(new InputStreamReader(isInFile,"GBK"));
			
			strLine = brInFile.readLine();
			
			while(strLine != null)
			{
				//����MAC
				CfbsAPI cfbsAPIMac = new CfbsAPI(true);
				cfbsAPIMac.setStrMsg(strLine);
				cfbsAPIMac.setLngLength((long)strLine.getBytes("GBK").length);
				cfbsAPIMac.ORG_MAC();
				
				if(!cfbsAPIMac.getStrRetcd().equals("000"))
				{
					//����MACʧ�ܣ��ر��ļ��������ڲ����� ...
					brInFile.close();
					isInFile.close();
					
					return;
				}
				
				//У��MAC
				if(!strLine.substring(strLine.length()-64)
							.equals(cfbsAPIMac.getStrMac()))
				{
					//MACУ��ʧ�ܣ������ڲ����� ...
					brInFile.close();
					isInFile.close();
					
					return;
				}
				
				//����һ��
				strLine = brInFile.readLine();
			}
			
			//�ر��ļ�
			brInFile.close();
			isInFile.close();
			
			/*
			 * 4��MACУ��ɹ����ļ��Ϸ�����ҵ�����ڲ�ҵ���߼�����
			 */
			//�ڲ�ҵ���߼��������� ...
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
