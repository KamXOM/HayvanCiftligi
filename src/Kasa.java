public class Kasa {
	private int para;
	Kasa(Inekler inek,Koyunlar koyun){
		para=(inek.sayi*((int)(Math.random()*66)+300))+(koyun.sayi*((int)(Math.random()*72)+150));
	}
	public void set(int para) {
		this.para=para;
	}
	public int get() {
		return para;
	}
}