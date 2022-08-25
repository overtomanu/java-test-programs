
import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class QueryOutputToFile
{
	public static final Charset								UTF16						= Charset.forName("UTF-16");
	
	public static boolean queryOutputTofile(Connection con, String query, Writer fileWriter)
	{
		if (con != null)
		{
			
			Statement statement = null;
			ResultSet rs = null;
			try
			{
				String Query = query;
				statement = con.createStatement();
				rs = statement.executeQuery(Query);
				ResultSetMetaData resultSetMetaData = rs.getMetaData();
				int colCount = resultSetMetaData.getColumnCount();
				Map<String, Integer> colInfo = new LinkedHashMap<String, Integer>();
				for (int i = 0; i < colCount; i++)
				{
					colInfo.put(resultSetMetaData.getColumnName(i + 1).toUpperCase(), resultSetMetaData.getColumnType(i + 1));
				}
				//return colInfo;
				
				
				// write column names first
				StringBuffer line = new StringBuffer();
				
				for (Map.Entry<String, Integer> entry : colInfo.entrySet())
				{
					line.append("\"" + entry.getKey().trim() + "\",");
				}
				writeLine(fileWriter, line);
				// write table data
				List<String> columns = new ArrayList<String>(colInfo.keySet());
				
				while (rs.next())
				{
					line = new StringBuffer();
					for (int i = 1; i <= colInfo.size(); i++)
					{
						switch (colInfo.get(columns.get(i - 1)))
						{
							case java.sql.Types.INTEGER:
							case java.sql.Types.NUMERIC:
							case java.sql.Types.BIGINT:
							case java.sql.Types.DECIMAL:
							case java.sql.Types.DOUBLE:
							case java.sql.Types.FLOAT:
							case java.sql.Types.TINYINT:
							case java.sql.Types.SMALLINT:
							case java.sql.Types.BIT:
							case java.sql.Types.BOOLEAN:
								String s = rs.getString(i);
								if (s != null && s.length() > 0)
									line.append("\"" + s + "\",");
								else
									line.append(",");
								break;

							case java.sql.Types.DATE:
								Date date = rs.getDate(i);
								if (date != null)
								{
									line.append("\"" + date.getTime() + "\",");
								}
								else
									line.append(",");
								break;

							case java.sql.Types.TIMESTAMP:
								Timestamp ts = rs.getTimestamp(i);
								if (ts != null)
									line.append("\"" + ts.getTime() + "\",");
								else
									line.append(",");
								break;

							case java.sql.Types.TIME:
								Time t = rs.getTime(i);
								if (t != null)
									line.append("\"" + t.getTime() + "\",");
								else
									line.append(",");
								break;

							case java.sql.Types.BINARY:
								byte[] ba = rs.getBytes(i);
								if (ba != null)
								{
									line.append("\"" + StringUtil.encodeForCSVStorage(new String(ba,UTF16)) + "\",");
								}
								else
									line.append(",");
								break;

							case java.sql.Types.VARBINARY:
								byte[] vba = rs.getBytes(i);
								if (vba != null)
								{
									line.append("\"" + StringUtil.encodeForCSVStorage(new String(vba,UTF16)) + "\",");
								}
								else
									line.append(",");
								break;

							case java.sql.Types.LONGVARBINARY:
								InputStream is = rs.getBinaryStream(i);
								if (is != null)
								{
									Reader streamReader = new InputStreamReader(is, UTF16);
									line.append("\"" + StringUtil.encodeForCSVStorage(IOUtil.readerToString(streamReader)) + "\",");
								}
								else
								{
									line.append(",");
								}
								break;

							case java.sql.Types.BLOB:
								Blob blob = rs.getBlob(i);

								if (blob != null)
								{
									try
									{
										
										InputStream blobIs = blob.getBinaryStream();
										Reader streamReader = new InputStreamReader(blobIs, UTF16);
										line.append("\"" + StringUtil.encodeForCSVStorage(IOUtil.readerToString(streamReader)) + "\",");
									}
									finally
									{
										// blob.free();
										System.gc();
									}
								}
								else
								{
									line.append(",");
								}

								break;

							case java.sql.Types.LONGVARCHAR:
								Reader cs = rs.getCharacterStream(i);
								if (cs != null)
								{
									
									line.append("\"" + StringUtil.encodeForCSVStorage(IOUtil.readerToString(cs)) + "\",");
								}
								else
								{
									line.append(",");
								}
								break;

							case java.sql.Types.CLOB:
								Clob clob = rs.getClob(i);
								try
								{
									if (clob != null)
									{
										
										Reader clobIs = clob.getCharacterStream();
										
										line.append("\"" + StringUtil.encodeForCSVStorage(IOUtil.readerToString(clobIs)) + "\",");
									}
									else
									{
										line.append(",");
									}
								}
								finally
								{
									// clob.free();
									System.gc();
								}
								break;

							case java.sql.Types.CHAR:
							case java.sql.Types.VARCHAR:
							case java.sql.Types.OTHER:
							default:
								String ds = rs.getString(i);
								if (ds != null && ds.length() > 0)
									line.append("\"" + StringUtil.encodeForCSVStorage(rs.getString(i)) + "\",");
								else
									line.append(",");
								break;
						}
					}
					writeLine(fileWriter, line);
				}
				
				return true;
			}
			catch (SQLException e)
			{
				
			}
			catch (IOException e)
			{
				
			}
			finally
			{
				try
				{
					if (fileWriter != null)
						fileWriter.close();
				}
				catch (IOException e)
				{
					
				}
			}
		}
		return false;
	}
	
	private static void writeLine(Writer bw, StringBuffer line) throws IOException
	{
		if (line.charAt(line.length() - 1) == ',')
			line.deleteCharAt(line.length() - 1);
		bw.write(line.toString()+"\n");;
		bw.flush();
	}
	
	public static void main(String[] args)
	{
		Connection con = null;
		String user="fusion";
		String password="fusion";
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@slcak361.us.oracle.com:1614:slc07daf";
		
		String query="select * from FUSION.pjf_open_xface_report " + 
				"where request_id=" + 
				"(" + 
				"  select request_id from" + 
				"  (" + 
				"      " + 
				"      select request_id,rownum rno from" + 
				"      (" + 
				"          select distinct request_id ," + 
				"                (select min(creation_date) from FUSION.pjf_open_xface_report inner1 where inner1.request_id=outer1.request_id) date1" + 
				"          from FUSION.pjf_open_xface_report outer1" + 
				"          order by date1 desc" + 
				"      )" + 
				"  ) subtab where subtab.rno=1" + 
				")" + 
				"order by creation_date desc";
		
		try
		{
			Class.forName(driver).newInstance();
			if (user == null || user.trim().length() == 0)
				con = DriverManager.getConnection(url);
			else
				con = DriverManager.getConnection(url, user, password);
			//log.info("Connected to the database " + url);
			
			
			queryOutputTofile(con, query, new FileWriter("result.csv"));
			System.out.println("Writing query result to file completed");
		}
		catch (InstantiationException e)
		{
			
		}
		catch (IllegalAccessException e)
		{
			
		}
		catch (ClassNotFoundException e)
		{
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			
		}
	}
}

class StringUtil
{
	public static String encodeForCSVStorage(String string)
	{
		String encodedString = string.replaceAll("\r\n", "#LINEFEED_NEWLINE#")
										.replaceAll("\n", "#NEWLINE#")
										.replaceAll("\r", "#LINEFEED#")
										.replaceAll("\"", "\"\"");
		return encodedString;
	}
}

class IOUtil
{
	public static String readerToString(Reader reader) throws IOException
	{
		CharArrayWriter cw = new CharArrayWriter();
		try
		{
			long freespace = Runtime.getRuntime().freeMemory() * 1 / 10;
			//java chars occupy 2 byte
			int buffersize = freespace > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) freespace / 2;
			int offset = 0;
			int numRead = 0;
			char[] chars = new char[buffersize];
			while ((numRead = reader.read(chars, offset, chars.length - offset)) >= 0)
			{
				offset += numRead;

				if (offset >= buffersize)
				{
					cw.write(chars);
					chars = new char[buffersize];
					offset = 0;
				}
			}
			if (offset > 0)
			{
				cw.write(chars, 0, offset);
			}
			String result = cw.toString();
			return result;
		}
		finally
		{
			cw.close();
			reader.close();
			//System.gc();
		}
	}
}