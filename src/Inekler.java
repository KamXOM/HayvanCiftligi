public class Inekler extends HayvanArayuz {
	Depo depo;
	Inekler(){
		sayi=(int)(Math.random()*90+10);
		suIhtiyaci=sayi*35;
		yemIhtiyaci=sayi;
	}	
	public void setDepo(Depo depo) {
		this.depo=depo;
	}
	public void inekBesle() {
		if(yemIhtiyaci!=0) {
			if(depo.inek_yem>=yemIhtiyaci) {
				System.out.println("Inekler Beslendi.");
				depo.inek_yem-=yemIhtiyaci;
				yemIhtiyaci=0;
			}
			else {System.out.println("Yeterli Inek Yemi Bulunmamaktadır!");}
		}
		else {System.out.println("Inekler Tok! ");}
	}
	public void inekSula() {
		if(suIhtiyaci!=0) {
			if(depo.su>=suIhtiyaci) {
				System.out.println("Ineklere Su Verildi.");
				depo.su-=suIhtiyaci;
				suIhtiyaci=0;
			}
			else {System.out.println("Yeterli Suyunuz Bulunmamaktadir!");}
		}
		else {System.out.println("Ineklerin Suya Ihtiyaci Yok! ");}
	}
}