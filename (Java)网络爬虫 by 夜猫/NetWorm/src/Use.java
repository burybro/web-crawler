
public class Use {

	public static void main(String[] args) {
		Getinformation ssq = new Getinformation();
		String balllist[] = ssq.getlist("http://kaijiang.500.com/shtml/ssq/03001.shtml");
		int ballres[][][] = new int[balllist.length][2][7];
		for(int k=balllist.length-1;k>=0;k--) {
			int temp[][] = ssq.getUrl(balllist[k]);
			if(temp!=null) {
				ballres[balllist.length-1-k] = ssq.getUrl(balllist[k]);
				
				System.out.println("��"+balllist[k]+"��");
				TxtIO.write("E:\\BallRes.txt","<"+balllist[k]+">");
				
				String ballres_s = "";
				for(int i=0;i<7;i++)
					ballres_s =ballres_s+" "+ballres[balllist.length-1-k][0][i];
				System.out.println("�������룺"+ballres_s);
				TxtIO.write("E:\\BallRes.txt",ballres_s);
				
				String ballres_ns = "";
				for(int i=0;i<7;i++)
					ballres_ns =ballres_ns+" "+ballres[balllist.length-1-k][1][i];
				System.out.println("����˳��"+ballres_ns);
				TxtIO.write("E:\\BallRes.txt",ballres_ns);
			}
			else {
				System.out.println("��"+balllist[k]+"��");
				TxtIO.write("E:\\BallRes.txt","<"+balllist[k]+">");
				System.out.println("���ݳ���");
				TxtIO.write("E:\\BallRes.txt","���ݳ���");
			}
		}
	}

}
