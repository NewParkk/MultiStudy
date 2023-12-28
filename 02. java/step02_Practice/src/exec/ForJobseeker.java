package exec;
import model.daomain.Company;
import model.daomain.Jobapplicant;


public class ForJobseeker {
	

	
	public static void main(String[] args) {
		
	}

	public static void companylist(Company[] cs) {
		for (Company rand : cs) {
			System.out.println(rand.getName());
		}
		
		Jobapplicant a = new Jobapplicant("이름", 20, "학위", "java,c");
		Jobapplicant b = new Jobapplicant("이름", 20, "학위", "c,c++");
		Company ca = new Company("IT", "한국", 5000, "java,c,python,c++");
		
//		구직자의 스킬과 회사의 요구스킬 매칭
		Jobapplicant[] list = {a,b};
		for(Jobapplicant temp : list) {
			
		}
	}










}