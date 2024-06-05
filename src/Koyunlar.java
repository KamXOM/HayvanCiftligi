public class Koyunlar extends HayvanArayuz {
	Depo depo;
	Koyunlar(){
		sayi=(int)(Math.random()*100+30);
		suIhtiyaci=sayi*8;
		yemIhtiyaci=sayi*5;
	}	
	public void setDepo(Depo depo) {
		this.depo=depo;
	}
	public void koyunBesle() {
		if(yemIhtiyaci!=0) {
			if(depo.koyun_sutYemi>=yemIhtiyaci) {
				System.out.println("Koyunlar Beslendi.");
				depo.koyun_sutYemi-=yemIhtiyaci;
				yemIhtiyaci=0;
			}
			else {System.out.println("Yeterli Koyun Yemi Bulunmamaktadır!");}
		}
		else {System.out.println("Koyunlar Tok! ");}
	}
	public void koyunSula() {
		if(suIhtiyaci!=0) {
			if(depo.su>=suIhtiyaci) {
				System.out.println("Koyunlara Su Verildi.");
				depo.su-=suIhtiyaci;
				suIhtiyaci=0;
			}
			else {System.out.println("Yeterli Suyunuz Bulunmamaktadir!");}
		}
		else {System.out.println("Koyunlarin Suya Ihtiyaci Yok! ");}
	}
}