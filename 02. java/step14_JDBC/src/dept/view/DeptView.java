package dept.view;

import dept.controller.DeptController;

public class DeptView {
	public static void main(String[] args) {
		
		DeptController dpcontroller = DeptController.getInstance();
		// 모든 부서 출력
		System.out.println(dpcontroller.getAllDept());
		
		// 특정 부서 검색
//		System.out.println(DeptController.getDeptByDeptno(20));
		
//		 특정 부서 생성
//		Dept newDept = new Dept(50, "IT", "SEOUL");
//		boolean insertResult = DeptController.intsertDept(newDept);
//		if(insertResult) {
//			System.out.println("부서 생성 완료");
//		} else {
//			System.out.println("부서 생성 실패");
//		}
		
		// 부서번호로 검색한 특정 부서의 위치 수정
//		boolean updateResult = DeptController.updateLoc(20, "NAMYANGJOO");
//        if (updateResult) {
//            System.out.println("부서 위치 수정 완료");
//        } else {
//            System.out.println("부서 위치 수정 실패");
//        }
		
		
//		boolean deleteResult = DeptController.deleteDept(10);
//      if (deleteResult) {
//          System.out.println("부서 삭제 완료");
//      } else {
//          System.out.println("부서 삭제 실패");
//      }
//   
        
        

        
        
        
    }
}
