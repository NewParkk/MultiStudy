package DB;

import java.util.ArrayList;

import dto.Developer;

public class DeveloperDB {
    private static DeveloperDB instance = new DeveloperDB();
    private ArrayList<Developer> developers = new ArrayList<>();

    private DeveloperDB() {
        // 초기 개발자 데이터 추가
        developers.add(new Developer("a", "Java", 5));
        developers.add(new Developer("b", "Python", 3));
        developers.add(new Developer("c", "JavaScript", 7));
    }

    public static DeveloperDB getInstance() {
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
    public void updateDeveloper(Developer developer, String name, String skill, int career) {
        if (developers.contains(developer)) {
            developer.setName(name);
            developer.setSkill(skill);
            developer.setCareer(career);
        }
    }
}
