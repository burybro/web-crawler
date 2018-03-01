import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Getinformation {
    public int[][] getUrl(String number) {
    	int ballres[][] =new int[2][7];
    	String url="http://kaijiang.500.com/shtml/ssq/"+number+".shtml";
        try {
            Document document = Jsoup.connect(url).timeout(30000).post();
            Elements text = document.select("tr:has(td:containsOwn(����˳��))");
            String res = text.get(0).text();
            //��������������˺���������վ��һ��17001bug��
            int subpos = res.indexOf("���˺���");
            if(subpos!=-1) {
            	res=res.substring(0,subpos)+res.substring(subpos+9);
            }
            if(number.equals("17001")) {
            	res="�������룺 26 09 20 25 14 11 15 ����˳�� 09 11 14 20 25 26";
            }
            //��������������
            String[] ballstr = res.split(" ");
            for(int k =1;k<=7;k++)
            	ballres[0][k-1]=Integer.valueOf(ballstr[k]);   
            for(int k =9;k<=14;k++)
            	ballres[1][k-9]=Integer.valueOf(ballstr[k]); 
            ballres[1][6]=ballres[0][6];
            
            return ballres;
        } catch (IOException e) {
        	System.out.println("δ�ҵ�"+url);
        	System.out.println("�������»�ȡ");
            return getUrl(number);
        }
		
    }
    
    public String[] getlist(String url) {
    	String[] ballstr;
        try {
            Document document = Jsoup.connect(url).timeout(30000).post();
            Elements text = document.select("a[href~=^http://kaijiang.500.com/shtml/ssq/]");
            ballstr = new String[text.size()-1];
            for(int k=0;k<text.size()-1;k++) {
            	ballstr[k]=text.get(k).text();
            }

            return ballstr;
        } catch (IOException e) {
        	System.out.println("δ�ҵ�"+url);
            return null;
        }
		
    }
    
    public String addZero(int obj) {
    	if(obj<10000) {
    		return "0"+obj;
    	}
    	else
    		return ""+obj;
    }
}