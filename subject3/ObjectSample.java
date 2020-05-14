class ObjectSample {

	 public static void main(String[] args) throws Exception {
			Recipe r1 = new Recipe("ハンバーグ", 200.5);
	        Recipe r2 = new Recipe("サーモン", 120);

	        System.out.println(r1.getName()); //ハンバーグ
	        System.out.println(r1.getCal()); //200.5
	    }

}