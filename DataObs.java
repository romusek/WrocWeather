import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class DataObs{
	public static String dzisiaj(){//20170816 06
		Date date = new Date(); //Date.getHours() <= 15 ? getYesterdayDate() : new Date();
		if (date.getHours() <= 6)
			date = getYesterdayDate();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String format = formatter.format(date);
		//System.out.println(format);
		return format;
	}

	public static String teraz(){//ZJEBANE MIEDZY 00 - 06 
		String result = "18";
		Date date = new Date();
		int h = date.getHours();
		if (h > 6)
			result = "00";
		if (h > 12)
			result = "06";
		if (h > 18)
			result = "12";

		//System.out.println(result);
		return result;
	}

	public static String createLink(){//	http://new.meteo.pl/um/metco/mgram_pict.php?ntype=0u&fdate=XXXXXXXXXX&row=436&col=181&lang=pl
		StringBuffer sb = new StringBuffer("http://new.meteo.pl/um/metco/mgram_pict.php?ntype=0u&fdate=");
		sb.append(dzisiaj()).append(teraz()).append("&row=436&col=181&lang=pl");//GODZINA DO POPRAWY - solved
		return sb.toString();
	}

	private static Date getYesterdayDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

	public static void main(String[] f){
		//createLink();
		//dzisiaj();
		//teraz();
	}
}
