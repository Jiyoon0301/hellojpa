package jpql;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("hello"); //데이터 베이스와 연결됨

        EntityManager em = emf.createEntityManager(); // entitymanager 꺼내기 / em = entity manager

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //실제 동작하는 code 작성 위치 ex) db에 데이터 작성 or 불러오기
        try {

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member=new Member();
            member.setUsername("teamA");
            member.setAge(10);

            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            String query=
                    "select "+
                            "case when m.age <= 10 then '학생요금'"+
                            "when m.age >= 60 then '경로요금'"+
                            "else '일반요금' "+
                            "end"+
                            "from Member m";
            List<String> result =  em.createQuery(query, String.class)
                            .getResultList();
            for (String s: result){
                System.out.println("s = "+s);
            }
            em.createQuery(query);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
