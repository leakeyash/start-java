package spittr;

import lombok.*;

import java.util.Date;

/**
 * @author henry
 */
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Spittle {
    private Long id;
    private final String message;
    private final Date time;
    private Double latitude;
    private Double longitude;
}
