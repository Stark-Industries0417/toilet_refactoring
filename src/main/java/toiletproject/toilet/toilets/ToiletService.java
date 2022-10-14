package toiletproject.toilet.toilets;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toiletproject.toilet.toilets.dto.ToiletAddress;
import toiletproject.toilet.toilets.dto.ToiletAround;
import toiletproject.toilet.toilets.dto.ToiletAroundDto;
import toiletproject.toilet.toilets.dto.ToiletDto;
import toiletproject.toilet.toilets.entity.ToiletEntity;
import toiletproject.toilet.user.UserRepository;
import toiletproject.toilet.user.entity.UserEntity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ToiletService {

    private final ToiletRepository toiletRepository;
    private final UserRepository userRepository;
    private final RedisTemplate<String, List<ToiletAroundDto>> redisTemplate;

    @Transactional
    public ToiletDto addToilet(UserEntity auth, ToiletDto toiletAddDto) {
        UserEntity user = userRepository.findById(auth.getId()).get();
        ToiletEntity toilet = ToiletEntity.createToiletEntity(toiletAddDto);
        toilet.setUser(user);
        return new ToiletDto(toiletRepository.save(toilet));
    }

    public ToiletDto getToilet(ToiletAddress addressDto) {
        return new ToiletDto(toiletRepository.findByAddress(addressDto.getAddress())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 주소 입니다.")));
    }

    public List<ToiletAroundDto> aroundToilet(UserEntity user, ToiletAround aroundDto) {
        String email = user.getEmail();
        ValueOperations<String, List<ToiletAroundDto>> valueOperations = redisTemplate.opsForValue();
        List<ToiletAroundDto> toilets = valueOperations.get(email);

        if (toilets == null) {
            List<ToiletAroundDto> aroundToilets = toiletRepository.aroundToilet(aroundDto.getLat(), aroundDto.getLng(), aroundDto.getDist());
            valueOperations.set(email, aroundToilets);
            valueOperations.getAndExpire(email, 20, TimeUnit.MINUTES);
            return valueOperations.get(email);
        }
        return toilets;
    }
}
