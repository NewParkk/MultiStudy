package blood.transfusion.service;

import java.util.ArrayList;

import blood.transfusion.dto.BloodTransfusionProject;
import blood.transfusion.dto.Donor;
import blood.transfusion.dto.People;
import blood.transfusion.dto.Recipient;
import blood.transfusion.exception.NotExistException;
import blood.transfusion.model.BloodTransfusionVirtualDB;

public class BloodTransFusionProjectService {
	private static BloodTransFusionProjectService instance = new BloodTransFusionProjectService();
	private BloodTransfusionVirtualDB projectVirtualData = BloodTransfusionVirtualDB.getInstance();

	private BloodTransFusionProjectService(){}
	public static BloodTransFusionProjectService getInstance(){
		return instance;
	}
	
	// 모든 프로젝트 반환
	public ArrayList<BloodTransfusionProject> getAllProjects(){
		return projectVirtualData.getProjectList();
	}
	
	// 프로젝트 검색_
	// 1. 모든 프로젝트
	// 2. 조건 : 프로젝트의 이름
	// 3. return 
	public BloodTransfusionProject getProject(String projectName) throws Exception {
		ArrayList<BloodTransfusionProject> projectList = projectVirtualData.getProjectList();
		BloodTransfusionProject project = null;
		
		for (int i = 0; i < projectList.size(); i++) {
			if (projectList.get(i).getBtProjectName().equals(projectName)) {
				project = projectList.get(i);
			}
		}
		
		//모든 반복을 마친다음에 예외를 발생시켜야 하기때문에 for문 밖에 예외처리 작성
		//만약 안에 넣으면 첫번째 예외발생을 찾고 뒤의 case를 검색하지 않음
		if (project == null) {
			throw new NotExistException("검색 요청하신 프로젝트는 존재하지 않습니다.");
		}
		
//		내가쓴거
//		for (BloodTransfusionProject project : BloodTransfusionVirtualDB.getInstance().getProjectList())
//		{
//			if(project.getBtProjectName().equals(projectName)) {
//				return project;
//	}
//		}
//			
//		System.out.println("검색 요청하신 프로젝트는 존재하지 않습니다");	

		
//		위의 조건검색으로 조건에 매칭되는것, 안되는것 모두 처리했기때문에 return구문을 마지막으로 빼서 정리
		return project;
	}

	// 새로운 프로젝트 추가_
	public void projectInsert(BloodTransfusionProject newProject) {
		if (newProject != null) {
			projectVirtualData.insertProject(newProject);			
		}
	}
	
	// 프로젝트 수정 - 프로젝트 명으로 현혈자 혹은 수혈자 수정_
	public void projectUpdate(String projectName, People people) throws Exception{
		
		//	프로젝트 이름으로 해당 프로젝트 존재하는지 여부 확인
		if (people instanceof Recipient) {
			BloodTransfusionProject project = getProject(projectName);
			project.setRecipient((Recipient)people);
		}
		else if (people instanceof Donor) {
			BloodTransfusionProject project = getProject(projectName);
			project.setDonor((Donor)people);
		}
		
	}
	// 프로젝트 삭제_
	public void projectDelete(String projectName) throws Exception{
		BloodTransfusionProject project = getProject(projectName);
		projectVirtualData.deleteProject(project);
	}	
}
