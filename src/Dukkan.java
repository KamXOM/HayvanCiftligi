public class Dukkan {
	 protected int inek_ozelYem;
	 protected int inek_balya;
	 protected int inek_sutYemi;
	 protected int koyun_sutYemi;
	 protected int su;
	 private Kasa kasa;
	 private Depo depo;
	 Dukkan(Kasa kasa,Depo depo){
		 this.kasa=kasa;
		 this.depo=depo;
	 }
	public void inekSutSatma(int litre){
		depo.inek_sut-=litre;
		kasa.set(kasa.get()+36*litre);
	}
	public void koyunSutSatma(int litre){
		depo.koyun_sut-=litre;
		kasa.set(kasa.get()+14*litre);
	}
	public void koyunYunSatma(int kg){
		depo.koyun_yun-=kg;
		kasa.set(kasa.get()+50*kg);
	}
	public void ozelyemSatınAl(int torba) {
		depo.inek_ozelYem+=50*torba;
		kasa.set(kasa.get()-500*torba);
	}
	public void balyaSatınAl(int adet) {
		depo.inek_balya+=25*adet;
		kasa.set(kasa.get()-100*adet);
	}
	public void ineksutyemiSatınAl(int torba) {
		depo.inek_sutYemi+=50*torba;
		kasa.set(kasa.get()-1000*torba);
	}
	public void koyunsutyemiSatınAl(int torba) {
		depo.koyun_sutYemi+=20*torba;
		kasa.set(kasa.get()-600*torba);
	}
	public void suSatınAl(int deposu) {
		depo.su+=150*deposu;
		kasa.set(kasa.get()-750*deposu);
	}
}