
public class textQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Query q = new Query();
		q.slecting("select * from imageInfo;");

        try {
            while(q.rs.next()){

                System.out.println(q.rs.getString(1));
                System.out.println(q.rs.getString(2));
                System.out.println(q.rs.getString(3));
                System.out.println(q.rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println("Error!! ");
        }

	}

}
