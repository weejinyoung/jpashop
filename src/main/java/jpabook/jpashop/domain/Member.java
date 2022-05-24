package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
//api를 만들때는 엔티티를 파라미터로 받아선 안되고 외부에 노출해선 안된다
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    private String name;

    @Embedded
    private Address address;

    @JsonIgnore //멤버조회 시 오더정보를 제외한 순수 멤버정보를 가져오기 위해서ㅏ
    @OneToMany(mappedBy = "member")
    public List<Order> orders = new ArrayList<>();

}
