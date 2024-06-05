public class Kasap {
	private Inekler inek;
	private Koyunlar koyun;
	private Depo depo;
	private Kasa kasa;
	Kasap(Inekler inek,Depo depo,Koyunlar koyun,Kasa kasa){
		this.inek=inek;
		this.depo=depo;
		this.koyun=koyun;
		this.kasa=kasa;
	}
	public void inekIsleri(int kesileninek,int a) {
		inek.sayi-=kesileninek;
		depo.inek_et+=350*kesileninek;
	}
	public void inekIsleri(int kiloet){
		depo.inek_et-=kiloet;
		kasa.set(kasa.get()+170*kiloet);
	}
	public void koyunIsleri(int kesilenkoyun,int a) {
		koyun.sayi-=kesilenkoyun;
		depo.koyun_et+=18*kesilenkoyun;
	}
	public void koyunIsleri(int kiloet) {
		depo.koyun_et-=kiloet;
		kasa.set(kasa.get()+150*kiloet);
	}
}