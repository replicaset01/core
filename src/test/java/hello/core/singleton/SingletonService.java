package hello.core.singleton;

public class SingletonService {
    // 자기 자신을 내부에 private static 으로 선언
    // static 영역에 객채를 딱 1개만 생성
    // static 선언으로 인해 클래스 레벨로 올라가기 때문에, '1개만 존재' 를 충족
    private static final SingletonService instance = new SingletonService();

    // public으로 열어서 객체 인스턴스가 필요하면 이 static 메소드를 통해서만 조회 허용
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private 으로 선언하여 '외부에서 new를 통한 객체 생성을 막음' 충족
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
