package time;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class testTime {

		public static void main(String[] args) throws Exception {
			
			Date beginTime = convertStringToDate("16:30:30", "HH:mm:ss");
			
			Calendar cal = Calendar.getInstance();

			cal.clear();
			cal.setTime(new Timestamp(System.currentTimeMillis())); // Ϊ�˻�õ�ǰ��¼��������Ϣ

			Calendar calTemp = Calendar.getInstance();

			calTemp.clear();

			calTemp.setTime(beginTime); // Ϊ�˻��ָ���ĵ�¼�޶�ʱ���е�ʱ������Ϣ

			cal.set(Calendar.HOUR_OF_DAY, calTemp.get(Calendar.HOUR_OF_DAY));
			cal.set(Calendar.MINUTE, calTemp.get(Calendar.MINUTE));
			cal.set(Calendar.SECOND, calTemp.get(Calendar.SECOND));

			System.out.println("��ǰ��¼����ʱ����(start)��" + cal.getTime());
			
			
			
			
			
		}
		public static java.util.Date convertStringToDate(String date, String format)
		throws Exception
		{
			return convertStringToDate(date, format, null);
		}
		public static java.util.Date convertStringToDate(String date,
				String format, Locale locale) throws Exception
		{
			if (date == null)
				throw new Exception("offer date String is null.");
			if (format == null || "".equals(format))
				throw new Exception("offer format is null.");

			SimpleDateFormat dateFormat = null;

			if (locale == null)
			{
				dateFormat = new SimpleDateFormat(format);
			}
			else
			{
				dateFormat = new SimpleDateFormat(format, locale);
			}

			//�������Ķ����������ֵ
			java.util.Date dt = dateFormat.parse(date);
			return new java.sql.Timestamp(dt.getTime());
		}

}
