import java.util.Scanner;
class GirisIslemleri {
	private static String[] calisanposta=new String[10];
	private static String[] calisansifre=new String [10];
	private static int calisansayisi=0;
	private static Scanner sc;
	private HosGeldiniz hosgeldiniz;
	private int denemehakki=0;
	static{sc=new Scanner(System.in);}
	public void setHosgeldiniz(HosGeldiniz hosgeldiniz){
		this.hosgeldiniz=hosgeldiniz;
	}
	public int islemler(int islem){
		Yonetici yt = new Yonetici();
		String posta,sifre;
		if(islem==1) {
			if(denemehakki<3) {
				System.out.println("E-Postaniz: ");	posta=sc.nextLine();
				System.out.println("Sifreniz: "); sifre=sc.nextLine();
				if(yt.getPosta().equals(posta) && yt.getSifre().equals(sifre)) {
					System.out.println("Yonetici Girisi Basarili! Hoş Geldiniz."); 
					return 1;
				}
				else {
					System.out.println("Yonetici Girisi Basarisiz!\nYeniden Deneyin..");
					denemehakki++;	islemler(1);
				}
			}
			else { 
				System.out.println("Cok Fazla Deneme Yaptiniz! ");	
				denemehakki=0;	hosgeldiniz.hosgeldin();
			}
		}
		else if(islem==2) {
			if(denemehakki<3) {
				System.out.println("E-Postaniz: ");	posta=sc.nextLine(); 
				System.out.println("Sifreniz: "); sifre=sc.nextLine();
				if(GirisIslemleri.Calisan.girisYap(posta,sifre)) {
					System.out.println("Calisan Girisi Basarili! Hoş Geldiniz.");
					return 2;
				}
				else {
					System.out.println("Calisan Girisi Basarisiz!\nYeniden Deneyin..");
					denemehakki++;	islemler(2);
				}
			}
			else {
				System.out.println("Cok Fazla Deneme Yaptiniz! ");	
				denemehakki=0;	hosgeldiniz.hosgeldin();
			}
		}
		else if(islem==3) {
			GirisIslemleri.Calisan.kayitOl(sc);denemehakki=0;hosgeldiniz.hosgeldin();
		}
		else if(islem==0) {
			System.out.println("Iyi Gunler Dileriz. ");
			System.exit(0);
		}
		return 5;
	}
	class Yonetici{
		private String yoneticiposta="onurmalay@hotmail.com";
		private String yoneticisifre="nolur100alayim";
		String getPosta() {
			return yoneticiposta;
		}
		String getSifre() {
			return yoneticisifre;
		}
	}
	class Calisan{
		public static void kayitOl(Scanner sc) {
			Scanner scn = sc;
			try {
				if(calisansayisi>=calisanposta.length || calisansayisi>=calisansifre.length) {
					throw new ArrayIndexOutOfBoundsException("Maksimum Calisan Sayisina Ulasildi!");
				}
			System.out.println("Yeni iscinin E-postasi: ");
			calisanposta[calisansayisi]=scn.nextLine();
			System.out.println("Yeni iscinin Sifresi: ");
			calisansifre[calisansayisi]=scn.nextLine();
			calisansayisi++;
			System.out.println("Kayit Basarili! Giris Yapabilirsiniz..");
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		}
		public static Boolean girisYap(String posta,String sifre) {
			boolean sonuc=false;
			for (int i=0;i<calisansayisi;i++) {
	            if (calisanposta[i].equals(posta) && calisansifre[i].equals(sifre)) {
	                sonuc=true;	break;
	            }
	            else sonuc=false;
	        }
			return sonuc;
		}
	}
}