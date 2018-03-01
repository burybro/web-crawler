
public class Use {

	public static void main(String[] args) {
		Getinformation ssq = new Getinformation();
		String balllist[] = ssq.getlist("http://kaijiang.500.com/shtml/ssq/03001.shtml");
		int ballres[][][] = new int[balllist.length][2][7];
		for(int k=balllist.length-1;k>=0;k--) {
			int temp[][] = ssq.getUrl(balllist[k]);
			if(temp!=null) {
				ballres[balllist.length-1-k] = ssq.getUrl(balllist[k]);
				
				System.out.println("第"+balllist[k]+"期");
				TxtIO.write("E:\\BallRes.txt","<"+balllist[k]+">");
				
				String ballres_s = "";
				for(int i=0;i<7;i++)
					ballres_s =ballres_s+" "+ballres[balllist.length-1-k][0][i];
				System.out.println("开奖号码："+ballres_s);
				TxtIO.write("E:\\BallRes.txt",ballres_s);
				
				String ballres_ns = "";
				for(int i=0;i<7;i++)
					ballres_ns =ballres_ns+" "+ballres[balllist.length-1-k][1][i];
				System.out.println("出球顺序："+ballres_ns);
				TxtIO.write("E:\\BallRes.txt",ballres_ns);
			}
			else {
				System.out.println("第"+balllist[k]+"期");
				TxtIO.write("E:\\BallRes.txt","<"+balllist[k]+">");
				System.out.println("数据出错");
				TxtIO.write("E:\\BallRes.txt","数据出错");
			}
		}
	}

}
