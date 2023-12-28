package model.domain;

import java.util.ArrayList;

import dto.Developer;

public class DeveloperVirtualDB {
    private static DeveloperVirtualDB instance = new DeveloperVirtualDB();
    private ArrayList<Developer> developers = new ArrayList<>();

    private DeveloperVirtualDB() {
        // 초기 개발자 데이터 추가
        developers.add(new Developer("a", "Java", 5));
        developers.add(new Developer("b", "Python", 3));
        developers.add(new Developer("c", "JavaScript", 7));
    }

    public static DeveloperVirtualDB getInstance() {
        return instance;
    }
    
    
    
    
    // 모든 개발자 반환
    public ArrayList<Developer> getDeveloperList() {
        return developers;
    }

    // 개발자 추가
    public void insertDeveloper(Developer newDeveloper) {
        developers.add(newDeveloper);
    }

    // 개발자 삭제
    public void removeDeveloper(Developer developer) {
        developers.remove(developer);
    }

    // 개발자 정보 업데이트
    public void updateDeveloper(String name, Developer updatedeveloper) {
    	
    	for(Developer developer : developers) {
    		if (developer.getName().equals(name)) {
    			developer.setName(updatedeveloper.getName());;
    			developer.setSkill(updatedeveloper.getSkill());;
    			developer.setCareer(updatedeveloper.getCareer());
				
			}
		}
    }
    
    
    
    
    
    
    
    
}

