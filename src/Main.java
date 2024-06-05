import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Inekler inekler=new Inekler();
		Koyunlar koyunlar=new Koyunlar();
		Depo depo=new Depo(inekler,koyunlar);
		Kasa kasa=new Kasa(inekler,koyunlar);
		Dukkan dukkan=new Dukkan(kasa,depo);
		Kasap kasap=new Kasap(inekler,depo,koyunlar,kasa);
		GirisIslemleri girisislemleri=new GirisIslemleri();
		HosGeldiniz hg=new HosGeldiniz(girisislemleri,sc);
		Ciktilar ciktilar=new Ciktilar(depo,kasap,dukkan,kasa,inekler,koyunlar,sc);
		girisislemleri.setHosgeldiniz(hg);
		hg.setCiktilar(ciktilar);
		ciktilar.setHosGeldiniz(hg);
		koyunlar.setDepo(depo);
		inekler.setDepo(depo);
		while(true) { //beklenmedik kapanmaların önüne geçmek için
			hg.hosgeldin();
		}
		//sc.close();
	}
}
class HosGeldiniz{
	private Scanner sc;
	private GirisIslemleri girisislemleri;
	private Ciktilar ciktilar;
	HosGeldiniz(GirisIslemleri girisislemleri,Scanner sc){
		this.girisislemleri=girisislemleri;
		this.sc=sc;
	}
	public void setCiktilar(Ciktilar ciktilar) {
		this.ciktilar=ciktilar;
	}
	public void hosgeldin() {
		int islem;
		try {
			do {
				System.out.println("Hos Geldiniz.");
				System.out.println("Yonetici girisi icin 1'e \n"
						+ "Isci girisi yapmak icin 2'ye \n"
						+ "Yeni isci olarak kayit olmak icin 3'e \n"
						+ "Cikis yapmak icin 0'a basiniz: ");
				islem=sc.nextInt();
			}while(islem<0 || islem>3);
			int girisdonus=girisislemleri.islemler(islem);
			switch(girisdonus) {
			case 1: ciktilar.Islemler(1); break;
			case 2: ciktilar.Islemler(2); break;
			case 0: hosgeldin(); break;
			}
		}
		catch(InputMismatchException e) {
		System.out.println("Hatali Giris! Lutfen Sayi Giriniz..");
		sc.next();	islem=8;	hosgeldin();
		}
	}
}