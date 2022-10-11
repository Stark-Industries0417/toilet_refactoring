package toiletproject.toilet.option;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toiletproject.toilet.toilets.entity.ToiletEntity;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "options")
@Entity
public class OptionEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Long id;

    @Column(nullable = false, columnDefinition="BOOLEAN DEFAULT false")
    private Boolean common;

    @Column(nullable = false, columnDefinition="BOOLEAN DEFAULT false")
    private Boolean locked;

    @ElementCollection
    private List<Integer> types;

    @Column(nullable = false, columnDefinition="BOOLEAN DEFAULT true")
    private Boolean paper;

    @Column(nullable = false, columnDefinition="BOOLEAN DEFAULT false")
    private Boolean disabled;

    @OneToOne(mappedBy = "option", fetch = FetchType.LAZY)
    private ToiletEntity toilet;
}
