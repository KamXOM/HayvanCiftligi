public class Depo {
	private Inekler inek;
	private Koyunlar koyun;
	public int inek_ozelYem=0;
	public int inek_balya=0;
	public int inek_sutYemi=0;
	public int koyun_sutYemi=0;
	public int su=0;
	public int koyun_et=0;
	public int koyun_sut=0;
	public int koyun_yun=0;
	public int inek_sut=0;
	public int inek_et=0;
	public int inek_yem=0;
	public int ineksuthakki=0;
	public int koyunsuthakki=0;
	public int koyunyunhakki=0;
	Depo(Inekler inek,Koyunlar koyun){
		this.inek=inek;
		this.koyun=koyun;
	}
	public void yemUretme() {
			inek_yem+=Math.min(Math.min(inek_ozelYem/3,inek_balya/7),inek_sutYemi/3);
			inek_ozelYem-=inek_yem*3;
			inek_balya-=inek_yem*7;
			inek_sutYemi-=inek_yem*3;		
	}
	public void inekSutSagma() {
		if(ineksuthakki<1) {
			inek_sut+=inek.sayi*(int)((Math.random()*5)+13);
			ineksuthakki++;
			System.out.println("Inekler Sagildi.");
		}
		else System.out.println("Inekler Coktan Sagildi.");
	}
	public void koyunSutSagma() {
		if(koyunsuthakki<1) {
			koyun_sut+=koyun.sayi*(int)((Math.random()*3)+3);
			koyunsuthakki++;
			System.out.println("Koyunlar Sagildi.");
		}
		else System.out.println("Koyunlar Coktan Sagildi.");
	}
	public void yunKesme() {
		if(koyunyunhakki<1) {
			koyun_yun=koyun.sayi*(int)((Math.random()*3)+3);
			koyunyunhakki++;
			System.out.println("Koyunlarin Yunleri Kirpildi.");
		}
		else System.out.println("Koyunlarin Yunleri Coktan Kırpıldı.");
	}
}