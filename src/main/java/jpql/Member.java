package jpql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Member {

    @Id@GeneratedValue
    private Long id;
    private String username;
    private int age;

    // 연관관계 잡기
    @ManyToOne(fetch = LAZY) // fetch = LAZY 필수
    @JoinColumn(name="TEAM_ID")
    private Team team;

    private MemberType type; // ADMIN, USER

    public void changeTeam(Team team){ // 연관관계 편의 메소드
        this.team=team;
        team.getMembers().add(this);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
