/**
 * @author Everett
 * @date 7/1/2021 10:53 AM
 */
package common;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class WeightedEdge {
    int start, end, weight;
}
