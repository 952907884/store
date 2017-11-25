package cn.wang.store.util;

import java.io.*;


public class FileIoUtil {
	

	
	/**
	 * ��ȡ������ļ�
	 * @param path	�ļ�·��
	 * @return	��ȡ�ļ��������ַ���
	 * @throws IOException
	 */
	public static String readFile(String path){
		StringBuffer sb=new StringBuffer();
		File file=new File(path);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String c= null ;
			while((c=reader.readLine())!=null){
				sb.append(c);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
	
	
	public static void writer(String path,String content){
		File file = new File(path);
		BufferedWriter writer=null;
		try {
			writer=new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
