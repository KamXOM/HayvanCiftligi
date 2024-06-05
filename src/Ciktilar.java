import java.util.Scanner;
public class Ciktilar {
	private Scanner sc;
	private Depo depo;
	private Kasap kasap;
	private Dukkan dukkan;
	private Kasa kasa;
	private Inekler inek;
	private Koyunlar koyun;
	private HosGeldiniz hosgeldiniz;
	Ciktilar(Depo depo,Kasap kasap,Dukkan dukkan,Kasa kasa,Inekler inek,Koyunlar koyun,Scanner sc){
		this.depo=depo;
		this.kasap=kasap;
		this.dukkan=dukkan;
		this.kasa=kasa;
		this.inek=inek;
		this.koyun=koyun;
		this.sc=sc;
	}
	public void setHosGeldiniz(HosGeldiniz hosgeldiniz) {
		this.hosgeldiniz=hosgeldiniz;
	}
	public void Islemler(int izin) {//bitti
		int secim;
		if(izin==1) {
			do {
				System.out.println("Ne yapmak istersiniz? (Bakiyeniz: "+kasa.get()+"TL)");
				System.out.println("1-Depo Durumunu Incele\n2-Dukkan Sayfasini Ac\n"
						+ "3-Kasap Islemleri\n0-Cikis Yap");
				secim=sc.nextInt();
			}while(secim<0 || secim>4);
			switch(secim) {
			case 1: depoIslemleri(1); break;
			case 2: dukkanIslemleri(); break;
			case 3: kasapIslemleri(); break;
			case 4: ahirIslemleri(); break;
			case 0: hosgeldiniz.hosgeldin(); break;
			}
		}
		else if(izin==2) {
			do {
				System.out.println("Ne yapmak istersiniz?");
				System.out.println("1-Depo Durumunu Incele\n2-Ahir Islemleri\n3-Hayvanlari Besle\n0-Cikis Yap");
				secim=sc.nextInt();
			}while(secim<0 || secim>3);
			switch(secim) {
			case 1: depoIslemleri(2); break;
			case 2: ahirIslemleri(2); break;
			case 3: hayvanlariBesle(); break;
			case 0: hosgeldiniz.hosgeldin(); break;
			}
		}
	}
	public void depoIslemleri(int izin) {//bitti
		System.out.println("Inek Ozel Yemi: "+depo.inek_ozelYem+"Kg");
		System.out.println("Inek Balyası: "+depo.inek_balya+"Kg");
		System.out.println("Inek Sut Yemi: "+depo.inek_sutYemi+"Kg");
		System.out.println("Inek Yemi: "+depo.inek_yem+"Kg");
		System.out.println("Inek Sutu: "+depo.inek_sut+"L");
		System.out.println("Inek Eti: "+depo.inek_et+"Kg");
		System.out.println("Koyun Sut Yemi: "+depo.koyun_sutYemi+"Kg");
		System.out.println("Koyun Sutu: "+depo.koyun_sut+"L");
		System.out.println("Koyun Yunu: "+depo.koyun_yun+"Kg");
		System.out.println("Koyun Eti: "+depo.koyun_et+"Kg");
		System.out.println("Su: "+depo.su+"L");
		System.out.println("\nDevam Etmek Icin 0'a Basin."); 
		int secim=sc.nextInt();
		if(secim==0) Islemler(izin);	else depoIslemleri(izin);	
	}
	public void dukkanIslemleri() {//bitti
		int islem,secim;
		do {
			System.out.println("1-Satma Islemleri\n2-Satın Alma Islemleri\n0-Geri Don");
			islem=sc.nextInt();
		}while(islem<0 || islem>2);
		switch(islem) {
		case 1:	
			do {
				System.out.println("1-Inek Sutu Satma (Mevcut: "+depo.inek_sut+"L)");
				System.out.println("2-Koyun Sutu Satma (Mevcut: "+depo.koyun_sut+"L)");
				System.out.println("3-Koyun Yunu Satma (Mevcut: "+depo.koyun_yun+"Kg)");
				System.out.println("0-Geri Don");
				secim=sc.nextInt();
			}while(secim<0 || secim>3);
			switch(secim) {
			case 1: System.out.println("Kac Litre Inek Sutu Satmak Istersiniz? "+"(Mevcut: "+depo.inek_sut+"L)");
					int ineksut=sc.nextInt(); 
					if(depo.inek_sut>=ineksut) {	dukkan.inekSutSatma(ineksut); dukkanIslemleri(); break;	}
					else {	System.out.println("Yetersiz Malzeme!"); dukkanIslemleri();	break;	}
			case 2: System.out.println("Kac Litre Koyun Sutu Satmak Istersiniz? "+"(Mevcut: "+depo.koyun_sut+"L)");
					int koyunsut=sc.nextInt();
					if(depo.koyun_sut>=koyunsut) {	dukkan.koyunSutSatma(koyunsut);	dukkanIslemleri(); break;	}
					else {	System.out.println("Yetersiz Malzeme!"); dukkanIslemleri();	break;	}
			case 3: System.out.println("Kac Kilogram Koyun Yunu Satmak Istersiniz? "+"(Mevcut: "+depo.koyun_yun+"Kg)");
					int koyunyun=sc.nextInt();
					if(depo.koyun_yun>=koyunyun) {	dukkan.koyunYunSatma(koyunyun);	dukkanIslemleri(); break;	}
					else {	System.out.println("Yetersiz Malzeme!"); dukkanIslemleri();	break;	}
			case 0: dukkanIslemleri(); break;
		}
		break;
		case 2:	
			do {
				System.out.println("1-Inekler Icin Ozel Yem Satin Alma (Mevcut: "+depo.inek_ozelYem+"Kg)");
				System.out.println("2-Inekler Icin Balya Satin Alma (Mevcut: "+depo.inek_balya+"Kg)");
				System.out.println("3-Inekler Icin Sut Yemi Satin Alma (Mevcut: "+depo.inek_sutYemi+"Kg)");
				System.out.println("4-Koyunlar Icin Sut Yemi Satin Alma (Mevcut: "+depo.koyun_sutYemi+"Kg)");
				System.out.println("5-Su Satın Alma (Mevcut: "+depo.su+"L)");
				System.out.println("0-Geri Don");
				secim=sc.nextInt();
			}while(secim<0 || secim>5);
			switch(secim) {
			case 1: System.out.println("Kac Torba Ozel Yem Satin Almak Istersiniz? (1 Torba 50 Kg)");
					int torba=sc.nextInt(); 
					if(kasa.get()>=torba*500) {	dukkan.ozelyemSatınAl(torba);  dukkanIslemleri();	break;	}
					else {	System.out.println("Yetersiz Bakiye!");	dukkanIslemleri();	break;	}
			case 2: System.out.println("Kac Adet Balya Satin Almak Istersiniz? (1 Balya 25 Kg)");
					int balya=sc.nextInt(); 
					if(kasa.get()>=balya*100) {	dukkan.balyaSatınAl(balya); dukkanIslemleri();	break;	}
					else {	System.out.println("Yetersiz Bakiye!");	dukkanIslemleri();	break;	}		
			case 3: System.out.println("Kac Torba Sut Yemi Satin Almak Istersiniz? (1 Torba 50 Kg)");
					int torbasutyemi=sc.nextInt(); 
					if(kasa.get()>=torbasutyemi*1000){dukkan.ineksutyemiSatınAl(torbasutyemi);dukkanIslemleri();break;}
					else {	System.out.println("Yetersiz Bakiye!");	dukkanIslemleri();	break;	}
			case 4: System.out.println("Kac Torba Sut Yemi Satin Almak Istersiniz? (1 Torba 20 Kg)");
					int torbasutyem=sc.nextInt(); 
					if(kasa.get()>=torbasutyem*600){dukkan.koyunsutyemiSatınAl(torbasutyem);dukkanIslemleri();break;}
					else {	System.out.println("Yetersiz Bakiye!");	dukkanIslemleri();	break;	}
			case 5: System.out.println("Kac Depo Su Satin Almak Istersiniz? (1 Depo 150 Litre)");
					int sudepo=sc.nextInt(); 
					if(kasa.get()>=sudepo*750){	dukkan.suSatınAl(sudepo);dukkanIslemleri(); break;	}
					else {	System.out.println("Yetersiz Bakiye!");	dukkanIslemleri();	break;	}
			case 0: dukkanIslemleri(); break;
			}
		break;
		case 0: Islemler(1); break;
		}
	}
	public void kasapIslemleri() {//bitti
		int secim;
		do {
			System.out.println("1-Inek Kesim");
			System.out.println("2-Inek Eti Satis");
			System.out.println("3-Koyun Kesim");
			System.out.println("4-Koyun Eti Satis");
			System.out.println("0-Geri Don");
			secim=sc.nextInt();
		}while(secim>4 || secim<0);
		switch(secim) {
		case 1: System.out.println("Kac Inegin Kesimi Yapilacak? (Mevcut: "+inek.sayi+")");
				int kesilecekinek=sc.nextInt();
				if(inek.sayi>=kesilecekinek) {kasap.inekIsleri(kesilecekinek,2);kasapIslemleri();break;}
				else {	System.out.println("Yetersiz Inek Sayisi!"); kasapIslemleri();	break;	}
		case 2: System.out.println("Kac Kg Et Satilacak? (Mevcut: "+depo.inek_et+"Kg)");
		 		int satilacakineket=sc.nextInt();
		 		if(depo.inek_et>=satilacakineket) {kasap.inekIsleri(satilacakineket);kasapIslemleri();break;}
				else {	System.out.println("Yetersiz Inek Eti!"); kasapIslemleri();	break;	}
		case 3: System.out.println("Kac Koyunun Kesimi Yapilacak? (Mevcut: "+koyun.sayi+")");
				int kesilecekkoyun=sc.nextInt();
				if(koyun.sayi>=kesilecekkoyun) {kasap.koyunIsleri(kesilecekkoyun,2);kasapIslemleri();break;}
				else {	System.out.println("Yetersiz Koyun Sayisi!"); kasapIslemleri();	break;	}
		case 4: System.out.println("Kac Kg Et Satilacak? (Mevcut: "+depo.koyun_et+"Kg)");
 				int satilacakkoyunet=sc.nextInt();
 				if(depo.koyun_et>=satilacakkoyunet){kasap.koyunIsleri(satilacakkoyunet);kasapIslemleri();break;}
				else {	System.out.println("Yetersiz Koyun Eti!"); kasapIslemleri();	break;	}
		case 0: Islemler(1); break;
		}
	}
	public void ahirIslemleri(int izin) {//bitti
		int secim;
		do {
			System.out.println("1-Inek Yemi Uretme");
			System.out.println("2-Ineklerin Sutunu Sagma");
			System.out.println("3-Koyunlarin Sutunu Sagma");
			System.out.println("4-Koyunlarin Yununu Kırpma");
			System.out.println("0-Geri Don");
			secim=sc.nextInt();
		}while(secim>4 || secim<0);
		switch(secim) {
		case 1: if(depo.inek_ozelYem>=3 && depo.inek_balya>=7 && depo.inek_sutYemi>=3) {
					System.out.println("Yeterli Malzeme Var. Uretim Basliyor..");
					depo.yemUretme(); System.out.println("Uretim Basariyla Tamamlandı!");ahirIslemleri(izin);break;}
				else {	System.out.println("Yetersiz Malzeme!");	ahirIslemleri(izin);	break;	}
		case 2: if(inek.sayi>0){ depo.inekSutSagma(); ahirIslemleri(izin);break;}	
				else {	System.out.println("Sagacak Inek Bulunmamaktadir!"); ahirIslemleri(izin);	break; }
		case 3: if(koyun.sayi>0){ depo.koyunSutSagma(); ahirIslemleri(izin);break;}
				else {	System.out.println("Sagacak Koyun Bulunmamaktadir!"); ahirIslemleri(izin);break;}
		case 4: if(koyun.sayi>0){depo.yunKesme();ahirIslemleri(izin);break;}
				else {	System.out.println("Kirpilacak Koyun Bulunmamaktadir!"); ahirIslemleri(izin);break;}
		case 0: Islemler(izin); break;
		}
	}
	public void ahirIslemleri() {
		int oleninek=(int)((Math.random()*6)+2);
		inek.sayi-=oleninek;
		System.out.println("Tebrikler! Beceremedin ve "+oleninek+" Inegin Öldü");
		Islemler(1);
	}
	public void hayvanlariBesle() {
		int secim;
		do {
			System.out.println("1-Inekleri Besle");
			System.out.println("2-Ineklere Su Ver");
			System.out.println("3-Koyunlari Besle");
			System.out.println("4-Koyunlara Su Ver");
			System.out.println("0-Geri Don");
			secim=sc.nextInt();
		}while(secim>4 || secim<0);
		switch(secim) {
		case 1: inek.inekBesle(); hayvanlariBesle(); break;
		case 2: inek.inekSula(); hayvanlariBesle(); break;
		case 3: koyun.koyunBesle(); hayvanlariBesle(); break;
		case 4: koyun.koyunSula(); hayvanlariBesle(); break;
		case 0: Islemler(2); break;
		}
	}
}